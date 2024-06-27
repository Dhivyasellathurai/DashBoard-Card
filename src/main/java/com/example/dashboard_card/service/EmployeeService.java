package com.example.dashboard_card.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dashboard_card.entity.BarchartFilter;
import com.example.dashboard_card.entity.DayAnalyseByCategory;
import com.example.dashboard_card.entity.OverTimeAnalysis;
import com.example.dashboard_card.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<OverTimeAnalysis> getByName(String userName) {
		return employeeRepository.findAllByName(userName);
	}

	public double findTotalCostsForOverTime(String fromDate, String ToDate) {
		double overtimeHours = employeeRepository.findOverTimeHours(fromDate, ToDate);
		Double cost = (overtimeHours * 15);
		return cost;
	}

	public double findPercentage(String fromDate, String ToDate) {
		double overtimeHours = employeeRepository.findOverTimeHours(fromDate, ToDate);
		double estimatedHours = employeeRepository.findEstimatedHours(fromDate, ToDate);
		double percentage = (overtimeHours / estimatedHours) * 100;
		return percentage;
	}

	public static Double calculatePercentage(Double totalDays, Double nrmlDay) {
		double result = (nrmlDay / totalDays) * 100;
		return result;
	}

	public Map<String, Double> findDayAnalysis(String fromDate, String toDate, String filterKey) {
		Map<String, Double> dayCountMap = new HashMap<>();
		double totalDays = (double) employeeRepository.findTotalCountOfDays(filterKey, fromDate, toDate);
		double weekDays = (double) employeeRepository.findWeekDays(filterKey, fromDate, toDate);
		double workingDays = (double) employeeRepository.findWorkingDays(filterKey, fromDate, toDate);
		double publicHolidays = (double) employeeRepository.findHoliDays(filterKey, fromDate, toDate);
		dayCountMap.put("Working Days", calculatePercentage(totalDays, workingDays));
		dayCountMap.put("Week Off Days", calculatePercentage(totalDays, weekDays));
		dayCountMap.put("Public HoliDays", calculatePercentage(totalDays, publicHolidays));
		return dayCountMap;
	}

	public DayAnalyseByCategory getByCategory(String columnName, String fromdate, String toDate) {
		List<BarchartFilter> list = employeeRepository.findAllByDateRange(fromdate, toDate);
		List<String> category = list.stream().
				filter(log ->log.getProjectName())
				.collect(Colletors.groupingBy(BarchartFilter.getProjectName(),Collectors.toList())));
				DayAnalyseByCategory analyseByCategory = new DayAnalyseByCategory();
				analyseByCategory.setCategoryName(category);
				return analyseByCategory;
	}
}