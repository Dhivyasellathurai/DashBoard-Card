package com.example.dashboard_card.entity;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DayAnalyseByCategory {

	private Set<String> categoryName;
	private int weekOff;
	private int workingDays;
	private int publicHolidays;

}
