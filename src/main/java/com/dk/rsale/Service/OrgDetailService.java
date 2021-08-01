package com.dk.rsale.Service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dk.rsale.dao.OrgDetailDAO;
import com.dk.rsale.entity.OrgDetail; 

@Service
@Transactional
public class OrgDetailService {
	@Autowired
	private SessionFactory	ses;
	@Autowired
	OrgDetailDAO orgao;
	public OrgDetail createOrg(OrgDetail org)
	{ 
		OrgDetail org1 = new OrgDetail();
		org1.setGSNNo(org.getGSNNo());
		org1.setIsactive(org.getIsactive());
		 
		org1.setOrgName(org.getOrgName());
		 return orgao.save(org1);
		 
		
	}
	public OrgDetail getOrgDet(String id)
	{
		return orgao.findById(id).orElse(null);
	}
	public List<OrgDetail> getOrgDet()
	{
		return orgao.findAll();
	}
	public OrgDetail updatedetail(OrgDetail org) {
		OrgDetail org1 = new OrgDetail();
		org1.setGSNNo(org.getGSNNo());
		org1.setIsactive(org.getIsactive());
		org1.setOrgid(org.getOrgid());
		org1.setOrgName(org.getOrgName());
		return orgao.save(org1);
	}
}
