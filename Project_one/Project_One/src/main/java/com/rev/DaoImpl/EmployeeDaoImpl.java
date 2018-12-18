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
				"ReportsTo, Account, Reimbursment\r\n"+
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
			int reportTo = rs.getInt("ReportsTo");
			int account = rs.getInt("Account");
			int reimbursment = rs.getInt("Reimbursment");		
			bl.add(new Employee(employeeId, managers, userName, password, firstName,lastName,
					 reportTo, account, reimbursment));			
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
				"ReportsTo, Account, Reimbursment"+
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
			int reportTo = rs.getInt("ReportsTo");
			int account = rs.getInt("Account");
			int reimbursment = rs.getInt("Reimbursment");
			
			empl = new Employee(employeeId, managers, userName, password, firstName,lastName,
					 reportTo, account, reimbursment);			
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return empl;
	}

	@Override
	public Employee addEmployee(int j, int k, String user, String pass, String first, String last, String title, int report, LocalDate birth, LocalDate hired, String adress,String city,String state, String coun,String postal,String phone, String fax, String email) {
		Employee empl = null;
		try(Connection con = ConnectionUtil.getConnection(filename)){	
		String sql = "Insert Into Accounts\r\n" + 
				"Values(?, ?,?,?,?,?,?,?,"
				+ "?,"
				+ "?,"
				+ "?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,j);
		pstmt.setInt(2, k);
		pstmt.setString(3,user);
		pstmt.setString(4,pass);
		pstmt.setString(5,first);
		pstmt.setString(6,last);
		pstmt.setString(7, title);
		pstmt.setInt(1,report);
		//pstmt.setDate(1,birth);
		//pstmt.setDate(1,hired);
		pstmt.setString(1,adress);
		pstmt.setString(1,city);
		pstmt.setString(1, state);
		pstmt.setString(1,coun);
		pstmt.setString(1,postal);
		pstmt.setString(1,phone);
		pstmt.setString(1,fax);
		pstmt.setString(1,email);
		pstmt.executeUpdate();	
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return empl;
	}

}
