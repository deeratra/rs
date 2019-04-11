package com.cts.foodster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.foodster.bean.Inventory;
import com.cts.foodster.dao.InventoryDAO;
@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryDAO inventoryDAO;
	
	@Override
	public String addInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		return inventoryDAO.addInventory(inventory);
	}

	@Override
	public List<Inventory> getAllInventory() {
		// TODO Auto-generated method stub
		return inventoryDAO.getAllInventory();
	}

	@Override
	public String deleteInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		return inventoryDAO.deleteInventory(inventory);
	}

	@Override
	public Inventory getInventory(String id) {
		// TODO Auto-generated method stub
		return inventoryDAO.getInventory(id);
	}

	@Override
	public List<Inventory> searchInventory(String name) {
		// TODO Auto-generated method stub
		return inventoryDAO.searchInventory(name);
	}

	@Override
	public List<Inventory> sortInventory(String order) {
		// TODO Auto-generated method stub
		return inventoryDAO.sortInventory(order);
	}

	@Override
	public String editInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		return inventoryDAO.editInventory(inventory);
	}

}
