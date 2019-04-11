package com.cts.foodster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.foodster.bean.Login;
import com.cts.foodster.dao.LoginDAO;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDAO logindao;
	
	@Override
	public Login Authenticate(Login login) {
		// TODO Auto-generated method stub
		return logindao.Authenticate(login);
	}

	@Override
	public String registerAdmin(Login login) {
		// TODO Auto-generated method stub
		return logindao.registerAdmin(login);
	}

}
