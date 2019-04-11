package com.cts.foodster.service;

import java.util.List;

import com.cts.foodster.bean.Staff;

public interface StaffService {
	public String addStaff(Staff staff);
	public List<Staff> getAllStaff();
	public String deleteStaff(Staff staff);
	public Staff getStaff(String id);
	public List<Staff> searchStaff(String name);
	public String editStaff(Staff staff);
}
