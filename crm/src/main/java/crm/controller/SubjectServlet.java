package crm.controller;

import crm.model.Subject;
import crm.service.SubjectService;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/subject/create", "/subject/update", "/subject/delete"})
public class SubjectServlet extends HttpServlet {

    private SubjectService subjectService = new SubjectService();
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Subject> subjects = subjectService.getAllSubjects();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

            // Trả về danh sách môn học dưới dạng JSON
            String json = gson.toJson(subjects);
            resp.getWriter().write(json);

        } catch (Exception e) {
            // Nếu có lỗi, trả về mã lỗi 500
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error retrieving subjects");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        try {
            switch (path) {
                case "/subject/create":
                    handleCreate(req, out);
                    break;
                case "/subject/update":
                    handleUpdate(req, out);
                    break;
                case "/subject/delete":
                    handleDelete(req, out);
                    break;
                default:
                    resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Unknown endpoint");
            }
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Server error: " + e.getMessage());
        }
    }

    private void handleCreate(HttpServletRequest req, PrintWriter out) throws Exception {
        Subject subject = new Subject();

        subject.setSubjectName(req.getParameter("subjectName"));
        subject.setRoomId(Integer.parseInt(req.getParameter("roomId")));
        subject.setTeacherId(Integer.parseInt(req.getParameter("teacherId")));
        subject.setPeriodsPerDay(Integer.parseInt(req.getParameter("periodsPerDay")));
        subject.setWeekPattern(Boolean.parseBoolean(req.getParameter("weekPattern")));

        String[] startTimeParams = req.getParameterValues("startTimes");
        if (startTimeParams != null && startTimeParams.length > 0) {
            LocalDateTime[] startTimes = new LocalDateTime[startTimeParams.length];
            for (int i = 0; i < startTimeParams.length; i++) {
                startTimes[i] = LocalDateTime.parse(startTimeParams[i], DATE_TIME_FORMATTER);
            }
            subject.setStartTimes(startTimes);
        }

        String endDateStr = req.getParameter("endDate");
        if (endDateStr != null && !endDateStr.isBlank()) {
            subject.setEndDate(LocalDate.parse(endDateStr, DATE_FORMATTER));
        }

        String[] studentIdsStr = req.getParameterValues("studentIds");
        if (studentIdsStr != null && studentIdsStr.length > 0) {
            List<Integer> studentIds = new ArrayList<>();
            for (String s : studentIdsStr) {
                studentIds.add(Integer.parseInt(s));
            }
            subject.setStudentIds(studentIds);
        }

        boolean success = subjectService.addSubject(subject);
        out.print(success ? "{\"status\":\"success\", \"message\":\"Subject created successfully\"}" : "{\"status\":\"failure\", \"message\":\"Failed to create subject\"}");
    }

    private void handleUpdate(HttpServletRequest req, PrintWriter out) throws Exception {
        Subject subject = new Subject();

        subject.setId(Integer.parseInt(req.getParameter("id")));
        subject.setSubjectName(req.getParameter("subjectName"));
        subject.setRoomId(Integer.parseInt(req.getParameter("roomId")));
        subject.setTeacherId(Integer.parseInt(req.getParameter("teacherId")));
        subject.setPeriodsPerDay(Integer.parseInt(req.getParameter("periodsPerDay")));
        subject.setWeekPattern(Boolean.parseBoolean(req.getParameter("weekPattern")));

        String[] startTimeParams = req.getParameterValues("startTimes");
        if (startTimeParams != null && startTimeParams.length > 0) {
            LocalDateTime[] startTimes = new LocalDateTime[startTimeParams.length];
            for (int i = 0; i < startTimeParams.length; i++) {
                startTimes[i] = LocalDateTime.parse(startTimeParams[i], DATE_TIME_FORMATTER);
            }
            subject.setStartTimes(startTimes);
        }

        String endDateStr = req.getParameter("endDate");
        if (endDateStr != null && !endDateStr.isBlank()) {
            subject.setEndDate(LocalDate.parse(endDateStr, DATE_FORMATTER));
        }

        String[] studentIdsStr = req.getParameterValues("studentIds");
        if (studentIdsStr != null && studentIdsStr.length > 0) {
            List<Integer> studentIds = new ArrayList<>();
            for (String s : studentIdsStr) {
                studentIds.add(Integer.parseInt(s));
            }
            subject.setStudentIds(studentIds);
        }

        boolean success = subjectService.updateSubject(subject);
        out.print(success ? "{\"status\":\"success\", \"message\":\"Subject updated successfully\"}" : "{\"status\":\"failure\", \"message\":\"Failed to update subject\"}");
    }

    private void handleDelete(HttpServletRequest req, PrintWriter out) throws Exception {
        String idStr = req.getParameter("id");
        if (idStr == null || idStr.isEmpty()) {
            out.print("{\"status\":\"failure\", \"message\":\"Missing parameter: id\"}");
            return;
        }
        int id = Integer.parseInt(idStr);
        boolean success = subjectService.deleteSubjectById(id);
        out.print(success ? "{\"status\":\"success\", \"message\":\"Subject deleted successfully\"}" : "{\"status\":\"failure\", \"message\":\"Failed to delete subject\"}");
    }
}
