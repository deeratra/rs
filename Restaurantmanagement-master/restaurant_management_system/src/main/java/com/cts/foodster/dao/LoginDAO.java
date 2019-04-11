package com.cts.foodster.dao;

import com.cts.foodster.bean.Login;

public interface LoginDAO {

	public Login Authenticate(Login login); //Used for authencating user
	public String registerAdmin(Login login);	//Used for registering the admin details
}
