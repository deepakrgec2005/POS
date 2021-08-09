package com.dk.rsale.Service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dk.rsale.dao.PaymentdetailDAO;
import com.dk.rsale.entity.Paymentdetail;

@Service
@Transactional
public class PaymentdetailService {
	@Autowired
	private SessionFactory	sessionFactory;
	@Autowired
	private PaymentdetailDAO pymddao;
	
	public Paymentdetail addPaydet(Paymentdetail pm1)
	{
		Paymentdetail pm2 = new Paymentdetail();
		pm2.setAmountpaid(pm1.getAmountpaid());
		pm2.setBid(pm1.getBid());
		pm2.setPymd(pm1.getPymd());
		pm2.setCsname(pm1.getCsname());
		pm2.setUser(pm1.getUser());
		pm2.setBillno(pm1.getBillno());
		pm2.setRemarks(pm1.getRemarks());
		pm2.setPaydate(pm1.getPaydate());
		return pymddao.save(pm2);
		
	}
	public Paymentdetail savePaydet(Paymentdetail pm1)
	{
		Paymentdetail pm2 = new Paymentdetail();
		pm2.setAmountpaid(pm1.getAmountpaid());
		pm2.setBid(pm1.getBid());
		pm2.setPymd(pm1.getPymd());
		pm2.setCsname(pm1.getCsname());
		pm2.setPydt(pm1.getPydt());
		pm2.setUser(pm1.getUser());
		pm2.setBillno(pm1.getBillno());
		pm2.setRemarks(pm1.getRemarks());
		pm2.setPaydate(pm1.getPaydate());
		return pymddao.save(pm1);
	}
	
	
	  public List<Paymentdetail> getpaydtbill(String bids) {
		  return pymddao.getallbillid(bids); }
	 
}
