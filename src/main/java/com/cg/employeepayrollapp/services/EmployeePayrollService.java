package com.cg.employeepayrollapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.employeepayrollapp.dto.EmployeePayrollDTO;
import com.cg.employeepayrollapp.exceptions.EmployeePayrollException;
import com.cg.employeepayrollapp.model.EmployeePayrollData;
import com.cg.employeepayrollapp.repository.EmployeePayrollRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

	@Autowired
	private EmployeePayrollRepository employeeRepository;
	private List<EmployeePayrollData> empPayrollList = new ArrayList<>();

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return employeeRepository.findAll();
	}

	@Override
	public EmployeePayrollData getEmployeePayrollData(int empId) {
		EmployeePayrollData empData = null;
		Optional<EmployeePayrollData> empDataById = employeeRepository.findById(empId);
		if (empDataById.isPresent())
			empData = empDataById.get();
		else
			throw new EmployeePayrollException("Employee Not Found");
		return empData;
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(empPayrollList.size() + 1, empPayrollDTO);
		log.debug("Employee Data: " + empData.toString());
		return employeeRepository.save(empData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = this.getEmployeePayrollData(empId);
		empData.setName(empPayrollDTO.name);
		empData.setSalary(empPayrollDTO.salary);
		empData.setGender(empPayrollDTO.gender);
		empData.setNote(empPayrollDTO.note);
		empData.setProfilePic(empPayrollDTO.profilePic);
		empData.setStartDate(empPayrollDTO.startDate);
		empData.setDepartments(empPayrollDTO.department);
		return employeeRepository.save(empData);
	}

	@Override
	public void deleteEmployeePayrollData(int empId) {
		employeeRepository.deleteById(empId);
	}
}
