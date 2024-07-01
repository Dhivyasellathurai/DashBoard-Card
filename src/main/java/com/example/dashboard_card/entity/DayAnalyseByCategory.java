package com.example.dashboard_card.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayAnalyseByCategory {

	private List<String> categoryName;
	private List<Double> weekOff;
	private List<Double> workingDays;
	private List<Double> publicHolidays;

}
