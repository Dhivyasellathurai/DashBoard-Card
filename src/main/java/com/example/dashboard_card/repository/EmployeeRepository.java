package com.example.dashboard_card.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dashboard_card.entity.BarchartFilter;
import com.example.dashboard_card.entity.OverTimeAnalysis;

@Repository
public interface EmployeeRepository extends JpaRepository<OverTimeAnalysis, Integer> {

	@Query(value = "select * from public.overtime_analysis as oa where oa.user_name=:userName limit 5", nativeQuery = true)
	List<OverTimeAnalysis> findAllByName(String userName);

	@Query(value = "select sum(overtime_hours) from overtime_analysis oa where TO_DATE(oa.attendance_date, 'dd/mm/YYYY') BETWEEN TO_DATE(:fromDate, 'dd/mm/YYYY') AND TO_DATE(:toDate, 'dd/mm/YYYY')", nativeQuery = true)
	Double findOverTimeHours(String fromDate, String toDate);

	@Query(value = "select count(distinct oa.user_name) from overtime_analysis oa where oa.overtime_hours>0 and TO_DATE(oa.attendance_date, 'dd/mm/YYYY') BETWEEN TO_DATE(:fromDate, 'dd/mm/YYYY') AND TO_DATE(:toDate, 'dd/mm/YYYY')", nativeQuery = true)
	Integer findEmployeeCount(String fromDate, String toDate);

	@Query(value = "select sum(estimated_hours_temp) from overtime_analysis ", nativeQuery = true)
	Double findEstimatedHours(String fromDate, String toDate);

	@Query(value = "select count(oa.day) from overtime_analysis oa where (oa.project_name=:filterKey or oa.phase_name=:filterKey or oa.job_name=:filterKey or oa.user_name=:filterKey) and TO_DATE(oa.attendance_date, 'dd/mm/YYYY') BETWEEN TO_DATE(:fromDate, 'dd/mm/YYYY') AND TO_DATE(:toDate, 'dd/mm/YYYY') ", nativeQuery = true)
	Integer findTotalCountOfDays(String filterKey, String fromDate, String toDate);

	@Query(value = "select count(oa.day) from overtime_analysis oa where (oa.project_name=:filterKey or oa.phase_name=:filterKey or oa.job_name=:filterKey or oa.user_name=:filterKey) and TO_DATE(oa.attendance_date, 'dd/mm/YYYY') BETWEEN TO_DATE(:fromDate, 'dd/mm/YYYY') AND TO_DATE(:toDate, 'dd/mm/YYYY') and oa.day='Weekoff' ", nativeQuery = true)
	Integer findWeekDays(String filterKey, String fromDate, String toDate);

	@Query(value = "select count(oa.day) from overtime_analysis oa where (oa.project_name=:filterKey or oa.phase_name=:filterKey or oa.job_name=:filterKey or oa.user_name=:filterKey) and TO_DATE(oa.attendance_date, 'dd/mm/YYYY') BETWEEN TO_DATE(:fromDate, 'dd/mm/YYYY') AND TO_DATE(:toDate, 'dd/mm/YYYY') and oa.day='Working Day' ", nativeQuery = true)
	Integer findWorkingDays(String filterKey, String fromDate, String toDate);

	@Query(value = "select count(oa.day) from overtime_analysis oa where (oa.project_name=:filterKey or oa.phase_name=:filterKey or oa.job_name=:filterKey or oa.user_name=:filterKey) and TO_DATE(oa.attendance_date, 'dd/mm/YYYY') BETWEEN TO_DATE(:fromDate, 'dd/mm/YYYY') AND TO_DATE(:toDate, 'dd/mm/YYYY') and oa.day='Public Holiday' ", nativeQuery = true)
	Integer findHoliDays(String filterKey, String fromDate, String toDate);

//	@Query(value = "SELECT ?1 FROM overtime_analysis e where TO_DATE(e.attendance_date, 'dd/mm/YYYY') BETWEEN TO_DATE(:fromDate, 'dd/mm/YYYY') AND TO_DATE(:toDate, 'dd/mm/YYYY') group by :columnName", nativeQuery = true)
//	List<String> findByColumnName(@Param("columnName") String columnName, @Param("fromDate") String fromDate,
//			@Param("toDate") String toDate);

	@Query(value = "select * from overtime_analysis oa where TO_DATE(oa.attendance_date, 'dd/mm/YYYY') BETWEEN TO_DATE(:fromDate, 'dd/mm/YYYY') AND TO_DATE(:toDate, 'dd/mm/YYYY')", nativeQuery = true)
	List<BarchartFilter> findAllByDateRange(String fromDate, String toDate);
}
