package com.example.dashboard_card.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dashboard_card.entity.OverTimeAnalysis;
import com.example.dashboard_card.service.EmployeeService;

@RestController
@RequestMapping("/api/employeeLog")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getByUserName")
	public List<OverTimeAnalysis> getAllByName(@RequestParam("value = userName") String userName) {
		return employeeService.getByName(userName);
	}

	@GetMapping("/get/OverTime/analysis")
	public Double getByFilter(@RequestParam("FromDate") String FromDate, @RequestParam("ToDate") String ToDate) {
		return employeeService.getByFilter(FromDate, ToDate);
	}
}
