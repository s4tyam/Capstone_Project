package com.sutherland.lms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sutherland.lms.entity.LeaveRequest;

@Repository
public interface LeaveRequestRepo extends JpaRepository<LeaveRequest, Integer>{
	
	@Query("select obj from LeaveRequest obj where obj.empId = ?1")
    List<LeaveRequest> getAllLeaveRequestsByEmployeeId(String empId);

    @Query("select obj from LeaveRequest obj where obj.empId = ?1")
    List<LeaveRequest> getAllLeaveRequestsByManagerId(String managerId);
}
