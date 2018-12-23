package com.rev.Beans;

public class Reimbursment {
	public Reimbursment(int rEIMBURSMENT_ID, String sTATUS, double aMOUNT, int iMAGE, int employee_ID) {
		super();
		REIMBURSMENT_ID = rEIMBURSMENT_ID;
		STATUS = sTATUS;
		AMOUNT = aMOUNT;
		IMAGE = iMAGE;
		Employee_ID = employee_ID;
	}
	private int REIMBURSMENT_ID;
	private String STATUS;
	private double AMOUNT;
	private int IMAGE;
	private int Employee_ID;
	public int getREIMBURSMENT_ID() {
		return REIMBURSMENT_ID;
	}
	public void setREIMBURSMENT_ID(int rEIMBURSMENT_ID) {
		REIMBURSMENT_ID = rEIMBURSMENT_ID;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public double getAMOUNT() {
		return AMOUNT;
	}
	public void setAMOUNT(double aMOUNT) {
		AMOUNT = aMOUNT;
	}
	public int getIMAGE() {
		return IMAGE;
	}
	public void setIMAGE(int iMAGE) {
		IMAGE = iMAGE;
	}
	@Override
	public String toString() {
		return "Reimbursment [REIMBURSMENT_ID=" + REIMBURSMENT_ID + ", STATUS=" + STATUS + ", AMOUNT=" + AMOUNT
				+ ", IMAGE=" + IMAGE + ", Employee_ID=" + Employee_ID + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(AMOUNT);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Employee_ID;
		result = prime * result + IMAGE;
		result = prime * result + REIMBURSMENT_ID;
		result = prime * result + ((STATUS == null) ? 0 : STATUS.hashCode());
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
		Reimbursment other = (Reimbursment) obj;
		if (Double.doubleToLongBits(AMOUNT) != Double.doubleToLongBits(other.AMOUNT))
			return false;
		if (Employee_ID != other.Employee_ID)
			return false;
		if (IMAGE != other.IMAGE)
			return false;
		if (REIMBURSMENT_ID != other.REIMBURSMENT_ID)
			return false;
		if (STATUS == null) {
			if (other.STATUS != null)
				return false;
		} else if (!STATUS.equals(other.STATUS))
			return false;
		return true;
	}
	public int getEmployee_ID() {
		return Employee_ID;
	}
	public void setEmployee_ID(int employee_ID) {
		Employee_ID = employee_ID;
	}
}
