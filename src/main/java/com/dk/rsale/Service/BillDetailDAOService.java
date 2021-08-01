package com.dk.rsale.Service;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dk.rsale.dao.BillDetailDAO;
import com.dk.rsale.entity.BillDetail;

@Service
@Transactional
public class BillDetailDAOService {
	@Autowired
	private SessionFactory	sessionFactory;
@Autowired
private BillDetailDAO bddao;
public BillDetail addbilldetl(BillDetail bd)
{
	BillDetail bldt = new BillDetail();
	bldt.setBarcode(bd.getBarcode());
	bldt.setBill(bd.getBill());
	bldt.setBprice(bd.getBprice());
	bldt.setDiscount(bd.getDiscount());
	bldt.setGst(bd.getGst());
	bldt.setNet(bd.getNet());
	bldt.setPayable(bd.getPayable());
	bldt.setPcs(bd.getPcs());
	bldt.setPrname(bd.getPrname());
	bldt.setQty(bd.getQty());
	  BillDetail save = bddao.save(bldt);
	
	 return save;
}
public BillDetail updateBd(BillDetail bd) {
BillDetail bldt = new BillDetail();
bldt.setBarcode(bd.getBarcode());
bldt.setBill(bd.getBill());
bldt.setBprice(bd.getBprice());
bldt.setDiscount(bd.getDiscount());
bldt.setGst(bd.getGst());
bldt.setNet(bd.getNet());
bldt.setPayable(bd.getPayable());
bldt.setPcs(bd.getPcs());
bldt.setPrname(bd.getPrname());
bldt.setQty(bd.getQty());
bldt.setBilldid(bd.getBilldid());
return bddao.save(bldt);

}
public Double sumofgross(String s)
{
	return bddao.getgrossstotal(s);
	
 }
public int sumofpcs(String s)
{
	return bddao.getpcstotal(s);
}
public Double sumofqty(String s)
{
	return bddao.getqtytotal(s);
}
public Double sumofoutstanding(String s) {
	// TODO Auto-generated method stub
	 return bddao.sumofoutstanding(s);
}
public BillDetail getproduct(String barcode, String billdid) {
	 
	 BillDetail updetsaw = bddao.updetsaw(barcode,billdid);
	 System.out.println("value of updetsaw"+updetsaw);
	return updetsaw;
}
 
public List<BillDetail> getbillitem(String billid) {
	List<BillDetail> bliddt =bddao.getbillitem(billid);
	return bliddt;
	
}
public String updbillitem(int billdid, int pcs, double qty, double net) {
	//System.out.println("value of barcode"+barcode);
	//System.out.println("value of billInvId"+billInvId);
	System.out.println("value of billdid"+billdid);
	System.out.println("value of pcs"+pcs);
	System.out.println("value of qty"+qty);
	bddao.upbildt(billdid,pcs,qty, net);
	return "Sucess";
}
public String deletebill(String bild) {
	   BillDetail b1 = bddao.findById(Integer.parseInt(bild)).orElse(null);
	   b1.setBill(null);
	   b1.setPrname(null);
	   bddao.deleteById(Integer.parseInt(bild));
	return "sucess";
}
 public BillDetail getonebillitem(String id)
 {
	 return bddao.findById(Integer.parseInt(id)).orElse(null);
 }
}
