package crm.service;

import java.util.List;

import crm.model.Student;
import crm.repository.StudentRepository;

public class LoginService {
	private StudentRepository studentRepository = new StudentRepository();
	public boolean checkLogin(String mssv, String password) {
		List<Student>  student = studentRepository.getStudentByMSSVPassword(mssv, password);
		
		return student.size() > 0 ? true : false;
	}
}
