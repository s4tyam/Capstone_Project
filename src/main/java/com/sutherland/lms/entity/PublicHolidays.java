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
	private int id;
	
	@Column(columnDefinition = "date")
	private LocalDate date;
	
	@Column(length = 50)
	private String holidayDetails;

	public int getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getHolidayDetails() {
		return holidayDetails;
	}

	public void setHolidayDetails(String holidayDetails) {
		this.holidayDetails = holidayDetails;
	}

	@Override
	public String toString() {
		return "PublicHolidays [id=" + id + ", date=" + date + ", holidayDetails=" + holidayDetails + "]";
	}
}
