package com.rev.DaoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rev.Beans.Account;
import com.rev.Beans.Employee;
import com.rev.Beans.Reimbursment;
import com.rev.Dao.EmployeeDao;
import com.rev.Util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private List<Employee> myEmployee = new ArrayList<Employee>();
	
	public void createEmployee(Employee e) {
		myEmployee.add(e);
	}
	public Employee updateEmployee(Employee e) {
		for(Employee emp : myEmployee) {
			if(emp.getEmployee_ID() == e.getEmployee_ID())
			{
				
			}
		}
		return null;
	}

	public Employee deleteEmployee(Employee e) {
		Iterator<Employee> it = myEmployee.iterator();
		while(it.hasNext())
		{
			Employee emp = it.next();
			if(emp.getEmployee_ID() == e.getEmployee_ID())
			{
				
			}
		}
		return e;
	}
	private static final String filename = "connection.properties";
	@Override
	public List<Employee> getEmployee() {
		List<Employee> bl = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnection(filename)){	
			
		String sql = "SELECT E.Employee_ID, E.ReportsTo,Accounts.Account_ID, Accounts.Account_Type, Accounts.Balance, E.Managers, E.UserName, E.Passwords, E.FirstName,E.LastName,Reimbursments.Reimbursment_ID, Reimbursments.Status, Reimbursments.Amount, Reimbursments.Image \r\n" + 
				"				                From Employee E \r\n" + 
				"								Inner Join Accounts \r\n" + 
				"								On E.Employee_ID = Accounts.Employee_ID \r\n" + 
				"								Inner Join Reimbursments \r\n" + 
				"								On E.Employee_ID = Reimbursments.Employee_ID \r\n" + 
				"				                Order By E.Employee_ID\r\n";
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
			bl.add(new Employee(employeeId, managers, userName, password, firstName,lastName,
					 reportTo));			
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
		String sql = "SELECT E.Employee_ID, E.ReportsTo,Accounts.Account_ID, Accounts.Account_Type, Accounts.Balance, E.Managers, E.UserName, E.Passwords, E.FirstName,E.LastName,Reimbursments.Reimbursment_ID, Reimbursments.Status, Reimbursments.Amount, Reimbursments.Image \r\n" + 
				"				                From Employee E \r\n" + 
				"								Inner Join Accounts \r\n" + 
				"								On E.Employee_ID = Accounts.Employee_ID \r\n" + 
				"								Inner Join Reimbursments \r\n" + 
				"								On E.Employee_ID = Reimbursments.Employee_ID \r\n" + 
				"								Where E.Employee_ID = ?\r\n" + 
				"				                Order By E.Employee_ID\r\n";
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
			empl = new Employee(employeeId, managers, userName, password, firstName,lastName,
					 reportTo);			
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return empl;
	}

	
	public Employee addEmployee(int employee_ID, int managers, String userName, String passwords, String firstName, String lastName,
			int reportsTo, Account account, Reimbursment reimbursment) {
		Employee empl = null;
		try(Connection con = ConnectionUtil.getConnection(filename)){	
		String sql = "Insert Into Accounts\r\n" + 
				"Values(?, ?,?,?,?,?,?,?,"
				+ "?,"
				+ "?,"
				+ "?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
//		pstmt.setInt(1,);
//		pstmt.setInt(2, k);
//		pstmt.setString(3,user);
//		pstmt.setString(4,pass);
//		pstmt.setString(5,first);
//		pstmt.setString(6,last);
//		pstmt.setInt(1,report);
//		pstmt.setInt(9, acount);

		pstmt.executeUpdate();	
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return empl;
	}
	//Put in account
	public void Picture(int aID)
	{
		try(Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "Update Account Set Photo = ? Where A-ID = ?";
			PreparedStatement p = con.prepareStatement(sql);
			File blob = new File("File Path");
			FileInputStream in = new FileInputStream(blob);
			p.setBinaryStream(1, in);
			p.setInt(2, aID);
			p.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
