package com.cts.foodster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.foodster.bean.Staff;
import com.cts.foodster.dao.StaffDAO;
@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	StaffDAO staffDAO;
	
	@Override
	public String addStaff(Staff staff) {
		// TODO Auto-generated method stub
		return staffDAO.addStaff(staff);
	}

	@Override
	public List<Staff> getAllStaff() {
		// TODO Auto-generated method stub
		return staffDAO.getAllStaff();
	}

	@Override
	public String deleteStaff(Staff staff) {
		// TODO Auto-generated method stub
		return staffDAO.deleteStaff(staff);
	}

	@Override
	public Staff getStaff(String id) {
		// TODO Auto-generated method stub
		return staffDAO.getStaff(id);
	}

	@Override
	public List<Staff> searchStaff(String name) {
		// TODO Auto-generated method stub
		return staffDAO.searchStaff(name);
	}

	@Override
	public String editStaff(Staff staff) {
		// TODO Auto-generated method stub
		return staffDAO.editStaff(staff);
	}

}
