package com.rev.Beans;

public class Account {
	public Account(int account_ID, String account_Type, double balance) {
		super();
		Account_ID = account_ID;
		Account_Type = account_Type;
		Balance = balance;
	}
	private int Account_ID;
	private String Account_Type;
	private double Balance;
	public int getAccount_ID() {
		return Account_ID;
	}
	public void setAccount_ID(int account_ID) {
		Account_ID = account_ID;
	}
	public String getAccount_Type() {
		return Account_Type;
	}
	public void setAccount_Type(String account_Type) {
		Account_Type = account_Type;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Account_ID;
		result = prime * result + ((Account_Type == null) ? 0 : Account_Type.hashCode());
		long temp;
		temp = Double.doubleToLongBits(Balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Account other = (Account) obj;
		if (Account_ID != other.Account_ID)
			return false;
		if (Account_Type == null) {
			if (other.Account_Type != null)
				return false;
		} else if (!Account_Type.equals(other.Account_Type))
			return false;
		if (Double.doubleToLongBits(Balance) != Double.doubleToLongBits(other.Balance))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Account [Account_ID=" + Account_ID + ", Account_Type=" + Account_Type + ", Balance=" + Balance + "]";
	}
}
