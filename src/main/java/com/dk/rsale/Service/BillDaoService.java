package com.dk.rsale.Service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dk.rsale.dao.BIllDAO;
import com.dk.rsale.entity.Bill;
import com.dk.rsale.entity.BillDetail;

@Service
@Transactional
public class BillDaoService {
	@Autowired
	private SessionFactory	sessionFactory;
	@Autowired
	private BIllDAO billdao;
	@Autowired
	private BillDetailDAOService bldaoser;
	public Bill newBill(Bill b)
	{
		Bill b1 = new Bill();
		b1.setDate(b.getDate());
		b1.setGross(b.getGross());
		b1.setManualBillid(b.getManualBillid());
		b1.setOutstanding(b.getOutstanding());
		b1.setPayamt(b.getPayamt());
		b1.setPcs(b.getPcs());
		b1.setQty(b.getQty());
		b1.setUser(b.getUser());
		b1.setCs(b.getCs());
		b1.setUser(b.getUser());
		return billdao.save(b1);
	}
	public Bill uppBill(Bill b)
	{
		Bill b1 = new Bill();
		b1.setDate(b.getDate());
		b1.setGross(b.getGross());
		b1.setManualBillid(b.getManualBillid());
		b1.setOutstanding(b.getOutstanding());
		b1.setPayamt(b.getPayamt());
		b1.setPcs(b.getPcs());
		b1.setQty(b.getQty());
		b1.setUser(b.getUser());
		b1.setCs(b.getCs());
		b1.setUser(b.getUser());
		b1.setBillInvId(b.getBillInvId());
		return billdao.save(b1);
	}
	public String updetail(String s)
	{
		billdao.updatepcsqtygross(bldaoser.sumofgross(s),bldaoser.sumofpcs(s),bldaoser.sumofqty(s),bldaoser.sumofoutstanding(s), s);
		return "suceess"; 
	}
	public List<Bill> getallbill() {
		 
		return billdao.findAll();
	}
}
