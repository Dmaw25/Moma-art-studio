package com.rev.Beans;



public class Employee {
	public Employee(int employee_ID, int managers, String userName, String passwords, String firstName, String lastName,
			int reportsTo, Account account, Reimbursment reimbursment){
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
	private Account Account;
	private Reimbursment Reimbursment;
	
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
	public Account getAccount() {
		return Account;
	}
	public void setAccount(Account account) {
		Account = account;
	}
	public Reimbursment getReimbursment() {
		return Reimbursment;
	}
	public void setReimbursment(Reimbursment reimbursment) {
		Reimbursment = reimbursment;
	}
	@Override
	public String toString() {
		return "Employee [Employee_ID=" + Employee_ID + ", Managers=" + Managers + ", UserName=" + UserName
				+ ", Passwords=" + Passwords + ", FirstName=" + FirstName + ", LastName=" + LastName + ", ReportsTo="
				+ ReportsTo + ", Account=" + Account + ", Reimbursment=" + Reimbursment + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Account == null) ? 0 : Account.hashCode());
		result = prime * result + Employee_ID;
		result = prime * result + ((FirstName == null) ? 0 : FirstName.hashCode());
		result = prime * result + ((LastName == null) ? 0 : LastName.hashCode());
		result = prime * result + Managers;
		result = prime * result + ((Passwords == null) ? 0 : Passwords.hashCode());
		result = prime * result + ((Reimbursment == null) ? 0 : Reimbursment.hashCode());
		result = prime * result + ReportsTo;
		result = prime * result + ((UserName == null) ? 0 : UserName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (Account == null) {
			if (other.Account != null)
				return false;
		} else if (!Account.equals(other.Account))
			return false;
		if (Employee_ID != other.Employee_ID)
			return false;
		if (FirstName == null) {
			if (other.FirstName != null)
				return false;
		} else if (!FirstName.equals(other.FirstName))
			return false;
		if (LastName == null) {
			if (other.LastName != null)
				return false;
		} else if (!LastName.equals(other.LastName))
			return false;
		if (Managers != other.Managers)
			return false;
		if (Passwords == null) {
			if (other.Passwords != null)
				return false;
		} else if (!Passwords.equals(other.Passwords))
			return false;
		if (Reimbursment == null) {
			if (other.Reimbursment != null)
				return false;
		} else if (!Reimbursment.equals(other.Reimbursment))
			return false;
		if (ReportsTo != other.ReportsTo)
			return false;
		if (UserName == null) {
			if (other.UserName != null)
				return false;
		} else if (!UserName.equals(other.UserName))
			return false;
		return true;
	}
}
