package com.example.dashboard_card.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dashboard_card.entity.OverTimeAnalysis;

@Repository
public interface EmployeeRepository extends JpaRepository<OverTimeAnalysis, Integer> {

	@Query(value = "select * from public.overtime_analysis as oa where oa.user_name=:userName limit 5", nativeQuery = true)
	List<OverTimeAnalysis> findAllByName(String userName);


	@Query (value = "select sum(ot1) from overtime_analysis oa where oa.attendance_date between :fromDate to :toDate", nativeQuery = true)
	Double findOverTimeHours(String fromDate, String toDate);

}
