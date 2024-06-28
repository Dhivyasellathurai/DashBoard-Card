package com.example.dashboard_card.entity;

import lombok.Data;

@Data
public class DayFilter {

	private int weekDays;
	private int workingDays;
	private int publicHolidays;

}
