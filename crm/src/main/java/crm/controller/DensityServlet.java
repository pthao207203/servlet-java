package crm.controller;

import crm.service.DensityService;
import crm.service.DensityService.RoomDensityInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Density", urlPatterns = "/density")
public class DensityServlet extends HttpServlet {

    private DensityService densityService = new DensityService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        try {
            // Lấy danh sách các phòng học với mật độ
            List<RoomDensityInfo> roomDensityList = densityService.getRoomDensityList();

            // Chuyển danh sách phòng học sang JSON
            String json = new com.google.gson.Gson().toJson(roomDensityList);

            // Gửi danh sách JSON về client
            resp.getWriter().write(json);

        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi máy chủ: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
