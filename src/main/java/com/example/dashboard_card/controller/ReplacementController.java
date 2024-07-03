package com.example.dashboard_card.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dashboard_card.entity.ReplacementTimeSheets;
import com.example.dashboard_card.service.ReplacementService;

@RestController
@RequestMapping("/api/replace")
public class ReplacementController {

	@Autowired
	private ReplacementService service;

	@GetMapping("/getBy/Date")
	public List<ReplacementTimeSheets> getByDate(@RequestParam("fromDate") LocalDate fromDate,
			@RequestParam("toDate") LocalDate toDate) {
		return service.getByDate(fromDate, toDate);
	}
	
	

}
