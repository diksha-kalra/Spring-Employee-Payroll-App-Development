package com.cg.employeepayrollapp.model;

import java.time.LocalDate;
import java.util.List;
import com.cg.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;

public @Data class EmployeePayrollData {
	private int employeeId;
	private String name;
	private long salary;
	private String gender;
	private LocalDate startDate;
	private String note;
	private String profilePic;
	private List<String> departments;
	

	public EmployeePayrollData() {
	}

	public EmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
		this.employeeId = empId;
		this.name = employeePayrollDTO.name;
		this.salary = employeePayrollDTO.salary;
		this.gender=employeePayrollDTO.gender;
		this.startDate=employeePayrollDTO.startDate;
		this.note=employeePayrollDTO.note;
		this.profilePic=employeePayrollDTO.profilePic;
		this.departments=employeePayrollDTO.department;
	}
}
