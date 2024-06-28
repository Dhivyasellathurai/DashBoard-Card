package com.example.dashboard_card.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dashboard_card.entity.BarchartFilter;
import com.example.dashboard_card.entity.DayAnalyseByCategory;
import com.example.dashboard_card.entity.DayFilter;
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
		List<OverTimeAnalysis> list = employeeRepository.findAllByDateRange(fromdate, toDate);
		DayAnalyseByCategory analyseByCategory = new DayAnalyseByCategory();
		Set<String> category = new HashSet<>();

		List<Double> workingDays = new ArrayList<Double>();
		List<Double> weekends = new ArrayList<Double>();
		List<Double> holidays = new ArrayList<Double>();

		for (OverTimeAnalysis ota : list) {
			switch (columnName) {
			case "projectName":
				category.add(ota.getProjectName());
				break;
			case "jobName":
				category.add(ota.getJobName());
				break;
			case "phaseName":
				category.add(ota.getPhaseName());
				break;
			case "userName":
				category.add(ota.getUserName());
				break;
			default:
				throw new IllegalArgumentException("Invalid column name: " + columnName);
			}

			switch (ota.getDay()) {
			case "Working Day":
				workingDays.add(1.00);
				break;
			case "Weekoff":
				weekends.add(1.00);
				break;
			case "Public Holiday":
				holidays.add(1.00);
				break;
			}

		}

		analyseByCategory.setCategoryName(category);
		analyseByCategory.setWorkingDays(workingDays.size());
		analyseByCategory.setWeekOff(weekends.size());
		analyseByCategory.setPublicHolidays(holidays.size());

		return analyseByCategory;
	}

	public DayFilter getDays(String columnName, String fromdate, String toDate) {
		List<OverTimeAnalysis> list = employeeRepository.findAllByDateRange(fromdate, toDate);
		List<OverTimeAnalysis> value1 = list.stream().filter(day -> day.getDay().equals("Working Day"))
				.collect(Collectors.toList());
		List<OverTimeAnalysis> value2 = list.stream().filter(day -> day.getDay().equals("Weekoff"))
				.collect(Collectors.toList());
		List<OverTimeAnalysis> value3 = list.stream().filter(day -> day.getDay().equals("Public Holiday"))
				.collect(Collectors.toList());
		DayFilter dayFilter = new DayFilter();
		dayFilter.setWeekDays(value2.size());
		dayFilter.setWorkingDays(value1.size());
		dayFilter.setPublicHolidays(value3.size());
		return dayFilter;
	}
}