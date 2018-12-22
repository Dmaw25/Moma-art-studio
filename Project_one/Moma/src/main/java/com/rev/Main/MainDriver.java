package com.rev.Main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.rev.Dao.EmployeeDao;
import com.rev.DaoImpl.EmployeeDaoImpl;
import com.rev.Util.ConnectionUtil;

public class MainDriver {
	public static EmployeeDao bd = new EmployeeDaoImpl();
	public static void main(String[] args) {
		init();
		DisplayAll();
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		DisplayMine(i);
		sc.close();
	}
	static void init() {
		try {
			Connection con = ConnectionUtil.getConnection("connection.properties");
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void DisplayAll()
	{
		System.out.println(bd.getEmployee());
	}
	public static void DisplayMine(int Id)
	{
		System.out.println(bd.getEmployeeById(Id));
	}
}
