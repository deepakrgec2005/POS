package com.dk.rsale.Service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dk.rsale.dao.PaymodeDAO;
import com.dk.rsale.entity.Paymode;

@Service
@Transactional
public class PaymodeService {
	@Autowired
	private SessionFactory	sessionFactory;
	@Autowired
	private PaymodeDAO pymddao;
	
	public Paymode addpaymd(Paymode p1)
	{
		Paymode pymd1 = new Paymode();
		pymd1.setPydis(p1.getPydis());
		return pymddao.save(pymd1);
		 
	}
	public Paymode savepymd(Paymode p1)
	{
		Paymode pymd1 = new Paymode();
		pymd1.setPydis(p1.getPydis());
		pymd1.setPymid(p1.getPymid());
		return pymddao.save(pymd1);
		 
	}
	public Paymode getallpay(int id)
	{
		return pymddao.findById(id).orElse(null);
	}
}
