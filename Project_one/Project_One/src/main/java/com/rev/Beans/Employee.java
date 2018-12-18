package com.rev.Beans;



public class Employee {

	public Employee(int employee_ID, int managers, String userName, String passwords, String firstName, String lastName,
			int reportsTo, int account, int reimbursment) {
		super();
		Employee_ID = employee_ID;
		Managers = managers;
		UserName = userName;
		Passwords = passwords;
		FirstName = firstName;
		LastName = lastName;
		ReportsTo = reportsTo;
		Account = account;
		Reimbursment = reimbursment;
	}
	private int Employee_ID;
	private int Managers;
	private String UserName;
	private String Passwords;
	private String FirstName;
	private String LastName;

	private int ReportsTo;
	private int Account;
	private int Reimbursment;
	public int getEmployee_ID() {
		return Employee_ID;
	}
	public void setEmployee_ID(int employee_ID) {
		Employee_ID = employee_ID;
	}
	public int getManagers() {
		return Managers;
	}
	public void setManagers(int managers) {
		Managers = managers;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPasswords() {
		return Passwords;
	}
	public void setPasswords(String passwords) {
		Passwords = passwords;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getReportsTo() {
		return ReportsTo;
	}
	public void setReportsTo(int reportsTo) {
		ReportsTo = reportsTo;
	}
	public int getAccount() {
		return Account;
	}
	public void setAccount(int account) {
		Account = account;
	}
	public int getReimbursment() {
		return Reimbursment;
	}
	public void setReimbursment(int reimbursment) {
		Reimbursment = reimbursment;
	}
	@Override
	public String toString() {
		return "Employee [Employee_ID=" + Employee_ID + ", Managers=" + Managers + ", UserName=" + UserName
				+ ", Passwords=" + Passwords + ", FirstName=" + FirstName + ", LastName=" + LastName + ", ReportsTo="
				+ ReportsTo + ", Account=" + Account + ", Reimbursment=" + Reimbursment + "]";
	}
}
