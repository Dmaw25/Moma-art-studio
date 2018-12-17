package com.rev.Beans;

import java.time.LocalDate;

public class Employee {
	public Employee(int employee_ID, int managers, String userName, String passwords, String firstName, String lastName,
			String title, int reportsTo, LocalDate birthDate, LocalDate hireDate, String address, String city,
			String states, String country, String postal_Code, String phone, String fax, String email) {
		super();
		Employee_ID = employee_ID;
		Managers = managers;
		UserName = userName;
		Passwords = passwords;
		FirstName = firstName;
		LastName = lastName;
		Title = title;
		ReportsTo = reportsTo;
		BirthDate = birthDate;
		HireDate = hireDate;
		Address = address;
		City = city;
		States = states;
		Country = country;
		Postal_Code = postal_Code;
		Phone = phone;
		Fax = fax;
		Email = email;
	}
	private int Employee_ID;
	private int Managers;
	private String UserName;
	private String Passwords;
	private String FirstName;
	private String LastName;
	private String Title;
	private int ReportsTo;
	private LocalDate BirthDate;
	private LocalDate HireDate;
	private String Address;
	private String City;
	private String States;
	private String Country;
	private String Postal_Code;
	private String Phone;
    private String Fax;
	private String Email;
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
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public int getReportsTo() {
		return ReportsTo;
	}
	public void setReportsTo(int reportsTo) {
		ReportsTo = reportsTo;
	}
	public LocalDate getBirthDate() {
		return BirthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		BirthDate = birthDate;
	}
	public LocalDate getHireDate() {
		return HireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		HireDate = hireDate;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getStates() {
		return States;
	}
	public void setStates(String states) {
		States = states;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getPostal_Code() {
		return Postal_Code;
	}
	public void setPostal_Code(String postal_Code) {
		Postal_Code = postal_Code;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getFax() {
		return Fax;
	}
	public void setFax(String fax) {
		Fax = fax;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	@Override
	public String toString() {
		return "Employee [Employee_ID=" + Employee_ID + ", Managers=" + Managers + ", UserName=" + UserName
				+ ", Passwords=" + Passwords + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Title="
				+ Title + ", ReportsTo=" + ReportsTo + ", BirthDate=" + BirthDate + ", HireDate=" + HireDate
				+ ", Address=" + Address + ", City=" + City + ", States=" + States + ", Country=" + Country
				+ ", Postal_Code=" + Postal_Code + ", Phone=" + Phone + ", Fax=" + Fax + ", Email=" + Email + "]";
	}
}
