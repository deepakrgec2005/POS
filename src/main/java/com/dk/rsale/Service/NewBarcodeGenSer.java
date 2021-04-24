package com.dk.rsale.Service;

import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dk.rsale.dao.NewBarcodeGen;
import com.dk.rsale.entity.NewBarcodeCreator;

@Service
@Transactional
public class NewBarcodeGenSer {
	@Autowired
	private SessionFactory	sessionFactory;
	@Autowired
	NewBarcodeGen nbg;
	
	public String generateBar(NewBarcodeCreator nb,  Date date)
	{
		int id1 = nb.getId();
		 
		 
		System.out.println("value of id1:- "+id1);
		
		
		if(id1==0)
		{
			id1=id1+1;
		}
		 
		
		String id2=String.format("%06d", id1);
			
			String s="";
			System.out.println("value of Date"+date.getYear());
			int year = date.getYear();
			s=s+""+year+""+id2;
			System.out.println("Value of Barcode:- "+s);
			nbg.save(nb);
			return s;
	}
}
