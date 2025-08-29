package com.sutherland.lms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sutherland.lms.entity.Employee;
import com.sutherland.lms.entity.LeaveRequest;
import com.sutherland.lms.enums.LeaveStatus;
import com.sutherland.lms.exceptions.EmployeeNotFoundException;
import com.sutherland.lms.exceptions.LeaveNotFoundException;
import com.sutherland.lms.exceptions.LeaveStatusNotMatch;
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
		Optional<LeaveRequest> leave = repo.findById(id);
		if(leave.isEmpty()) throw new LeaveNotFoundException("Leave Not Found...");
		
		LeaveRequest res = leave.get();
		if(res.getLeaveStatus() == LeaveStatus.APPROVED) {
			res.setLeaveStatus(LeaveStatus.CANCELLED);
			return repo.save(res);
		}else throw new LeaveStatusNotMatch("Leave Status must be Approved...");
	}

	@Override
	public LeaveRequest withDrawLeave(int id) {
		Optional<LeaveRequest> leave = repo.findById(id);
		if(leave.isEmpty()) throw new LeaveNotFoundException("Leave Not Found...");
		
		LeaveRequest res = leave.get();
		if(res.getLeaveStatus() == LeaveStatus.APPLIED) {
			res.setLeaveStatus(LeaveStatus.WITHDRAWN);
			return repo.save(res);
		}else throw new LeaveStatusNotMatch("Leave Status must be Applied...");
	}

	@Override
	public LeaveStatus checkStatus(int id) {
		Optional<LeaveRequest> leave = repo.findById(id);
		if(leave.isEmpty()) throw new EmployeeNotFoundException("Employee not Found...");
		
		LeaveRequest res = leave.get();
		return res.getLeaveStatus();
	}

	@Override
	public LeaveRequest verifyLeave(int id, LeaveStatus status, String remarks) {
		Optional<LeaveRequest> leave = repo.findById(id);
		if(leave.isEmpty()) throw new LeaveNotFoundException("Leave not found...");
		
		LeaveRequest res = leave.get();
		if(status == LeaveStatus.REJECTED) {
			res.setLeaveStatus(LeaveStatus.REJECTED);
			res.setRemarks(remarks);
			return repo.save(res);
		}
		res.setLeaveStatus(LeaveStatus.APPROVED);
		res.setRemarks("");
		return repo.save(res);
	}

	@Override
	public List<LeaveRequest> getLeaveHistory(String empId) {
		List<LeaveRequest> leaveHistory = repo.getAllLeaveRequestsByEmployeeId(empId);
		return leaveHistory;
	}

}
