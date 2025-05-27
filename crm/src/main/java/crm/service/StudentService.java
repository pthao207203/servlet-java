package crm.service;

import java.util.List;

import crm.model.Student;
import crm.repository.StudentRepository;

public class StudentService {
    private StudentRepository studentRepository = new StudentRepository();

    public boolean addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public boolean updateStudent(Student student) {
        return studentRepository.updateStudent(student);
    }

    public boolean deleteStudent(String mssv) {
        return studentRepository.deleteStudentByMssv(mssv);
    }
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }

}
