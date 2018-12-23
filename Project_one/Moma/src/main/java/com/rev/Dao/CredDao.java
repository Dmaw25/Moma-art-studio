package com.rev.Dao;

import java.util.List;

import com.rev.Beans.Credentials;

public interface CredDao {
	public List<Credentials> getUser();
	public List<Credentials> getCred();
	public Credentials getLogin(String username, String password);
}
