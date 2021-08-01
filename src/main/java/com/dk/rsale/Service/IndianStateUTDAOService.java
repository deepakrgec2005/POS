package com.dk.rsale.Service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dk.rsale.dao.IndianStateUTDAO;
import com.dk.rsale.entity.IndianStateandUT;

@Service
@Transactional
public class IndianStateUTDAOService {
	@Autowired
	private SessionFactory	sessionFactory;
	@Autowired
	private IndianStateUTDAO isutdao;
	public IndianStateandUT addState(IndianStateandUT s)
	{
		IndianStateandUT s1 =new IndianStateandUT();
		s1.setStatename(s.getStatename());
		return isutdao.save(s1);
	}
	
	public IndianStateandUT getnewstate(int id)
	{
		return isutdao.findById(id).orElse(null);
	}

	public List<IndianStateandUT> getallstate() {
		return isutdao.findAll();
		 
	}
}
