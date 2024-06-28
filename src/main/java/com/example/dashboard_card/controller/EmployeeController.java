package com.example.dashboard_card.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dashboard_card.entity.DayAnalyseByCategory;
import com.example.dashboard_card.entity.DayFilter;
import com.example.dashboard_card.entity.OverTimeAnalysis;
import com.example.dashboard_card.repository.EmployeeRepository;
import com.example.dashboard_card.service.EmployeeService;

@RestController
@RequestMapping("/api/employeeLog")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/getByUserName")
	public List<OverTimeAnalysis> getAllByName(@RequestParam("value = userName") String userName) {
		return employeeService.getByName(userName);
	}

	@GetMapping("/get/OverTime/analysis")
	public Map<String, Object> getByFilter(@RequestParam("FromDate") String FromDate,
			@RequestParam("ToDate") String ToDate) {
		Map<String, Object> map = new HashMap<String, Object>();
		Double OverTimeHours = employeeRepository.findOverTimeHours(FromDate, ToDate);
		Integer employeeCount = employeeRepository.findEmployeeCount(FromDate, ToDate);
		Double cost = employeeService.findTotalCostsForOverTime(FromDate, ToDate);
		map.put("OverTime Hours", OverTimeHours);
		map.put("Employee's with overtime", employeeCount);
		map.put("TotalCost", cost);
		map.put("OverTime percentage", employeeService.findPercentage(FromDate, ToDate));
		return map;

	}

	@GetMapping("get/workingDay/analysis")
	public Map<String, Double> getWorkingDayAnalysis(@RequestParam("FromDate") String FromDate,
			@RequestParam("ToDate") String ToDate, @RequestParam("filterKey") String filterKey) {
		return employeeService.findDayAnalysis(FromDate, ToDate, filterKey);
	}

	@GetMapping("get/dayRange")
	public DayAnalyseByCategory getAll(@RequestParam("filterKey") String filterKey,
			@RequestParam("FromDate") String FromDate, @RequestParam("ToDate") String ToDate) {
		return employeeService.getByCategory(filterKey, FromDate, ToDate);

	}

	@GetMapping("/getAll")
	 public DayFilter getDays(String columnName, String fromdate, String toDate) {
		return employeeService.getDays(columnName, fromdate, toDate);
	}
}
