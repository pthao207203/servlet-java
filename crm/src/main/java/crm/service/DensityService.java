package crm.service;

import crm.repository.CiCoRepository;
import crm.repository.RoomRepository;
import crm.model.Room;

import java.util.ArrayList;
import java.util.List;

public class DensityService {

    private RoomRepository roomRepository = new RoomRepository();
    private CiCoRepository ciCoRepository = new CiCoRepository();

    /**
     * Trả về danh sách các phòng học hiện tại với thông tin về mật độ phòng
     * @return List chứa thông tin về các phòng học và mật độ
     * @throws Exception
     */
    public List<RoomDensityInfo> getRoomDensityList() throws Exception {
        List<Room> activeRooms = roomRepository.getRoomsWithActiveClasses();
        List<RoomDensityInfo> roomDensityList = new ArrayList<>();

        for (Room room : activeRooms) {
            int currentStudents = ciCoRepository.getStudentCountInRoom(room.getId());
            int maxCapacity = room.getAmount();

            // Log thông tin để kiểm tra
            System.out.println("Room ID: " + room.getId() + ", Current Students: " + currentStudents + ", Max Capacity: " + maxCapacity);

            if (maxCapacity == 0) {
                roomDensityList.add(new RoomDensityInfo(room.getId(), room.getName(), 0, "Không xác định"));
            } else {
                double densityRatio = (double) currentStudents / maxCapacity;
                String densityColor = getDensityColor(densityRatio);

                roomDensityList.add(new RoomDensityInfo(room.getId(), room.getName(), currentStudents, densityColor));
            }
        }

        return roomDensityList;
    }

    /**
     * Tính màu sắc mật độ dựa trên tỷ lệ mật độ
     * @param densityRatio tỷ lệ mật độ
     * @return String màu sắc mật độ
     */
    private String getDensityColor(double densityRatio) {
        if (densityRatio >= 0.8) {
            return "Đỏ";    // Mật độ >= 80%
        } else if (densityRatio >= 0.5) {
            return "Cam";   // Mật độ >= 50%
        } else if (densityRatio >= 0.3) {
            return "Vàng";  // Mật độ >= 30%
        } else if (densityRatio > 0) {
            return "Xanh";  // Mật độ > 0%
        } else {
            return "Trắng"; // Không có sinh viên trong phòng
        }
    }

    // Nội dung lớp RoomDensityInfo để trả về thông tin mật độ phòng
    public static class RoomDensityInfo {
        private int roomId;
        private String roomName;
        private int currentStudents;
        private String densityColor;

        public RoomDensityInfo(int roomId, String roomName, int currentStudents, String densityColor) {
            this.roomId = roomId;
            this.roomName = roomName;
            this.currentStudents = currentStudents;
            this.densityColor = densityColor;
        }

        public int getRoomId() {
            return roomId;
        }

        public String getRoomName() {
            return roomName;
        }

        public int getCurrentStudents() {
            return currentStudents;
        }

        public String getDensityColor() {
            return densityColor;
        }
    }
}
