package com.dk.rsale.daoimpl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dk.rsale.dao.UserDao;
import com.dk.rsale.entity.Users;
@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Users getByEmail(String email) {
		 String selectQuery ="From Users where email= :email";
		 try {
			 return sessionFactory.getCurrentSession().createQuery(selectQuery, Users.class).setParameter("email", email).getSingleResult();
			 
		 }catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public Users get(Long id) {
		try {			
			return sessionFactory.getCurrentSession().get(Users.class, Long.valueOf(id));			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public boolean addUser(Users user) {
		try {

			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Users getByUserName(String userName) {
		 String selectQuery ="From Users where user_name= :userName";
		 try {
			 System.out.println("value inside query" + userName);
				/*
				 * Query q =sessionFactory.openSession().createQuery(selectQuery, Users.class);
				 */
			// System.out.println("value of query is "+q);
				 return sessionFactory.openSession().createQuery(selectQuery, Users.class).setParameter("userName", userName).getSingleResult(); 
				/* return null; */
		 }catch (Exception e) {
			//e.printStackTrace();
			 System.out.println("error is"+e);
			return null;
		}
	}

}
