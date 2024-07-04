package com.example.dashboard_card.service;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dashboard_card.entity.ReplacementTimeSheets;
import com.example.dashboard_card.entity.WeeklyHours;
import com.example.dashboard_card.repository.ReplacementRepository;

@Service
public class ReplacementService {

	@Autowired
	private ReplacementRepository repository;

	public List<ReplacementTimeSheets> getByDate(LocalDate fromDate, LocalDate toDate) {
		return repository.findByDate(fromDate, toDate);
	}

	public WeeklyHours getReplaceHourDetails() {
		LocalDate toDate = LocalDate.now();
		LocalDate fromDate = toDate.minusMonths(2);
		WeeklyHours hours = new WeeklyHours();
		List<String> weekDays = getDayList(fromDate, toDate);
		List<Float> countHours = new ArrayList<Float>();
		LocalDate startDate = fromDate;
		LocalDate endDate = startDate.plusDays(6);

		while (endDate.isBefore(toDate) || endDate.equals(toDate)) {
			float totalHours = repository.findCountHours(startDate, endDate);
			if (totalHours == 0) {
				countHours.add((float) 0);
			}
			countHours.add(totalHours);
			startDate = startDate.plusDays(7);
			endDate = startDate.plusDays(6);
		}
		if (endDate.isAfter(toDate)) {
			endDate = toDate;
			Float totalHours = repository.findCountHours(startDate, endDate);
	
			countHours.add(totalHours);
		}
		hours.setDay(weekDays);
		hours.setClockedHours(countHours);
		return hours;
	}

	public List<String> getDayList(LocalDate fromDate, LocalDate toDate) {
		List<String> list = new ArrayList<String>();
		LocalDate futureDate = fromDate;
		while (futureDate.isBefore(toDate)) {
			String month = futureDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
			int day = futureDate.getDayOfMonth();
			String formattedDate = month + " " + day;
			list.add(formattedDate);
			futureDate = futureDate.plusDays(7);
		}
		return list;
	}
}
