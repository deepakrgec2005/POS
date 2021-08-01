package com.dk.rsale.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import com.dk.rsale.dao.InwardRegisterDAO;
import com.dk.rsale.dao.StockDAO;
import com.dk.rsale.entity.InwardRegister;
import com.dk.rsale.entity.Purchasedetail;
import com.dk.rsale.entity.Stock;
import com.dk.rsale.entity.StockDetail;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
@Transactional
public class InwardRegisterSer {
	@Autowired
	private SessionFactory	sessionFactory;
	@Autowired
	private InwardRegisterDAO irdao;
	@Autowired
	private StockService sss;
	@Autowired 
	private PurchasedetailServ pds;
	@Autowired
	private StockDetailService stdt;
	public String addenty(InwardRegister ir)
	{ 
		InwardRegister save = irdao.save(ir);
		System.out.println("value of save id"+save.getPid());
		 return save.getPid();
	}
	public List<InwardRegister> getallInty(String pe)
	{
		 return irdao.findbySANam(pe);
	}
	public InwardRegister getPurId(String id) {
		 return irdao.findById(id).orElse(null);
		 
	}
	public InwardRegister uppur(InwardRegister niwr) 
	{
		InwardRegister irr= new InwardRegister(); 
		irr.setIntype(niwr.getIntype());
		irr.setPdate(niwr.getPdate());
		irr.setPid(niwr.getPid());
		irr.setSpldt(niwr.getSpldt());
		irr.setSplid(niwr.getSplid());
		irr.setSplinv(niwr.getSplinv());
		irr.setTransf(niwr.getTransf());
		 InwardRegister save1 = irdao.save(irr);
		 System.out.println("value of last saved item primary key "+save1.getPid());  
		 return save1;
		 
		
	}
	
	public ResponseEntity<InputStreamResource> report(String format) throws FileNotFoundException, JRException
	{
		String path="C:\\Users\\TANISHKA\\Desktop\\report\\";
		String fileName = "inward.pdf";
		String fileName1 = "inward.html";
		 File outfile = null;
		 String apptype="";
		 
			List<InwardRegister> findAllda = irdao.findbySANam("purchase");
			File file =ResourceUtils.getFile("classpath:Invoice.jrxml");
			JasperReport jasperReport=JasperCompileManager.compileReport(file.getAbsolutePath());
			JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(findAllda);
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("created by", "D K Sharma");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, datasource);
		   if(format.equalsIgnoreCase("html")) 
			  {
				  File f1= new File(path+fileName1);
			  if(f1.exists()) { f1.delete(); }
			  JasperExportManager.exportReportToHtmlFile(jasperPrint,path+fileName1);
			   outfile=new File(path+fileName1); apptype="text/html"; 
			  }
			  if(format.equalsIgnoreCase("pdf")) 
			  {
				  File f1= new File(path+fileName);
			  if(f1.exists()) 
			  { f1.delete(); 
			  }
			  JasperExportManager.exportReportToPdfFile(jasperPrint,path+fileName); 
			   
			  outfile=new File(path+fileName); apptype="application/pdf"; 
			  } 
			  HttpHeaders headers = new HttpHeaders(); 
			  headers.add("content-disposition", "inline;filename=" +fileName); 
			  FileInputStream fs = new FileInputStream(outfile); 
			  InputStreamResource resource = new InputStreamResource(fs);
		 	    return ResponseEntity.ok()
	                .headers(headers)
	                .contentLength(file.length())
	                .contentType(MediaType.parseMediaType(apptype))
	                .body(resource);
 	 
	}
	public InwardRegister getpurdetbyPr(String prid) {
		 return irdao.findById(prid).orElse(null);
	}
	
	 public Stock inwardtransfer(InwardRegister ir)
	 {
		
		   //sd.setBarcode(pds);
		 return stdt.addpurchdetail(ir);
		  
		   
		  
		  
	 }
 
	 
}
