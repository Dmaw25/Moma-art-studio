package com.rev.DaoImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.rev.Beans.Employee;
import com.rev.Dao.EmployeeDao;
import com.rev.Util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	private static final String filename = "connection.properties";
	@Override
	public List<Employee> getEmployee() {
		List<Employee> bl = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnection(filename)){	
		String sql = "SELECT Employee_ID, Managers, UserName, Passwords, FirstName,LastName,\r\n" + 
				"Title, ReportsTo, BirthDate, HireDate, Address, City,\r\n" + 
				"States, Country, Postal_Code, Phone, Fax, Email\r\n"+
				"From Employee\r\n";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			int employeeId = rs.getInt("Employee_ID");
			int managers = rs.getInt("Managers");
			String userName = rs.getString("UserName");
			String password = rs.getString("Passwords");
			String firstName = rs.getString("FirstName");
			String lastName = rs.getString("LastName");
			String title = rs.getString("Title");
			int reportTo = rs.getInt("ReportsTo");
			LocalDate birthDate = rs.getDate("BirthDate").toLocalDate();
			LocalDate hireDate = rs.getDate("HireDate").toLocalDate(); 
			String address = rs.getString("Address");
			String city = rs.getString("City");
			String states = rs.getString("States");
			String country = rs.getString("Country");
			String postalCode = rs.getString("Postal_Code");
			String phone = rs.getString("Phone");
		    String fax = rs.getString("Fax");
			String email = rs.getString("Email");			
			bl.add(new Employee(employeeId, managers, userName, password, firstName,lastName,
					title, reportTo, birthDate, hireDate, address, city,
					states, country, postalCode, phone, fax, email));			
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bl;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee empl = null;
		try(Connection con = ConnectionUtil.getConnection(filename)){	
		String sql = "SELECT Employee_ID, Managers, UserName, Passwords, FirstName,LastName,\r\n" + 
				"Title, ReportsTo, BirthDate, HireDate, Address, City,\r\n" + 
				"States, Country, Postal_Code, Phone, Fax, Email\r\n"+
				"From Employee\r\n" +
				"Where Employee_ID = ?\r\n";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int employeeId = rs.getInt("Employee_ID");
			int managers = rs.getInt("Managers");
			String userName = rs.getString("UserName");
			String password = rs.getString("Passwords");
			String firstName = rs.getString("FirstName");
			String lastName = rs.getString("LastName");
			String title = rs.getString("Title");
			int reportTo = rs.getInt("ReportsTo");
			LocalDate birthDate = rs.getDate("BirthDate").toLocalDate();
			LocalDate hireDate = rs.getDate("HireDate").toLocalDate(); 
			String address = rs.getString("Address");
			String city = rs.getString("City");
			String states = rs.getString("States");
			String country = rs.getString("Country");
			String postalCode = rs.getString("Postal_Code");
			String phone = rs.getString("Phone");
		    String fax = rs.getString("Fax");
			String email = rs.getString("Email");			
			empl = new Employee(employeeId, managers, userName, password, firstName,lastName,
					title, reportTo, birthDate, hireDate, address, city,
					states, country, postalCode, phone, fax, email);			
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return empl;
	}

}