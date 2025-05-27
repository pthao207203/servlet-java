package crm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import crm.config.PostgresConnection;
import crm.model.Student;

public class StudentRepository {
	public List<Student> getStudentByMSSVPassword(String mssv, String password) {
		List<Student> list = new ArrayList<>();
		try {
			Connection connection = PostgresConnection.getConnection();
			String query = "select * from students where mssv = ? and password = ? "; 
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, mssv);
			preparedStatement.setString(2, password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Student student = new Student();
				student.setId(resultSet.getInt("id"));
				student.setMssv(resultSet.getString("mssv"));
				student.setName(resultSet.getString("name"));
				student.setGender(resultSet.getString("gender"));
				student.setMajor(resultSet.getString("major"));
				
				list.add(student);
			}
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
		
		return list;
	}
	
	public boolean addStudent(Student student) {
	    try {
	        Connection connection = PostgresConnection.getConnection();
	        String sql = "INSERT INTO students (mssv, name, gender, major, password) VALUES (?, ?, ?, ?, ?)";
	        PreparedStatement stmt = connection.prepareStatement(sql);
	        stmt.setString(1, student.getMssv());
	        stmt.setString(2, student.getName());
	        stmt.setString(3, student.getGender());
	        stmt.setString(4, student.getMajor());
	        stmt.setString(5, student.getPassword());

	        int rowsInserted = stmt.executeUpdate();
	        connection.close();
	        return rowsInserted > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	public boolean updateStudent(Student student) {
	    try {
	        Connection connection = PostgresConnection.getConnection();
	        String sql = "UPDATE students SET name = ?, gender = ?, major = ?, password = ? WHERE mssv = ?";
	        PreparedStatement stmt = connection.prepareStatement(sql);
	        stmt.setString(1, student.getName());
	        stmt.setString(2, student.getGender());
	        stmt.setString(3, student.getMajor());
	        stmt.setString(4, student.getPassword());
	        stmt.setString(5, student.getMssv());

	        int rowsUpdated = stmt.executeUpdate();
	        connection.close();
	        return rowsUpdated > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	public boolean deleteStudentByMssv(String mssv) {
	    try {
	        Connection connection = PostgresConnection.getConnection();
	        String sql = "DELETE FROM students WHERE mssv = ?";
	        PreparedStatement stmt = connection.prepareStatement(sql);
	        stmt.setString(1, mssv);

	        int rowsDeleted = stmt.executeUpdate();
	        connection.close();
	        return rowsDeleted > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	public List<Student> getAllStudents() {
	    List<Student> list = new ArrayList<>();
	    try {
	        Connection connection = PostgresConnection.getConnection();
	        String sql = "SELECT * FROM students";
	        PreparedStatement stmt = connection.prepareStatement(sql);
	        ResultSet resultSet = stmt.executeQuery();

	        while (resultSet.next()) {
	            Student student = new Student();
	            student.setId(resultSet.getInt("id"));
	            student.setMssv(resultSet.getString("mssv"));
	            student.setName(resultSet.getString("name"));
	            student.setGender(resultSet.getString("gender"));
	            student.setMajor(resultSet.getString("major"));
	            list.add(student);
	        }

	        connection.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}

}
