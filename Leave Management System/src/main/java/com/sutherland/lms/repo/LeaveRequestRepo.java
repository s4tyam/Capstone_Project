package com.sutherland.lms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sutherland.lms.entity.LeaveRequest;
import com.sutherland.lms.enums.LeaveStatus;

@Repository
public interface LeaveRequestRepo extends JpaRepository<LeaveRequest, Long> {
    @Query("SELECT l FROM LeaveRequest l WHERE l.managerId = ?1 AND l.leaveStatus = ?2")
    List<LeaveRequest> findByManagerIdAndLeaveStatus(String managerId, LeaveStatus leaveStatus);

    @Query("SELECT l FROM LeaveRequest l WHERE l.employee.empId = ?1")
    List<LeaveRequest> findByEmployeeEmpId(String empId);
}
