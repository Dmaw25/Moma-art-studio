package com.rev.Dao;

import java.util.List;

import com.rev.Beans.Reimbursment;

public interface ReimbursmentDao {
	List<Reimbursment> getListReimbursements(int employeeId);
	public void addReimbursement(int reimbursementId,int employeeId, String Status, Double amount);
	public void updateReimbursement(int reimbursementId, String status);
	List<Reimbursment> getReimbursement();
}
