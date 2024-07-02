package com.example.dashboard_card;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dashboard_card.entity.DayAnalyseByCategory;
import com.example.dashboard_card.entity.OverTimeAnalysis;
import com.example.dashboard_card.repository.EmployeeRepository;
import com.example.dashboard_card.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = OverTimeAnalysis.class)
public class DashBoardCardTest {

	@Mock
	EmployeeRepository repository;

	@InjectMocks
	EmployeeService service;

	@Test
	void getListByUserName() {
		OverTimeAnalysis analysis = new OverTimeAnalysis(5724, "AMC_304_2023", "AMC_304_2023 MOPH", "304A",
				"AMC_304_2023 MOPH", "AMC_304", "AMC_304_2023 MOPH ", " ", "In Progress", "Ramees Kunhi Kand",
				"25/04/2024", " ", 0.00, " ", " ", 0, 0, "Technical", "14", "Support Engineer", "Adax Security Systems",
				"Grade-1", "Support Team", "Support", "Qatar", 164.00f, 0.00f, "AMC_304", LocalDate.of(2024, 12, 31),
				"Not Finished", "Started", 1, LocalDate.of(2024, 06, 20), LocalDate.of(2024, 06, 20),
				LocalDate.of(2024, 06, 20), "25/04/2024", "XSXS", "Working Day", "321.9554093567252392757735733", 0.00);
		OverTimeAnalysis analysis1 = new OverTimeAnalysis(5725, "AMC_304_2023", "AMC_304_2023 MOPH", "304A",
				"AMC_304_2023 MOPH", "AMC_304", "AMC_304_2023 MOPH ", " ", "In Progress", "Ramees Kunhi Kand",
				"25/04/2024", " ", 0.00, " ", " ", 0, 0, "Technical", "14", "Support Engineer", "Adax Security Systems",
				"Grade-1", "Support Team", "Support", "Qatar", 164.00f, 0.00f, "AMC_304", LocalDate.of(2024, 12, 31),
				"Not Finished", "Started", 1, LocalDate.of(2024, 06, 20), LocalDate.of(2024, 06, 20),
				LocalDate.of(2024, 06, 20), "25/04/2024", "XSXS", "Working Day", "321.9554093567252392757735733", 0.00);
		OverTimeAnalysis analysis2 = new OverTimeAnalysis(5726, "AMC_304_2023", "AMC_304_2023 MOPH", "304A",
				"AMC_304_2023 MOPH", "AMC_304", "AMC_304_2023 MOPH ", " ", "In Progress", "Ramees Kunhi Kand",
				"25/04/2024", " ", 0.00, " ", " ", 0, 0, "Technical", "14", "Support Engineer", "Adax Security Systems",
				"Grade-1", "Support Team", "Support", "Qatar", 164.00f, 0.00f, "AMC_304", LocalDate.of(2024, 12, 31),
				"Not Finished", "Started", 1, LocalDate.of(2024, 06, 20), LocalDate.of(2024, 06, 20),
				LocalDate.of(2024, 06, 20), "25/04/2024", "XSXS", "Working Day", "321.9554093567252392757735733", 0.00);
		OverTimeAnalysis analysis3 = new OverTimeAnalysis(5727, "AMC_304_2023", "AMC_304_2023 MOPH", "304A",
				"AMC_304_2023 MOPH", "AMC_304", "AMC_304_2023 MOPH ", " ", "In Progress", "Ramees Kunhi Kand",
				"25/04/2024", " ", 0.00, " ", " ", 0, 0, "Technical", "14", "Support Engineer", "Adax Security Systems",
				"Grade-1", "Support Team", "Support", "Qatar", 164.00f, 0.00f, "AMC_304", LocalDate.of(2024, 12, 31),
				"Not Finished", "Started", 1, LocalDate.of(2024, 06, 20), LocalDate.of(2024, 06, 20),
				LocalDate.of(2024, 06, 20), "25/04/2024", "XSXS", "Working Day", "321.9554093567252392757735733", 0.00);
		OverTimeAnalysis analysis4 = new OverTimeAnalysis(5728, "AMC_304_2023", "AMC_304_2023 MOPH", "304A",
				"AMC_304_2023 MOPH", "AMC_304", "AMC_304_2023 MOPH ", " ", "In Progress", "Ramees Kunhi Kand",
				"25/04/2024", " ", 0.00, " ", " ", 0, 0, "Technical", "14", "Support Engineer", "Adax Security Systems",
				"Grade-1", "Support Team", "Support", "Qatar", 164.00f, 0.00f, "AMC_304", LocalDate.of(2024, 12, 31),
				"Not Finished", "Started", 1, LocalDate.of(2024, 06, 20), LocalDate.of(2024, 06, 20),
				LocalDate.of(2024, 06, 20), "25/04/2024", "XSXS", "Working Day", "321.9554093567252392757735733", 0.00);
		List<OverTimeAnalysis> list = new ArrayList<OverTimeAnalysis>();
		list.add(analysis);
		list.add(analysis1);
		list.add(analysis2);
		list.add(analysis3);
		list.add(analysis4);
		when(repository.findAllByName("Ramees Kunhi Kand")).thenReturn(list);
		when(repository.findAllByName("Dhivya")).thenReturn(Collections.emptyList());

		List<OverTimeAnalysis> actualList = service.getByName("Ramees Kunhi Kand");
		List<OverTimeAnalysis> actualList1 = service.getByName("Dhivya");
		assertEquals(list, actualList);
		assertTrue(actualList1.isEmpty());
		verify(repository, times(1)).findAllByName("Ramees Kunhi Kand");
		verify(repository, times(1)).findAllByName("Dhivya");
	}

