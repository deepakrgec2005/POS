package com.dk.rsale.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dk.rsale.dao.SubGroupDAO;
import com.dk.rsale.entity.SubGroup;
import com.dk.rsale.entity.SubGroupObject;

@Service
@Transactional
public class SubGroupService {
	@Autowired
	private SessionFactory	sessionFactory;
	@Autowired
	SubGroupDAO sgdao;
	
	public SubGroup addSbgroup(SubGroup sg)
	{
		return sgdao.save(sg);
	}
	public Boolean deleteSbgroup(SubGroup sg)
	{
		 try {
			 SubGroup sg1= sgdao.findById(sg.getSid()).orElse(null);
			 sg1.setMg(null);
			 sg1.setSname(sg.getSname());
			 sg1.setSid(sg.getSid());
			 sgdao.save(sg1);
			sgdao.delete(sg);
			 return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		 
	}
	public SubGroup findSubgroup(int id)
	{
		return sgdao.findById(id).orElse(null);
	}
	
	public List<SubGroupObject> findAllSubgroup(int id)
	{
		List<SubGroupObject>sgo=new ArrayList<SubGroupObject>();
		 List<SubGroup> findA = sgdao.findAll();
		 for(SubGroup sg:findA)
		 {if(sg.getMg().getMid()==id)
		 	sgo.add(new SubGroupObject(sg.getMg().getMid(), sg.getSname(), sg.getSid()));
		 	 
		 }
		 return sgo;
	}
	
	
	public SubGroup updateSubGroup(SubGroup sg)
	{
		 SubGroup sg1= sgdao.findById(sg.getSid()).orElse(null);
		 sg1.setMg(sg.getMg());
		 sg1.setSname(sg.getSname());
		 sg1.setSid(sg.getSid());
		 return sgdao.save(sg1);
	}
	public List<SubGroup> getAllSub()
	{
		return sgdao.findAll();
	}
	
}
