package com.cts.foodster.dao;

import java.util.List;

import com.cts.foodster.bean.Inventory;

public interface InventoryDAO {
public String addInventory(Inventory inventory); //Used for adding Inventory to database
public List<Inventory> getAllInventory();	//Used to retrieve all the inventories present in database
public String deleteInventory(Inventory inventory);	//Used to delete a particular inventory
public Inventory getInventory(String id); 	//Used to retrieve a particular inventory
public List<Inventory> searchInventory(String name); //Used to search a particular inventory based on name
public List<Inventory> sortInventory(String order);  //Used to sort Inventory list based on order
public String editInventory(Inventory inventory);	//Used for editing the Inventory details
}
