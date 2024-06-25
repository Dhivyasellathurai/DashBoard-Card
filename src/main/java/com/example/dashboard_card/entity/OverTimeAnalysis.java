package com.example.dashboard_card.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "overtime_analysis")
public class OverTimeAnalysis {

	@Id
	private Integer userId;
	private String JobCode;
	private String jobName;
	private String phaseCode;
	private String phaseName;
	private String projectCode;
	private String projectName;
	private String estimatedHours;
	private String status;
	private String userName;
	private String attendanceDate;
	private String jobHours;
	private Double jobCount;
	private String ot1;
	private String ot2;
	private Integer clockedHours;
	private Integer overtimeHours;
	private String departmentName;
	private String designation;
	private String designationName;
	private String organizationName;
	private String gradeName;
	private String sectionName;
	private String categoryName;
	private String branchName;
	private Float costPerHour;
	private Float costIncurred;
	private String projectId;
	private LocalDate maxEndDate;
	private String projectStatus;
	private String hasProjectStarted;
	private Integer activeProject;
	private LocalDate createdDatetime;
	private LocalDate startDateTime;
	private LocalDate endDateTime;
	private String processDate;
	private String fhshs;
	private String day;
	private String overtimePercent;
}
