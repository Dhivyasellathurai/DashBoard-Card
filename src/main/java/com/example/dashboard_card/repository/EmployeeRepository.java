package com.example.dashboard_card.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.dashboard_card.entity.OverTimeAnalysis;

@Repository
public interface EmployeeRepository extends JpaRepository<OverTimeAnalysis, Integer> {

	@Query(value = "select * from public.overtime_analysis as oa where oa.user_name=:userName limit 5", nativeQuery = true)
	List<OverTimeAnalysis> findAllByName(String userName);

	@Query(value = "select sum(overtime_hours) from overtime_analysis oa where TO_DATE(oa.attendance_date, 'dd/mm/YYYY') BETWEEN TO_DATE(:fromDate, 'dd/mm/YYYY') AND TO_DATE(:toDate, 'dd/mm/YYYY')", nativeQuery = true)
	Double findOverTimeHours(String fromDate, String toDate);

	@Query(value = "select count(distinct oa.user_name) from overtime_analysis oa where oa.overtime_hours>0 and TO_DATE(oa.attendance_date, 'dd/mm/YYYY') BETWEEN TO_DATE(:fromDate, 'dd/mm/YYYY') AND TO_DATE(:toDate, 'dd/mm/YYYY')", nativeQuery = true)
	Integer findEmployeeCount(String fromDate, String toDate);

	@Query(value = "select sum(estimated_hours_temp) from overtime_analysis oa where TO_DATE(oa.attendance_date, 'dd/mm/YYYY') BETWEEN TO_DATE(:fromDate, 'dd/mm/YYYY') AND TO_DATE(:toDate, 'dd/mm/YYYY')", nativeQuery = true)
	Double findEstimatedHours(String fromDate, String toDate);

	@Query(value = "select distinct oa.project_name from overtime_analysis oa where oa.overtime_hours > 0 and TO_DATE(oa.attendance_date, 'dd/mm/YYYY') BETWEEN TO_DATE(:fromDate, 'dd/mm/YYYY') AND TO_DATE(:toDate, 'dd/mm/YYYY') and (oa.project_name!='null' and oa.project_name!='')", nativeQuery = true)
	List<String> findProjectsByDateRange(String fromDate, String toDate);

	@Query(value = "select oa.phase_name from overtime_analysis oa where oa.overtime_hours > 0 and TO_DATE(oa.attendance_date, 'dd/mm/YYYY') BETWEEN TO_DATE(:fromDate, 'dd/mm/YYYY') AND TO_DATE(:toDate, 'dd/mm/YYYY') group by oa.phase_name", nativeQuery = true)
	List<String> findPhaseByDateRange(String fromDate, String toDate);

	@Query(value = "select oa.user_name from overtime_analysis oa where oa.overtime_hours > 0 and TO_DATE(oa.attendance_date, 'dd/mm/YYYY') BETWEEN TO_DATE(:fromDate, 'dd/mm/YYYY') AND TO_DATE(:toDate, 'dd/mm/YYYY') group by oa.user_name", nativeQuery = true)
	List<String> findEmployeeByDateRange(String fromDate, String toDate);

	@Query(value = "select oa.job_name from overtime_analysis oa where oa.overtime_hours > 0 and TO_DATE(oa.attendance_date, 'dd/mm/YYYY') BETWEEN TO_DATE(:fromDate, 'dd/mm/YYYY') AND TO_DATE(:toDate, 'dd/mm/YYYY') group by oa.job_name", nativeQuery = true)
	List<String> findJobsByDateRange(String fromDate, String toDate);

	@Query(value = " select sum(oa.overtime_hours) from overtime_analysis oa where (oa.project_name=:value or oa.job_name=:value or oa.phase_name=:value or oa.user_name=:value) and oa.day='Weekoff' and oa.overtime_hours > 0 and TO_DATE(oa.attendance_date, 'dd/mm/YYYY') BETWEEN TO_DATE(:fromDate, 'dd/mm/YYYY') AND TO_DATE(:toDate, 'dd/mm/YYYY') ", nativeQuery = true)
	Double findOverTimeHoursByWeekOff(String value, String fromDate, String toDate);

	@Query(value = " select sum(oa.overtime_hours) from overtime_analysis oa where oa.overtime_hours > 0 and (oa.project_name=:value or oa.job_name=:value or oa.phase_name=:value or oa.user_name=:value) and oa.day='Working Day' and TO_DATE(oa.attendance_date, 'dd/mm/YYYY') BETWEEN TO_DATE(:fromDate, 'dd/mm/YYYY') AND TO_DATE(:toDate, 'dd/mm/YYYY') ", nativeQuery = true)
	Double findOverTimeHoursByWorkingDay(String value, String fromDate, String toDate);

	@Query(value = " select sum(oa.overtime_hours) from overtime_analysis oa where oa.overtime_hours > 0 and (oa.project_name=:value or oa.job_name=:value or oa.phase_name=:value or oa.user_name=:value) and oa.day='Public Holiday' and TO_DATE(oa.attendance_date, 'dd/mm/YYYY') BETWEEN TO_DATE(:fromDate, 'dd/mm/YYYY') AND TO_DATE(:toDate, 'dd/mm/YYYY') ", nativeQuery = true)
	Double findOverTimeHoursByHolidays(String value, String fromDate, String toDate);

	@Query(value = "select sum(oa.overtime_hours) from overtime_analysis oa where oa.overtime_hours > 0 and TO_DATE(oa.attendance_date, 'dd/mm/YYYY') BETWEEN TO_DATE(:fromDate, 'dd/mm/YYYY') AND TO_DATE(:toDate, 'dd/mm/YYYY') and (oa.project_name=:value or oa.job_name=:value or oa.phase_name=:value or oa.user_name=:value)", nativeQuery = true)
	Double findCountOfDays(String value, String fromDate, String toDate);

	@Query(value = "select * from public.overtime_analysis as oa where oa.overtime_hours > 0 and TO_DATE(oa.attendance_date, 'dd/mm/YYYY') BETWEEN TO_DATE(:fromDate, 'dd/mm/YYYY') AND TO_DATE(:toDate, 'dd/mm/YYYY')", nativeQuery = true)
	List<OverTimeAnalysis> findAllByDate(String fromDate, String toDate);

}
