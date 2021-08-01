package com.dk.rsale.Service;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dk.rsale.dao.PurchasedetailDAO;
import com.dk.rsale.entity.Purchasedetail;
 

@Service
@Transactional
public class PurchasedetailServ {
	@Autowired
	private SessionFactory	sessionFactory;
	@Autowired
	private PurchasedetailDAO pd;
	
	public Purchasedetail addpd(Purchasedetail pa)
	{
		 if(pa.getQty()==0)
		 {
			 pa.setQty(1.0);
		 }
		return pd.save(pa);
	}
	public Purchasedetail uppPd(Purchasedetail pa)
	{
		Purchasedetail pa1 = new Purchasedetail();
		pa1.setBvalue(pa.getBvalue());
		pa1.setExdate(new Date());
		pa1.setMrp(pa.getMrp());
		pa1.setPcs(pa.getPcs());
		pa1.setInid(pa.getInid());
		pa1.setPl(pa.getPl());
		pa1.setQty(pa.getQty());
		pa1.setSpldis(pa.getSpldis());
		pa1.setSpltax(pa.getSpltax());
		pa1.setBarcode(pa.getBarcode());
		return pd.save(pa1);
	}
	public List<Purchasedetail> getAllPrd() {
		 
		return pd.findAll();
	}
	public Purchasedetail getPdbyId(String id) {
		return pd.findById(id).orElse(null);
		 
	}
	public List<Purchasedetail> getPdbyPrId(List<String> id) {
		 
		return pd.findbyPrID(id);
	}
	public String deleteba(String ps) 
	{
  Purchasedetail p2 = pd.findById(ps).orElse(null);
  p2.setInid(null);
  p2.setPl(null);
		pd.deleteById(ps);
		return ps;
	}
	public Double getprtotal(String pid) {
		
		return pd.getprsum(pid);
	}
	public int getcolcount(String pid) {
		 
		return pd.getprrowcount(pid);
	}
	 
}
