package com.cts.foodster.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.foodster.bean.Inventory;
import com.cts.foodster.bean.Login;
import com.cts.foodster.bean.Staff;
import com.cts.foodster.service.InventoryService;
import com.cts.foodster.service.LoginService;
import com.cts.foodster.service.StaffService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@Autowired
	InventoryService inventoryService;
	@Autowired
	StaffService staffService;
	
	@RequestMapping("/")
	public String AdminLogin(){
		return "login";
	}
	
	
	//Redirect to addInventory page after successful authencation of Id and Password
	@RequestMapping(value="login.html",method=RequestMethod.POST)
	public ModelAndView Login(@ModelAttribute Login login, HttpSession httpSession){
		ModelAndView mav = new ModelAndView();
		Login login1 =loginService.Authenticate(login);
		if(login1 != null){
			mav.setViewName("addInventory");
			httpSession.setAttribute("employee", login1);
		}
		else{
			
			httpSession.setAttribute("info","Wrong Credentials");
		}return mav;
	}
	
	@RequestMapping(value="login.html")
	public String getLogin(){
		return "login";
	}
	
	
	//Redirect to login page after successful registration of admin details
	@RequestMapping(value="registration.html", method=RequestMethod.POST)
	public ModelAndView register(@ModelAttribute Login login)
	{
		ModelAndView modelAndView = new ModelAndView();
		if("yes".equals(loginService.registerAdmin(login))){
			String info = new String("Details Added Successfully");
		//	modelAndView.addObject("info",info);
			modelAndView.setViewName("login");}
		else
			modelAndView.setViewName("login");
		return modelAndView;
	}
	
	//Redirect to login after the admin clicks on Sign Out
	@RequestMapping(value="signOut.html")
	public ModelAndView logout(HttpSession httpSession){
		ModelAndView modelAndView= new ModelAndView();
		httpSession.removeAttribute("employee");
		httpSession.invalidate();
		modelAndView.setViewName("login");
		
		return modelAndView;
	}
}
