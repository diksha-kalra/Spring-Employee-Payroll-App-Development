package com.cg.employeepayrollapp.services;

import java.util.List;
import com.cg.employeepayrollapp.dto.EmployeePayrollDTO;
import com.cg.employeepayrollapp.model.EmployeePayrollData;

public interface IEmployeePayrollService {

	List<EmployeePayrollData> getEmployeePayrollData();

	EmployeePayrollData getEmployeePayrollData(int empId);

	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);

	void deleteEmployeePayrollData(int empId);

	EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeeDTO);
}
