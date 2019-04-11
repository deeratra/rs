package com.cts.foodster.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.foodster.bean.Inventory;
import com.cts.foodster.bean.Staff;
@Repository
@Transactional
public class StaffDAOImpl implements StaffDAO {

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public String addStaff(Staff staff) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(staff);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public List<Staff> getAllStaff() {
		// TODO Auto-generated method stub
		try {Query<Staff> query2= sessionFactory.getCurrentSession().createQuery("from Staff");
		ArrayList<Staff> staff=(ArrayList<Staff>) query2.getResultList();
		return staff;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}
	}

	@Override
	public String deleteStaff(Staff staff) {
		try {
			sessionFactory.getCurrentSession().delete(staff);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}

}

	@Override
	public Staff getStaff(String id) {
		try {
			Session session= sessionFactory.getCurrentSession();
			String query = "from Staff where staffId=?";
			org.hibernate.query.Query<Staff> query2 = null;
			query2 = session.createQuery(query);
			query2.setParameter(0, id);
			Staff inv= query2.getSingleResult();
				return inv;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Staff> searchStaff(String name) {
		try {
			Session session= sessionFactory.getCurrentSession();
			String query = "from Staff where firstName=? or lastName=?";
			org.hibernate.query.Query<Staff> query2 = null;
			query2 = session.createQuery(query);
			query2.setParameter(0, name);
			query2.setParameter(1, name);
			List<Staff> inv= query2.getResultList();
				return inv;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String editStaff(Staff staff) {
		try {
			sessionFactory.getCurrentSession().update(staff);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}}
