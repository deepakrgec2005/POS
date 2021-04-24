package com.dk.rsale.Service;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dk.rsale.dao.MainGroupDAO;
import com.dk.rsale.entity.MainGroup;

@Service
@Transactional

public class MainGroupService {
	@Autowired
	private SessionFactory	sessionFactory;
	@Autowired
	private MainGroupDAO MGDAO;
	
	public Boolean updateData(String Mname, int id)
	{
		try {
			Optional<MainGroup> optional = MGDAO.findById(id);
			MainGroup mg = optional.get();
			mg.setMid(id);
			
			mg.setMname(Mname);
			MGDAO.save(mg);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public MainGroup addData(MainGroup mg)
	{
		return MGDAO.save(mg);
	}
	public Boolean deleteData(MainGroup mg)
	{
		
		try {
		 MGDAO.delete(mg);
		 return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public MainGroup findMGID(int id)
	{
		
		
			return MGDAO.findById(id).orElse(null);
		  
		
	}
	
	public List<MainGroup> findAllMGID()
	{
		
		
			return MGDAO.findAll();
					
		  
		
	}
}
