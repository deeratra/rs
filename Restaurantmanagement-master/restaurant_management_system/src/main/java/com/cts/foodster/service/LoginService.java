package com.cts.foodster.service;

import com.cts.foodster.bean.Login;

public interface LoginService {

	public Login Authenticate(Login login);
	public String registerAdmin(Login login);
}
