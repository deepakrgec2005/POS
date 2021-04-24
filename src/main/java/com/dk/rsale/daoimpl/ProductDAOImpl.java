package com.dk.rsale.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dk.rsale.dao.ProductDao;
import com.dk.rsale.entity.Product;
@Repository("productDao")
@Transactional
public class ProductDAOImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> getAllProduct() {
		return sessionFactory
				.openSession()
					.createQuery("FROM Product" , Product.class)
						.getResultList();
	}

	@Override
	public Product getProduct(int id) {
		try {			
			return sessionFactory
					.getCurrentSession()
						.get(Product.class,Integer.valueOf(id));			
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}
		return null;
	}

	@Override
	public boolean add(Product product) {
		System.out.println("value of product "+ product);
		
		try {			
			sessionFactory
					.openSession()
						.save(product);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	@Override
	public boolean update(Product product) {
		try {			
			sessionFactory
					.getCurrentSession()
						.update(product);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	@Override
	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

}
