package com.dk.rsale.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dk.rsale.dao.ProductListDAO;
import com.dk.rsale.entity.ProductList;
import com.dk.rsale.entity.ProductObject;

@Service
@Transactional
public class ProductListServices {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private ProductListDAO pldao;

	public ProductList addPL(ProductList pl) {
		return pldao.save(pl);
	}

	public ProductList findPL(String id) {
		return pldao.findById(id).orElse(null);
	}

	public ProductList updatePL(ProductList pl) {
		ProductList pl1 = pldao.findById(pl.getPrId()).orElse(null);
		pl1.setPrId(pl.getPrId());

		pl1.setActive(pl.getActive());
		pl1.setGSTonSale(pl.getGSTonSale());
		pl1.setGSTP(pl.getGSTP());
		pl1.setGSTPM(pl.getGSTPM());
		pl1.setHSNCODE(pl.getHSNCODE());
		pl1.setMid(pl.getMid());
		pl1.setPName(pl.getPName());
		pl1.setPSName(pl.getPSName());
		;
		System.out.println("Value of Ptype " + pl.getPType());
		pl1.setPType(pl.getPType());
		pl1.setSg(pl.getSg());
		return pldao.save(pl1);

	}

	public List<ProductList> allproduct() {
		return pldao.findAll();
	}

	public ProductList updateAc(ProductList pl) {
		ProductList pl1 = pldao.findById(pl.getPrId()).orElse(null);

		System.out.println("Value of Ptype " + pl.getPType());
		pl1.setPType(pl.getPType());

		return pldao.save(pl1);

	}

	public List<ProductObject> findBySomefunction() 
	{

		List<ProductObject> pall = new ArrayList<ProductObject>();
		List<ProductList> alldata = pldao.findAll();
		for (ProductList a1 : alldata) 
		{
			pall.add(new ProductObject(a1.getPrId(), a1.getPName(), a1.getGSTP(), a1.getGSTPM()));
		}
			return pall;
	}

	public ProductList allproductId(String id) {
		return pldao.findById(id).orElse(null);
		 
	}
}
