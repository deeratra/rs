package com.cts.foodster.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.foodster.bean.Login;

@Repository
@Transactional
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	
	
	public Login Authenticate(Login login) {
		// TODO Auto-generated method stub
		String userId = login.getUserId();
		String password= login.getPassword();
		try {
			Session session= sessionFactory.getCurrentSession();
			String query = "from Login where userId=? and password=?";
			org.hibernate.query.Query<Login> query2 = null;
			query2 = session.createQuery(query);
			query2.setParameter(0, userId);
			query2.setParameter(1, password);
			Login login2= query2.getSingleResult();
			if(login2 != null)
				return login2;
			else
				return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
public String registerAdmin(Login login) {
		
		try {
			sessionFactory.getCurrentSession().save(login);
			return "yes";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "no";
		}
		
		
		
		
	}

}
