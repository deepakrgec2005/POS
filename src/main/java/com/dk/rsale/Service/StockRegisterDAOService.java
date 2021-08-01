package com.dk.rsale.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dk.rsale.dao.StockDAO;
import com.dk.rsale.dao.StockRegisterDAO;
import com.dk.rsale.entity.StockRegister;

@Service
@Transactional
public class StockRegisterDAOService {
	@Autowired
	StockRegisterDAO sdao;
	public StockRegister addStockRg(StockRegister ar1)
	{
		StockRegister ar2= new StockRegister(); 
		 
		ar2.setStkbar(ar1.getStkbar());
		ar2.setTqty(ar1.getTqty());
		return sdao.save(ar2);
		//return ar1;
		
	}
	public StockRegister addStock(StockRegister s)
	{
		 StockRegister s2 = sdao.findById(s.getStkbar()).orElse(s) ;
		  
		 
		 s2.setTqty(s2.getTqty()+s.getTqty());
		 s2.setStkbar(s.getStkbar());
		 
		 return sdao.save(s2);
		 
	}
	public StockRegister removeStock(StockRegister s)
	{
		 StockRegister s2 = sdao.findById(s.getStkbar()).orElse(s);
		  
		  
		 s2.setTqty(s2.getTqty()-s.getTqty());
		 s2.setStkbar(s.getStkbar());
		 
		 return sdao.save(s2);
		 
	}
	public StockRegister upstockreg(StockRegister s)
	{
		StockRegister s3 = new StockRegister();
		 s3.setTqty(s.getTqty());
		s3.setStkbar(s.getStkbar());
		 
		return sdao.save(s3);
	}
	public StockRegister findStkRrg(String s)
	{
		return sdao.findById(s).orElse(null);
	}
}
