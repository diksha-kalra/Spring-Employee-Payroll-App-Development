package com.cg.employeepayrollapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.employeepayrollapp.dto.EmployeePayrollDTO;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<String> getEmployeePayrollData() {
		return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
	}

	@GetMapping("/get/{empId}")
	public ResponseEntity<String> getEmployeePayrollData(@PathVariable("empId") int empId) {
		return new ResponseEntity<String>("Get Call Success for ID: " + empId, HttpStatus.OK);
	}

	@PostMapping("/post")
	public ResponseEntity<String> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeeDTO) {
		return new ResponseEntity<String>("Created Employee Payroll Data for:  " + employeeDTO, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeeDTO) {
		return new ResponseEntity<String>("Updated Employee Payroll Data for:  " + employeeDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
		return new ResponseEntity<String>("Delete Call Success for ID: " + empId, HttpStatus.OK);
	}
}