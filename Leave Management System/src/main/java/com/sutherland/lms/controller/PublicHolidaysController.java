package com.sutherland.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sutherland.lms.entity.PublicHolidays;
import com.sutherland.lms.service.PublicHolidayService;

@RestController
@RequestMapping("/holidays")
@CrossOrigin(origins = "http://localhost:3000/")
public class PublicHolidaysController {

	@Autowired
	PublicHolidayService service;
	
	@GetMapping("/all")
	public List<PublicHolidays> getAllHolidays() {
		return service.getAllHolidaysList();
	}
	
	@PostMapping("/addholidaydetails")
	public void addHoliday(@RequestBody PublicHolidays holiday) {
		service.addHoliday(holiday);
	}
	
}
