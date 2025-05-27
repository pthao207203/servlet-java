package crm.controller;

import crm.model.Student;
import crm.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/student/create", "/student/update", "/student/delete"})
public class StudentServlet extends HttpServlet {
    private StudentService studentService = new StudentService();
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        try {
            switch (path) {
                case "/student/create":
                    handleCreate(req, out);
                    break;
                case "/student/update":
                    handleUpdate(req, out);
                    break;
                case "/student/delete":
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
        Student student = new Student();
        student.setMssv(req.getParameter("mssv"));
        student.setName(req.getParameter("name"));
        student.setGender(req.getParameter("gender"));
        student.setPassword(req.getParameter("password"));
        student.setMajor(req.getParameter("major"));

        boolean success = studentService.addStudent(student);
        out.print(success ? "Student created successfully" : "Failed to create student");
    }

    private void handleUpdate(HttpServletRequest req, PrintWriter out) throws Exception {
        Student student = new Student();
        student.setMssv(req.getParameter("mssv"));
        student.setName(req.getParameter("name"));
        student.setGender(req.getParameter("gender"));
        student.setPassword(req.getParameter("password"));
        student.setMajor(req.getParameter("major"));

        boolean success = studentService.updateStudent(student);
        out.print(success ? "Student updated successfully" : "Failed to update student");
    }

    private void handleDelete(HttpServletRequest req, PrintWriter out) throws Exception {
        String mssv = req.getParameter("mssv");
        if (mssv == null || mssv.isEmpty()) {
            out.print("Missing parameter: mssv");
            return;
        }
        boolean success = studentService.deleteStudent(mssv);
        out.print(success ? "Student deleted successfully" : "Failed to delete student");
    }
}
