package com.dk.rsale.Service;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dk.rsale.dao.SupplierDAO;
import com.dk.rsale.entity.Supplier;

@Service
@Transactional

public class SupplierService {
	@Autowired
	private SessionFactory	ses;
	@Autowired
	SupplierDAO spdao;
	public Supplier addSupplier(Supplier sp)
	{ //ses.openSession();
		return spdao.save(sp);
	}
	public Supplier getbyAdrrID(int id) {
		return spdao.findById(id).orElse(null);
		
	}
	public List<Supplier> getbyAll() {
		return spdao.findAll();
		 
	}
	public void updatad( Supplier spp) {
		Supplier sp = new Supplier();
		sp.setSid(spp.getSid());
		sp.setAdd1(spp.getAdd1());
		sp.setAdd2(spp.getAdd2());
		sp.setCity(spp.getCity());
		sp.setDistrcit(spp.getDistrcit());
		sp.setEmail(spp.getEmail());
		sp.setGstno(spp.getGstno());
		sp.setMobile(spp.getMobile());
		sp.setPhoneno(spp.getPhoneno());
		sp.setPincode(spp.getPincode());
		sp.setSname(spp.getSname());
		sp.setState(spp.getState());
		Supplier save = spdao.save(sp);
		
	}
}
