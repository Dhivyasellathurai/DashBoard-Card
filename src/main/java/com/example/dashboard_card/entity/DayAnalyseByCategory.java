package com.example.dashboard_card.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DayAnalyseByCategory {

	List<String> categoryName;
	List<String> weekOff;
	List<String> workingDays;
	List<String> publicHolidays;

}
