package crm.repository;

import java.sql.*;
import java.time.LocalDateTime;

import crm.config.PostgresConnection;

public class CiCoRepository {

    public int getStudentCountInRoom(int roomId) throws Exception {
        int studentCount = 0;
        LocalDateTime now = LocalDateTime.now();

        try (Connection connection = PostgresConnection.getConnection()) {
            String sql = "SELECT COUNT(*) FROM ci_co WHERE room_id = ? AND " +
                         "((checkin_time <= ? AND checkout_time >= ?) OR (checkin_time <= ? AND checkout_time IS NULL))";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, roomId);
            stmt.setTimestamp(2, Timestamp.valueOf(now));
            stmt.setTimestamp(3, Timestamp.valueOf(now));
            stmt.setTimestamp(4, Timestamp.valueOf(now));

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                studentCount = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentCount;
    }
}
