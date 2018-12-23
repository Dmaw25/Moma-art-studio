package com.rev.DaoImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.Beans.Reimbursment;
import com.rev.Dao.ReimbursmentDao;
import com.rev.Util.ConnectionUtil;

public class Reim implements ReimbursmentDao {
	private static final String filename = "connection.properties";
	@Override
	public List<Reimbursment> getListReimbursements(int employeeId) {
		List<Reimbursment> reimL = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "Select * From Reimbursment Where Employee_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			ResultSet rs = pstmt.executeQuery(); //table of the results
			while(rs.next()) {
				int remId = rs.getInt("Reimbursment_ID");
				int empId = rs.getInt("Employee_ID");
				Double amount = rs.getDouble("Amount");
				String status = rs.getString("Status");
				int image = rs.getInt("Image");
				reimL.add(new Reimbursment(remId,status, amount, image, empId));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimL;
	}

	@Override
	public void addReimbursement(int reimbursementId,int employeeId, String status, Double amount) {
		try(Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "Inert Into Reimbursment(Reimbursement_Id,Employee_ID, Amount, Status) "
					+"Values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reimbursementId);
			pstmt.setInt(2, employeeId);
			pstmt.setDouble(3, amount);
			pstmt.setString(4, status);
			pstmt.executeQuery(); //table of the results
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateReimbursement(int reimbursementId, String status) {
		try(Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "Update status " + 
					"Set status = ?" + 
					"Where Reimbursment_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, status);
			pstmt.setInt(2, reimbursementId);
			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Reimbursment> getReimbursement() {
		List<Reimbursment> reim = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "Select * " + 
					"From Reimbursments ";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int remId = rs.getInt("Reimbursment_ID");
				int empId = rs.getInt("Employee_ID");
				Double amount = rs.getDouble("Amount");
				String status = rs.getString("Status");
				int image = rs.getInt("Image");
				reim.add(new Reimbursment(remId, status, amount, image, empId));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reim;
	}

}
