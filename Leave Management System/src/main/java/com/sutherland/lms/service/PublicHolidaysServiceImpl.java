package com.sutherland.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sutherland.lms.entity.PublicHolidays;
import com.sutherland.lms.repo.PublicHolidaysRepo;

@Service
public class PublicHolidaysServiceImpl implements PublicHolidayService{
	
	@Autowired
	PublicHolidaysRepo repo;
	
	@Override
	public List<PublicHolidays> getAllHolidaysList() {
		List<PublicHolidays> holidays = repo.findAll();
		return holidays;
	}

	@Override
	public void addHoliday(PublicHolidays holiday) {
		repo.save(holiday);
	}

}
