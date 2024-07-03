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
@Table(name = "vw_replacement_timesheet")
public class ReplacementTimeSheets {

	@Id
	private String userId;
	private String uid;
	private String userName;
	private LocalDate attendanceDate;
	private float jobDecimalHours;
	private String transactionType;
	private String startDateTime;
	private String endDateTime;
	private String tenantId;

}
