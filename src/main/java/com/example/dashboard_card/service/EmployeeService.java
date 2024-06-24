package com.example.dashboard_card.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dashboard_card.entity.OverTimeAnalysis;
import com.example.dashboard_card.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<OverTimeAnalysis> getByName(String userName) {
		return employeeRepository.findAllByName(userName);

	}
	public List<OverTimeAnalysis> getByName() {
		return employeeRepository.findAllByName();

	}


}
