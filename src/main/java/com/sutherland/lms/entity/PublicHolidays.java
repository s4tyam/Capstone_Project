package com.sutherland.lms.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PublicHolidays {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private int id;
	
	@Column(columnDefinition = "date")
	private LocalDate holidayDate;
	
	@Column(length = 50)
	private String holidayDetails;

	public int getId() {
		return id;
	}

	public LocalDate getDate() {
		return holidayDate;
	}

	public void setDate(LocalDate holidayDate) {
		this.holidayDate = holidayDate;
	}

	public String getHolidayDetails() {
		return holidayDetails;
	}

	public void setHolidayDetails(String holidayDetails) {
		this.holidayDetails = holidayDetails;
	}

	@Override
	public String toString() {
		return "PublicHolidays [id=" + id + ", date=" + holidayDate + ", holidayDetails=" + holidayDetails + "]";
	}
}
