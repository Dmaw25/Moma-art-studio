package com.rev.DaoImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rev.Beans.Credentials;
import com.rev.Dao.CredDao;
import com.rev.Util.ConnectionUtil;

public class CredDaoImpl implements CredDao {

	private static final String filename = "connection.properties";
	@Override
	public List<Credentials> getUser() {
		List<Credentials> credL = new ArrayList<Credentials>();
		try (Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "SELECT Credentials_ID, UserName, Passwords\r\n" + 
					"From Employee\r\n" +
					"Where UserName = ? And Password = ?\r\n";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int credID = rs.getInt("Credentials_ID");
				String username = rs.getString("UserName");
				String password = rs.getString("Passwords");
				credL.add(new Credentials(credID,username,password));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Credentials> getCred() {
		// 
		return null;
	}

	@Override
	public Credentials getLogin(String username, String password) {
		Credentials cred = new Credentials(0,null,null);
		try (Connection con = ConnectionUtil.getConnection(filename)){
			String sql = "SELECT Credentials_ID, UserName, Passwords\r\n" + 
					"From Employee\r\n" +
					"Where UserName = ? And Password = ?\r\n";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int credID = rs.getInt("Credentials_ID");
				String user = rs.getString("UserName");
				String pass = rs.getString("Passwords");
				cred = new Credentials(credID,user,pass);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return cred;
	}

}
