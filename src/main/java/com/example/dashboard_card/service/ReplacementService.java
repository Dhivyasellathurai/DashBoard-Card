package com.example.dashboard_card.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dashboard_card.entity.ReplacementTimeSheets;
import com.example.dashboard_card.repository.ReplacementRepository;

@Service
public class ReplacementService {

	@Autowired
	private ReplacementRepository repository;

	public List<ReplacementTimeSheets> getByDate(LocalDate fromDate, LocalDate toDate) {
		return repository.findByDate(fromDate, toDate);
	}
	
	public Object[] getReplaceHourDetails(LocalDate fromDate, LocalDate toDate) {
		List<ReplacementTimeSheets> list = findByDate(fromDate, toDate);
		return null;
	}

}
