package com.cts.foodster.dao;

import java.util.List;

import com.cts.foodster.bean.Inventory;
import com.cts.foodster.bean.Staff;

public interface StaffDAO {
	public String addStaff(Staff staff); //Used for adding Staff into database
	public List<Staff> getAllStaff();	//Used to retrieve the list of staff details
	public String deleteStaff(Staff staff); //Used to delete a particular staff details
	public Staff getStaff(String id);	//Used to retrieve a particular staff
	public List<Staff> searchStaff(String name);	//Used to search staff based on name
	public String editStaff(Staff staff); 	//Used to edit staff details
}
