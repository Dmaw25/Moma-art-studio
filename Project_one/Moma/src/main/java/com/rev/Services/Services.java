package com.rev.Services;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.Beans.Employee;


public class Services {
	
	private ObjectMapper om = new ObjectMapper();

	public String getemployeeJSON(){
		List<Employee> employeeList = new ArrayList<>();
		String employeeString = "";
		try {
			employeeString = om.writeValueAsString(employeeList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return employeeString;
	}

}