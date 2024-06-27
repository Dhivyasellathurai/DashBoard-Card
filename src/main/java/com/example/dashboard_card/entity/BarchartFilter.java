package com.example.dashboard_card.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BarchartFilter {

	private List<String> projectName;
	private List<String> jobname;
	private List<String> userName;
	private List<String> phaseName;
	private List<String> day;

}
