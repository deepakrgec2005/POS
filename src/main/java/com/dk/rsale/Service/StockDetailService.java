package com.dk.rsale.Service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dk.rsale.dao.InwardRegisterDAO;
import com.dk.rsale.dao.StockDetailDAO;
import com.dk.rsale.dao.StockRegisterDAO;
import com.dk.rsale.dao.stockdetailbarado;
import com.dk.rsale.entity.InwardRegister;
import com.dk.rsale.entity.Purchasedetail;
import com.dk.rsale.entity.Stock;
import com.dk.rsale.entity.StockDetail;
import com.dk.rsale.entity.StockRegister;
import com.dk.rsale.entity.stockdetailbarc;
@Service
@Transactional

public class StockDetailService {
	private SessionFactory	ses;
	@Autowired
	stockdetailbarado sddao;
	@Autowired
	StockDetailDAO sdtado;
	@Autowired
	private InwardRegisterDAO irdao;
	@Autowired
	private StockService sss;
	@Autowired 
	private PurchasedetailServ pds;
	@Autowired
	private StockRegisterDAOService srdaos;
	@Autowired
	private StockRegisterDAO srddao;
	 
	public StockDetail addstkdt(StockDetail pudr) {
		stockdetailbarc skdb= new stockdetailbarc();
		skdb.setStockiddetail(pudr.getStkid().toString());
		stockdetailbarc save1 = sddao.save(skdb); 
		StockDetail stkd1 =new StockDetail();
		stkd1.setBarcode(save1.getBarc());
		stkd1.setBvalue(pudr.getBvalue());
		stkd1.setMrp(pudr.getMrp());
		stkd1.setPcs(pudr.getPcs());
		stkd1.setPl(pudr.getPl());
		if(pudr.getQty()==0)
		{
			stkd1.setQty(1);
		}else {
			stkd1.setQty(pudr.getQty());	
		}
		
		stkd1.setStkid(pudr.getStkid());
		stkd1.setSttype("current-opening");
		stkd1.setSupid(pudr.getSupid());
		 StockDetail ss1 = sdtado.save(stkd1);
		 StockRegister sr = new StockRegister();
		 
		 sr.setTqty(ss1.getQty()*ss1.getPcs());
		 sr.setStkbar(ss1.getBarcode());
		 srdaos.addStockRg(sr);
		 return ss1;
	}

	public StockDetail uppstkdt(StockDetail pudr) {
		StockDetail stkd1 =new StockDetail();
		stkd1.setBarcode(pudr.getBarcode());
		stkd1.setBvalue(pudr.getBvalue());
		stkd1.setMrp(pudr.getMrp());
		stkd1.setPcs(pudr.getPcs());
		stkd1.setPl(pudr.getPl());
		stkd1.setQty(pudr.getQty());
		stkd1.setStkid(pudr.getStkid());
		stkd1.setSttype("current-opening");
		stkd1.setSupid(pudr.getSupid());
		 StockDetail sd1 = sdtado.save(stkd1);
		 StockRegister sr1 = srdaos.findStkRrg(sd1.getBarcode());
		 System.out.println("value of sr1"+sr1);
		 
		 sr1.setTqty(sd1.getQty()*sd1.getPcs());
		 sr1.setStkbar(sd1.getBarcode());
		 srdaos.upstockreg(sr1);
		 return sd1;
	}

	public List<StockDetail> getstkdtbystkId(List<String> prida) {
		 
		return sdtado.findbyStkId(prida);
	}
	public StockDetail getbyID(String prida)
	{
		return sdtado.findById(prida).orElse(null);
	}
public Double getprtotal(String pid) {
		
		return sdtado.getprsum(pid);
	}
	public int getcolcount(String pid) {
		 
		return sdtado.getprrowcount(pid);
	}

	public Stock addpurchdetail(InwardRegister ir) {
		 
		 ir.setTransf(true);
		  irdao.save(ir);
		  
		  List<String> inwid = new ArrayList<>();
		  inwid.add(ir.getPid());
		  Stock s1 = new Stock();
		  s1.setAmount( pds.getprtotal(ir.getPid()));
		  s1.setNor(pds.getcolcount(ir.getPid()));
		  s1.setStockon(ir.getPdate());
		  s1.setStocktype(ir.getPid()+"-"+"Purchase");
		  Stock saveStock = sss.saveStock(s1);
		  //String stockid = saveStock.getStockid();
		  
		   List<Purchasedetail> pdbyPrId = pds.getPdbyPrId(inwid);
		  
		   for(Purchasedetail pd1:pdbyPrId)
		   {
			   StockRegister sr = new StockRegister();
			   StockDetail sd = new StockDetail();
			   sd.setBarcode(pd1.getBarcode());
			   sr.setStkbar(pd1.getBarcode());
			   sd.setBvalue(pd1.getBvalue());
			   sd.setMrp(pd1.getMrp());
			   sd.setPcs(pd1.getPcs());
			   
			   sd.setPl(pd1.getPl());
			   sd.setQty(pd1.getQty());
			    
			   sr.setTqty(pd1.getQty()*pd1.getPcs());
			   sd.setStkid(saveStock);
			   sd.setSttype(saveStock.getStocktype());
			   sd.setSupid(ir.getSplid() );
			   srdaos.addStockRg(sr);
			   sdtado.save(sd);
		   }
		   return saveStock;
	}

	public String deleteba(String bar) {
		
	StockDetail sd= sdtado.findById(bar).orElse(null);
	/*
	 * Stock stkid1 = sd.getStkid();
	 * stkid1.setAmount(sdtado.getprsum(stkid1.getStockid()));
	 * stkid1.setNor(sdtado.getprrowcount(stkid1.getStockid()));
	 * sss.saveStock(stkid1);
	 */
	sd.setPl(null);
	sd.setStkid(null);
	sd.setSupid(null);
	sdtado.deleteById(bar);
	// srdaos.d
	srddao.deleteById(bar);
		return bar;
	}

	public List<StockDetail> getall() {
		
		 return sdtado.findAll();
		
	 
	}
	public List<StockDetail> getlikeall(String sa) {
		
		return sdtado.findlike(sa);
		
	 
	}
	public StockDetail getaone(String s) {
		return sdtado.findById(s).orElse(null);
		
	}
}
