package com.example.dashboard_card.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayAnalysis {

	public double weekDays;
	public double workingDays;
	public double publicHoliday;

}
