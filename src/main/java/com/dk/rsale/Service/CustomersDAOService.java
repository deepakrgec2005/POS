package com.dk.rsale.Service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dk.rsale.dao.CustomersDAO;
import com.dk.rsale.entity.Customers;

@Service
@Transactional
public class CustomersDAOService {
	@Autowired
	private SessionFactory	sessionFactory;
	@Autowired
	CustomersDAO csdao;
	public Customers addCustdt(Customers c)
	{Customers c1 = new Customers();
		
		c1.setCaddress(c.getCaddress());
		c1.setCname(c.getCname());
		c1.setCnumber(c.getCnumber());
		c1.setGstno(c.getGstno());
		c1.setIsut(c.getIsut());
		return csdao.save(c1);
	}
}
