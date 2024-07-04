package com.example.dashboard_card.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dashboard_card.entity.ReplacementTimeSheets;

@Repository
public interface ReplacementRepository extends JpaRepository<ReplacementTimeSheets, String> {

	@Query(value = "select * from vw_replacement_timesheet rt where rt.attendance_date between :fromDate and :toDate", nativeQuery = true)
	List<ReplacementTimeSheets> findByDate(LocalDate fromDate, LocalDate toDate);

	@Query(value = "select sum(rt.job_decimal_hours) from vw_replacement_timesheet rt where rt.attendance_date between :fromDate and :toDate", nativeQuery = true)
	Float findCountHours(LocalDate fromDate, LocalDate toDate);

}
