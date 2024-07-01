package com.example.dashboard_card.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public static Double calculatePercentage(Double hours, Double totalHours) {
		if (hours == null || hours == 0) {
			return 0.00;
		}
		Double result = (hours / totalHours) * 100;
		return result;
	}

	public DayAnalyseByCategory getPercentageOfProjects(String fromdate, String toDate) {
		List<String> category = employeeRepository.findProjectsByDateRange(fromdate, toDate);
		List<Double> weeklist = new ArrayList<Double>();
		List<Double> workinglist = new ArrayList<Double>();
		List<Double> holidaylist = new ArrayList<Double>();
		for (int i = 0; i < category.size(); i++) {
			Double totalHours = employeeRepository.findCountOfDays(category.get(i), fromdate, toDate);
			Double value = employeeRepository.findOverTimeHoursByWeekOff(category.get(i), fromdate, toDate);
			weeklist.add(calculatePercentage(value, totalHours));
			Double value1 = employeeRepository.findOverTimeHoursByWorkingDay(category.get(i), fromdate, toDate);
			workinglist.add(calculatePercentage(value1, totalHours));
			Double value2 = employeeRepository.findOverTimeHoursByHolidays(category.get(i), fromdate, toDate);
			holidaylist.add(calculatePercentage(value2, totalHours));
		}
		DayAnalyseByCategory analyseByCategory = new DayAnalyseByCategory();
		analyseByCategory.setCategoryName(category);
		analyseByCategory.setWeekOff(weeklist);
		analyseByCategory.setWorkingDays(workinglist);
		analyseByCategory.setPublicHolidays(holidaylist);
		return analyseByCategory;

	}

	public DayAnalyseByCategory getPercentageOfPhase(String fromdate, String toDate) {
		List<String> category = employeeRepository.findPhaseByDateRange(fromdate, toDate);
		List<Double> weeklist = new ArrayList<Double>();
		List<Double> workinglist = new ArrayList<Double>();
		List<Double> holidaylist = new ArrayList<Double>();
		for (int i = 0; i < category.size(); i++) {
			Double totalHours = employeeRepository.findCountOfDays(category.get(i), fromdate, toDate);
			Double value = employeeRepository.findOverTimeHoursByWeekOff(category.get(i), fromdate, toDate);
			weeklist.add(calculatePercentage(value, totalHours));
			Double value1 = employeeRepository.findOverTimeHoursByWorkingDay(category.get(i), fromdate, toDate);
			workinglist.add(calculatePercentage(value1, totalHours));
			Double value2 = employeeRepository.findOverTimeHoursByHolidays(category.get(i), fromdate, toDate);
			holidaylist.add(calculatePercentage(value2, totalHours));
		}
		DayAnalyseByCategory analyseByCategory = new DayAnalyseByCategory();
		analyseByCategory.setCategoryName(category);
		analyseByCategory.setWeekOff(weeklist);
		analyseByCategory.setWorkingDays(workinglist);
		analyseByCategory.setPublicHolidays(holidaylist);
		return analyseByCategory;
	}

	public DayAnalyseByCategory getDayPercentageForJobs(String fromdate, String toDate) {
		List<String> category = employeeRepository.findJobsByDateRange(fromdate, toDate);
		List<Double> weeklist = new ArrayList<Double>();
		List<Double> workinglist = new ArrayList<Double>();
		List<Double> holidaylist = new ArrayList<Double>();
		for (int i = 0; i < category.size(); i++) {
			Double totalHours = employeeRepository.findCountOfDays(category.get(i), fromdate, toDate);
			Double value = employeeRepository.findOverTimeHoursByWeekOff(category.get(i), fromdate, toDate);
			weeklist.add(calculatePercentage(value, totalHours));
			Double value1 = employeeRepository.findOverTimeHoursByWorkingDay(category.get(i), fromdate, toDate);
			workinglist.add(calculatePercentage(value1, totalHours));
			Double value2 = employeeRepository.findOverTimeHoursByHolidays(category.get(i), fromdate, toDate);
			holidaylist.add(calculatePercentage(value2, totalHours));
		}
		DayAnalyseByCategory analyseByCategory = new DayAnalyseByCategory();
		analyseByCategory.setCategoryName(category);
		analyseByCategory.setWeekOff(weeklist);
		analyseByCategory.setWorkingDays(workinglist);
		analyseByCategory.setPublicHolidays(holidaylist);
		return analyseByCategory;
	}

	public DayAnalyseByCategory getDayPercentageForEmployee(String fromdate, String toDate) {
		List<String> category = employeeRepository.findEmployeeByDateRange(fromdate, toDate);
		List<Double> weeklist = new ArrayList<Double>();
		List<Double> workinglist = new ArrayList<Double>();
		List<Double> holidaylist = new ArrayList<Double>();
		for (int i = 0; i < category.size(); i++) {
			Double totalHours = employeeRepository.findCountOfDays(category.get(i), fromdate, toDate);
			Double value = employeeRepository.findOverTimeHoursByWeekOff(category.get(i), fromdate, toDate);
			weeklist.add(calculatePercentage(value, totalHours));
			Double value1 = employeeRepository.findOverTimeHoursByWorkingDay(category.get(i), fromdate, toDate);
			workinglist.add(calculatePercentage(value1, totalHours));
			Double value2 = employeeRepository.findOverTimeHoursByHolidays(category.get(i), fromdate, toDate);
			holidaylist.add(calculatePercentage(value2, totalHours));
		}
		DayAnalyseByCategory analyseByCategory = new DayAnalyseByCategory();
		analyseByCategory.setCategoryName(category);
		analyseByCategory.setWeekOff(weeklist);
		analyseByCategory.setWorkingDays(workinglist);
		analyseByCategory.setPublicHolidays(holidaylist);
		return analyseByCategory;
	}

	public Map<String, Object> getDayForEmployee(String fromdate, String toDate) {
		List<OverTimeAnalysis> category = employeeRepository.findAllByDate(fromdate, toDate);

		Map<String, Object> map = new HashMap<String, Object>();
			long weekDays = category.stream().filter(x -> x.getDay().equals("Weekoff"))
					.count();
			map.put("weekDay", weekDays);
			long workingDays = category.stream().filter(x -> x.getDay().equals("Working Day"))
					.count();
			map.put("WorkingDay", workingDays);
			long Holiday = category.stream().filter(x -> x.getDay().equals("Public Holiday"))
					.count();
			map.put("Holiday", Holiday);
		

		return map;
	}
}