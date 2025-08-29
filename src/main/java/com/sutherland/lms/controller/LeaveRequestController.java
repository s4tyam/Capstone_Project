package com.sutherland.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sutherland.lms.entity.LeaveRequest;
import com.sutherland.lms.enums.LeaveStatus;
import com.sutherland.lms.service.LeaveRequestService;

@RestController
@RequestMapping("/leave")
public class LeaveRequestController {

	@Autowired
	LeaveRequestService service;
	
	@PostMapping("/applyleaverequest")
	public void applyLeave(@RequestBody LeaveRequest leave) {
		service.applyForLeave(leave);
	}
	
	@PostMapping("/verifyleaverequest/{id}")
	public LeaveRequest verifyLeave(@PathVariable int id, @RequestParam LeaveStatus status, @RequestParam String remarks) {
		return service.verifyLeave(id, status, remarks);
	}
	
	@GetMapping("/getleavestatus/{id}")
	public LeaveStatus getLeaveStatus(@PathVariable int id) {
		return service.checkStatus(id);
	}
	
	@PutMapping("/cancelleave/{id}")
	public LeaveRequest cancelLeave(@PathVariable int id) {
		return service.cancelLeave(id);
	}
	
	@PutMapping("/withdrawleave/{id}")
	public LeaveRequest withdrawLeave(@PathVariable int id) {
		return service.withDrawLeave(id);
	}
	
	@GetMapping("/viewleavehistory/{id}")
	public List<LeaveRequest> viewLeaveHistory(@PathVariable String id){
		return service.getLeaveHistory(id);
	}
}
