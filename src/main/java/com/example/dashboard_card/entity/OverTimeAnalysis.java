package com.example.dashboard_card.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
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
	@Column(name = "User ID")
	private Integer userId;
	@Column(name = "Job Code")
	private String JobCode;
	@Column(name = "Job Name")
	private String jobName;
	@Column(name = "Phase Code")
	private String phaseCode;
	@Column(name = "Phase Name")
	private String phaseName;
	@Column(name = "Project Code")
	private String projectCode;
	@Column(name = "Project Name")
	private String projectName;
	@Column(name = "Estimated-Hours")
	private String estimatedHours;
	@Column(name = "status")
	private String status;
	@Column(name = "User Name")
	private String userName;
	@Column(name = "attendance-date")
	private String attendanceDate;
	@Column(name = "Job Hours")
	private String jobHours;
	@Column(name = "Job Count")
	private double jobCount;
	@Column(name = "ot1")
	private String ot1;
	@Column(name = "ot2")
	private String ot2;
	@Column(name = "Clocked Hours")
	private int clockedHours;
	@Column(name = "Overtime_Hours")
	private int overtimeHours;
	@Column(name = "department-name")
	private String departmentName;
	@Column(name = "designation")
	private String designation;
	@Column(name = "designation-name")
	private String designationName;
	@Column(name = "organization-name")
	private String organizationName;
	@Column(name = "grade-name")
	private String gradeName;
	@Column(name = "section-name")
	private String sectionName;
	@Column(name = "category-name")
	private String categoryName;
	@Column(name = "branch-name")
	private String branchName;
	@Column(name = "Cost Per Hour")
	private float costPerHour;
	@Column(name = "Cost Incurred")
	private float costIncurred;
	@Column(name = "ProjectID")
	private String projectId;
	@Column(name = "max-end-date")
	private LocalDate maxEndDate;
	@Column(name = "Project Status")
	private String projectStatus;
	@Column(name = "HasProjectStarted")
	private String hasProjectStarted;
	@Column(name = "Active Project")
	private int activeProject;
	@Column(name = "Created Datetime")
	private LocalDate createdDatetime;
	@Column(name = "Start Date Time")
	private LocalDate startDateTime;
	@Column(name = "End Date Time")
	private LocalDate endDateTime;
	@Column(name = "ProcessDate")
	private String processDate;
	@Column(name = "FHSHS")
	private String fhshs;
	@Column(name = "Day")
	private String day;
	@Column(name = "Overtime-Percent")
	private String overtimePercent;
}
