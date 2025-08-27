package com.sutherland.lms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sutherland.lms.entity.Employee;
import com.sutherland.lms.entity.LeaveRequest;
import com.sutherland.lms.enums.LeaveStatus;
import com.sutherland.lms.repo.LeaveRequestRepo;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService{

	@Autowired
	LeaveRequestRepo repo;
	
	@Override
	public void applyForLeave(LeaveRequest leave) {
		leave.setDateApplied(LocalDate.now());
		leave.setLeaveStatus(LeaveStatus.APPLIED);

		long numberOfDays = leave.getToDate().toEpochDay() - leave.getFromDate().toEpochDay() + 1;
		leave.setNumberOfDays((int) numberOfDays);
		
		repo.save(leave);
	}
	
	@Override
	public LeaveRequest cancelLeave(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LeaveRequest withDrawLeave(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LeaveStatus checkStatus(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LeaveRequest verifyLeave(int id, LeaveStatus status, String remarks) {
		Optional<LeaveRequest> leave = repo.findById(id);
		if(leave.isEmpty()) return null;
		return null;
	}

	@Override
	public List<LeaveRequest> getLeaveHistory(String empId) {
		// TODO Auto-generated method stub
		return null;
	}

}
