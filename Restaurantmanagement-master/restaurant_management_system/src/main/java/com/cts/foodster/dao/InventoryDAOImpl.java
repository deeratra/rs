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
import com.cts.foodster.bean.Login;

@Repository
@Transactional
public class InventoryDAOImpl implements InventoryDAO {

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public String addInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(inventory);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Inventory> getAllInventory() {
		// TODO Auto-generated method stub
		try {
			Query<Inventory> query2= sessionFactory.getCurrentSession().createQuery("from Inventory");
			ArrayList<Inventory> inventory=(ArrayList<Inventory>) query2.getResultList();
			
			return inventory;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String deleteInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(inventory);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public Inventory getInventory(String id) {
		try {
			Session session= sessionFactory.getCurrentSession();
			String query = "from Inventory where inventoryId=?";
			org.hibernate.query.Query<Inventory> query2 = null;
			query2 = session.createQuery(query);
			query2.setParameter(0, id);
			Inventory inv= query2.getSingleResult();
				return inv;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Inventory> searchInventory(String name) {
		try {
			Session session= sessionFactory.getCurrentSession();
			String query = "from Inventory where inventoryName=?";
			org.hibernate.query.Query<Inventory> query2 = null;
			query2 = session.createQuery(query);
			query2.setParameter(0, name);
			List<Inventory> inv= query2.getResultList();
				return inv;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Inventory> sortInventory(String order) {
		try {
			Session session= sessionFactory.getCurrentSession();
			String query = "from Inventory order by totalStock asc";
			if("HTL".equals(order))
				query= "from Inventory order by totalStock desc";
			org.hibernate.query.Query<Inventory> query2 = null;
			query2 = session.createQuery(query);
			List<Inventory> inv= query2.getResultList();
				return inv;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String editInventory(Inventory inventory) {
		try {
			sessionFactory.getCurrentSession().update(inventory);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}
	}

