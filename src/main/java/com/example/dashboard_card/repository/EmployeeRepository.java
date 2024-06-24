package com.example.dashboard_card.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dashboard_card.entity.OverTimeAnalysis;

@Repository
public interface EmployeeRepository extends JpaRepository<OverTimeAnalysis, Integer> {

	@Query(value = "select * from public.overtime_analysis as oa where oa.\"User Name\" =:userName limit 5", nativeQuery = true)
	List<OverTimeAnalysis> findAllByName(String userName);

	@Query(value = "select distinct oa.\"designation-name\" from public.overtime_analysis as oa", nativeQuery = true)
	List<OverTimeAnalysis> findAllByName();

}
