package com.sutherland.lms.entity;

import java.time.LocalDate;

import com.sutherland.lms.enums.LeaveStatus;
import com.sutherland.lms.enums.LeaveType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LeaveRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "empId", referencedColumnName = "empId")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name = "managerId", referencedColumnName = "empId")
	private Employee manager;
	
	@Column
	private LocalDate fromDate;
	
	@Column
	private LocalDate toDate;
	
	@Enumerated(EnumType.STRING)
	private LeaveType leaveType;
	
	@Column(length = 3)
	private int numberOfDays;
	
	@Column
	private LocalDate dateApplied;
	
	@Enumerated(EnumType.STRING)
	private LeaveStatus leaveStatus;
	
	@Column(length = 50)
	private String remarks;

	public int getId() {
		return id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public LeaveType getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public LocalDate getDateApplied() {
		return dateApplied;
	}

	public void setDateApplied(LocalDate dateApplied) {
		this.dateApplied = dateApplied;
	}

	public LeaveStatus getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(LeaveStatus leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "LeaveRequest [id=" + id + ", employee=" + employee + ", manager=" + manager + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + ", leaveType=" + leaveType + ", numberOfDays=" + numberOfDays
				+ ", dateApplied=" + dateApplied + ", leaveStatus=" + leaveStatus + ", remarks=" + remarks + "]";
	}
	
	
}
