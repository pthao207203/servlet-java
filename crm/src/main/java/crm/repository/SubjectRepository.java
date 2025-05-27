package crm.repository;

import java.sql.Connection;
import crm.config.PostgresConnection;
import crm.model.Subject;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class SubjectRepository {

    public boolean addSubject(Subject subject) throws Exception {
        try (Connection connection = PostgresConnection.getConnection()) {
            String sql = "INSERT INTO subjects (room_id, subject_name, teacher_id, start_times, periods_per_day, week_pattern, end_date, student_ids) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, subject.getRoomId());
            stmt.setString(2, subject.getSubjectName());
            stmt.setInt(3, subject.getTeacherId());

            // Chuyển LocalDateTime[] sang java.sql.Timestamp[]
            LocalDateTime[] startTimes = subject.getStartTimes();
            if (startTimes != null) {
                Timestamp[] timestamps = new Timestamp[startTimes.length];
                for (int i = 0; i < startTimes.length; i++) {
                    timestamps[i] = Timestamp.valueOf(startTimes[i]);
                }
                Array sqlArray = connection.createArrayOf("timestamp", timestamps);
                stmt.setArray(4, sqlArray);
            } else {
                stmt.setNull(4, Types.ARRAY);
            }

            stmt.setInt(5, subject.getPeriodsPerDay());
            stmt.setBoolean(6, subject.isWeekPattern());

            LocalDate endDate = subject.getEndDate();
            if (endDate != null) {
                stmt.setDate(7, Date.valueOf(endDate));
            } else {
                stmt.setNull(7, Types.DATE);
            }

            List<Integer> studentIds = subject.getStudentIds();
            if (studentIds != null) {
                Integer[] studentIdsArray = studentIds.toArray(new Integer[0]);
                Array sqlArray = connection.createArrayOf("integer", studentIdsArray);
                stmt.setArray(8, sqlArray);
            } else {
                stmt.setNull(8, Types.ARRAY);
            }

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateSubject(Subject subject) throws Exception {
        try (Connection connection = PostgresConnection.getConnection()) {
            String sql = "UPDATE subjects SET room_id = ?, subject_name = ?, teacher_id = ?, start_times = ?, " +
                         "periods_per_day = ?, week_pattern = ?, end_date = ?, student_ids = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, subject.getRoomId());
            stmt.setString(2, subject.getSubjectName());
            stmt.setInt(3, subject.getTeacherId());

            LocalDateTime[] startTimes = subject.getStartTimes();
            if (startTimes != null) {
                Timestamp[] timestamps = new Timestamp[startTimes.length];
                for (int i = 0; i < startTimes.length; i++) {
                    timestamps[i] = Timestamp.valueOf(startTimes[i]);
                }
                Array sqlArray = connection.createArrayOf("timestamp", timestamps);
                stmt.setArray(4, sqlArray);
            } else {
                stmt.setNull(4, Types.ARRAY);
            }

            stmt.setInt(5, subject.getPeriodsPerDay());
            stmt.setBoolean(6, subject.isWeekPattern());

            LocalDate endDate = subject.getEndDate();
            if (endDate != null) {
                stmt.setDate(7, Date.valueOf(endDate));
            } else {
                stmt.setNull(7, Types.DATE);
            }

            List<Integer> studentIds = subject.getStudentIds();
            if (studentIds != null) {
                Integer[] studentIdsArray = studentIds.toArray(new Integer[0]);
                Array sqlArray = connection.createArrayOf("integer", studentIdsArray);
                stmt.setArray(8, sqlArray);
            } else {
                stmt.setNull(8, Types.ARRAY);
            }

            stmt.setInt(9, subject.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteSubjectById(int id) throws Exception {
        try (Connection connection = PostgresConnection.getConnection()) {
            String sql = "DELETE FROM subjects WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Subject> getAllSubjects() throws Exception {
        List<Subject> list = new ArrayList<>();
        try (Connection connection = PostgresConnection.getConnection()) {
            String sql = "SELECT * FROM subjects";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Subject subject = new Subject();

                subject.setId(rs.getInt("id"));
                subject.setRoomId(rs.getInt("room_id"));
                subject.setSubjectName(rs.getString("subject_name"));
                subject.setTeacherId(rs.getInt("teacher_id"));
                subject.setPeriodsPerDay(rs.getInt("periods_per_day"));
                subject.setWeekPattern(rs.getBoolean("week_pattern"));

                Date sqlEndDate = rs.getDate("end_date");
                if (sqlEndDate != null) {
                    subject.setEndDate(sqlEndDate.toLocalDate());
                } else {
                    subject.setEndDate(null);
                }

                Array startTimesArray = rs.getArray("start_times");
                if (startTimesArray != null) {
                    Timestamp[] times = (Timestamp[]) startTimesArray.getArray();
                    LocalDateTime[] startTimes = new LocalDateTime[times.length];
                    for (int i = 0; i < times.length; i++) {
                        startTimes[i] = times[i].toLocalDateTime();
                    }
                    subject.setStartTimes(startTimes);
                } else {
                    subject.setStartTimes(null);
                }

                Array studentIdsArray = rs.getArray("student_ids");
                if (studentIdsArray != null) {
                    Integer[] studentIds = (Integer[]) studentIdsArray.getArray();
                    subject.setStudentIds(new ArrayList<>(List.of(studentIds)));
                } else {
                    subject.setStudentIds(null);
                }

                list.add(subject);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

