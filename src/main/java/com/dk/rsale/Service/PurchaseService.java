package com.dk.rsale.Service;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dk.rsale.dao.PurchaseDAO;
 
import com.dk.rsale.entity.Purchase;

@Service
@Transactional
public class PurchaseService {
@Autowired
PurchaseDAO pudao;
 
public Purchase newPurchase(Purchase p2)
{
	Purchase p1= new Purchase();
	
	/*
	 * ProductList pl=new ProductList();
	 * 
	 * NewBarcodeCreator b1=new NewBarcodeCreator(); String bac=
	 * nbgs.generateBar(b1, new Date());
	 */
	p1.setBarcode(p2.getBarcode());
	p1.setBvalue(p2.getBvalue());
	p1.setExdate(p2.getExdate());
 
	p1.setMrp(p2.getMrp());
	p1.setPcs(p2.getPcs());
	p1.setPdate(p2.getPdate());
	p1.setPl(p2.getPl());
	p1.setQty(p2.getQty());
	p1.setSpldis(p2.getSpldis());
	p1.setSpldt(p2.getSpldt());
	p1.setSplid(p2.getSplid());
	p1.setSplinv(p2.getSplinv());
	p1.setSpltax(5.2);
	
	
	return pudao.save(p1);
}

public Purchase getPurId(String string) {
	return pudao.findById(string).orElse(null);
	 
}
public List<Purchase> getPurAll() {
	return pudao.findAll();
	 
}
}