	@Test
	void findOverTimeHoursTest() {
		when(repository.findOverTimeHours("25/04/2024", "26/04/2024")).thenReturn(5.00);
		Double cost = service.findTotalCostsForOverTime("25/04/2024", "26/04/2024");
		assertEquals(75.00, cost);
		verify(repository, times(1)).findOverTimeHours("25/04/2024", "26/04/2024");
	}

	@Test
	void findPercentageTest() {
		when(repository.findOverTimeHours("25/04/2024", "26/04/2024")).thenReturn(5.00);
		when(repository.findEstimatedHours("25/04/2024", "26/04/2024")).thenReturn(25.00);
		Double percentage = service.findPercentage("25/04/2024", "26/04/2024");
		assertEquals(20.00, percentage);
		verify(repository, times(1)).findOverTimeHours("25/04/2024", "26/04/2024");
		verify(repository, times(1)).findEstimatedHours("25/04/2024", "26/04/2024");
	}

	@Test
	void getPercentageOfProjectsTest() {

		List<String> list = new ArrayList<String>();
		list.add("Food Delivery");
		when(repository.findProjectsByDateRange("25/04/2024", "26/04/2024")).thenReturn(list);
		when(repository.findCountOfDays("Food Delivery", "25/04/2024", "26/04/2024")).thenReturn(20.00);
		when(repository.findOverTimeHoursByWeekOff("Food Delivery", "25/04/2024", "26/04/2024")).thenReturn(5.00);
		when(repository.findOverTimeHoursByWorkingDay("Food Delivery", "25/04/2024", "26/04/2024")).thenReturn(10.00);
		when(repository.findOverTimeHoursByHolidays("Food Delivery", "25/04/2024", "26/04/2024")).thenReturn(5.00);
		Double weekDay = (5.00 / 20.00) * 100;
		Double workingDay = (10.00 / 20.00) * 100;
		Double holiday = (5.00 / 20.00) * 100;
		List<Double> weeklist = new ArrayList<Double>();
		weeklist.add(weekDay);
		List<Double> workinglist = new ArrayList<Double>();
		workinglist.add(workingDay);
		List<Double> holidaylist = new ArrayList<Double>();
		holidaylist.add(holiday);
		DayAnalyseByCategory analyseByCategory = new DayAnalyseByCategory();
		analyseByCategory.setCategoryName(list);
		analyseByCategory.setWeekOff(weeklist);
		analyseByCategory.setPublicHolidays(holidaylist);
		analyseByCategory.setWorkingDays(workinglist);

		DayAnalyseByCategory category = service.getPercentageOfProjects("25/04/2024", "26/04/2024");
		assertEquals(analyseByCategory, category);
	}
}
