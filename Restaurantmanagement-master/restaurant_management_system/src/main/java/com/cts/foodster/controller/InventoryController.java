package com.cts.foodster.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.foodster.bean.Inventory;
import com.cts.foodster.service.InventoryService;

@Controller
public class InventoryController {

	@Autowired
	InventoryService inventoryService;
	
	@RequestMapping(value="addInventory.html")
	public String getAddInventory(){
		return "addInventory";
	}
	@GetMapping(value="viewInventory")
	public ModelAndView getViewInventory(){
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.addObject("inventorys",inventoryService.getAllInventory());
		modelAndView.setViewName("viewInventory");
		return modelAndView;
	}
	
	@RequestMapping(value="addInventory.html",method=RequestMethod.POST)
	public ModelAndView addInventory(@ModelAttribute Inventory inventory){
		ModelAndView modelAndView = new ModelAndView();
		String s=inventoryService.addInventory(inventory);
		if("success".equals(s))
		{	modelAndView.setViewName("viewInventory");
			modelAndView.addObject("inventorys",inventoryService.getAllInventory());
		}else{
			modelAndView.setViewName("viewInventory");
			modelAndView.addObject("inventorys",inventoryService.getAllInventory());
		}
			
		return modelAndView;
	}
	
	@GetMapping(value="deleteInventory.html")
	public ModelAndView deleteInventory(@RequestParam String id){
		ModelAndView modelAndView= new ModelAndView();
		Inventory inventory= inventoryService.getInventory(id);
		if("success".equals(inventoryService.deleteInventory(inventory))){
			modelAndView.addObject("inventorys",inventoryService.getAllInventory());
			modelAndView.setViewName("viewInventory");
		}else{
			modelAndView.addObject("inventorys",inventoryService.getAllInventory());
			modelAndView.setViewName("viewInventory");
		}
		return modelAndView;
	}
	
	@PostMapping(value="searchInventory.html")
	public ModelAndView searchInventory(@RequestParam String name){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("inventorys",inventoryService.searchInventory(name));
		modelAndView.setViewName("viewInventory");
		return modelAndView;
	}
	@RequestMapping(value="sortInventory.html")
	public ModelAndView sortInventory(@RequestParam("order") String order){
		System.out.println("ADAD"+order);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("inventorys",inventoryService.sortInventory(order));
		modelAndView.setViewName("viewInventory");
		return modelAndView;
	}
	@GetMapping(value="editInventory")
	public ModelAndView getEditInventory(@RequestParam String id){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id",id);
		modelAndView.setViewName("editInventory");
		return modelAndView;
	}
	
	
	@PostMapping(value="editInventory")
	public ModelAndView editInventory(@ModelAttribute Inventory inventory){
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(inventory);
		if("success".equals(inventoryService.editInventory(inventory))){
			modelAndView.addObject("inventorys",inventoryService.getAllInventory());
			modelAndView.setViewName("viewInventory");
		}else{
			modelAndView.addObject("inventorys",inventoryService.getAllInventory());
			modelAndView.setViewName("viewInventory");
		}return modelAndView;
	}
}
