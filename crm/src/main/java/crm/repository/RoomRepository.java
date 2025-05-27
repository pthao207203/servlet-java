package crm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import crm.config.PostgresConnection;
import crm.model.Room;

public class RoomRepository {

    public List<Room> getRoomsWithActiveClasses() {
        List<Room> rooms = new ArrayList<>();

        String sql = "SELECT r.*, s.start_times, s.periods_per_day, s.week_pattern, s.end_date " +
                     "FROM rooms r " +
                     "JOIN subjects s ON r.id = s.room_id " +
                     "WHERE s.end_date >= CURRENT_DATE";

        try (Connection conn = PostgresConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            LocalDateTime now = LocalDateTime.now();

            while (rs.next()) {
                // Lấy dữ liệu phòng
                int roomId = rs.getInt("id");
                int buildingId = rs.getInt("building_id");
                String name = rs.getString("name");
                int floor = rs.getInt("floor");
                String type = rs.getString("type");
                String geom = rs.getString("geom");

                // Lấy dữ liệu môn học
                java.sql.Array startTimesSqlArray = rs.getArray("start_times");
                LocalDateTime[] startTimes = (LocalDateTime[]) startTimesSqlArray.getArray();
                int periodsPerDay = rs.getInt("periods_per_day");
                boolean weekPattern = rs.getBoolean("week_pattern");
                LocalDateTime endDate = rs.getDate("end_date").toLocalDate().atStartOfDay();

                // Kiểm tra nếu môn học đang diễn ra vào thời điểm now
                boolean isActive = false;

                int cycleDays = weekPattern ? 14 : 7;  // 14 ngày nếu cách tuần, 7 ngày nếu đều tuần
                int periodMinutes = periodsPerDay * 45; // thời gian buổi học (giả sử 45 phút / tiết)

                for (LocalDateTime startTime : startTimes) {
                    // Tính khoảng cách ngày giữa tuần đầu và hiện tại
                    long daysDiff = ChronoUnit.DAYS.between(startTime.toLocalDate(), now.toLocalDate());

                    if (daysDiff < 0) {
                        // Thời gian now trước thời gian bắt đầu môn
                        continue;
                    }

                    // Kiểm tra xem ngày hiện tại có nằm trong chu kỳ học không
                    if ((daysDiff % cycleDays) == 0) {
                        // Tính thời gian bắt đầu buổi học hôm nay
                        LocalDateTime classStart = startTime.plusDays(daysDiff);

                        LocalDateTime classEnd = classStart.plusMinutes(periodMinutes);

                        // Kiểm tra giờ hiện tại có nằm trong giờ học không
                        if (!now.isBefore(classStart) && !now.isAfter(classEnd)) {
                            isActive = true;
                            break; // Không cần kiểm tra các buổi khác nữa
                        }
                    }
                }

                if (isActive) {
                    Room room = new Room();
                    room.setId(roomId);
                    room.setBuildingId(buildingId);
                    room.setName(name);
                    room.setFloor(floor);
                    room.setType(type);
                    room.setGeom(geom);
                    rooms.add(room);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rooms;
    }
}
