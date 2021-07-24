package com.dk.rsale.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dk.rsale.Service.BillDaoService;
import com.dk.rsale.Service.BillDetailDAOService;
import com.dk.rsale.Service.CustomersDAOService;
import com.dk.rsale.Service.IndianStateUTDAOService;
import com.dk.rsale.Service.InwardRegisterSer;
import com.dk.rsale.Service.MainGroupService;
import com.dk.rsale.Service.NewBarcodeGenSer;
import com.dk.rsale.Service.OrgDetailService;
import com.dk.rsale.Service.ProductListServices;
import com.dk.rsale.Service.PurchaseService;
import com.dk.rsale.Service.PurchasedetailServ;
import com.dk.rsale.Service.StockDetailService;
import com.dk.rsale.Service.StockRegisterDAOService;
import com.dk.rsale.Service.StockService;
import com.dk.rsale.Service.SubGroupService;
import com.dk.rsale.Service.SupplierService;
import com.dk.rsale.Service.UserMDetailService;
import com.dk.rsale.dao.MainGroupDAO;
import com.dk.rsale.dao.ProductDao;
import com.dk.rsale.dt.LabelValueDTO;
import com.dk.rsale.entity.Bill;
import com.dk.rsale.entity.BillDetail;
import com.dk.rsale.entity.Customers;
import com.dk.rsale.entity.InwardRegister;
import com.dk.rsale.entity.MainGroup;
import com.dk.rsale.entity.OrgDetail;
import com.dk.rsale.entity.ProductList;
import com.dk.rsale.entity.ProductObject;
import com.dk.rsale.entity.Purchasedetail;
import com.dk.rsale.entity.Stock;
import com.dk.rsale.entity.StockDetail;
import com.dk.rsale.entity.StockRegister;
import com.dk.rsale.entity.SubGroup;
import com.dk.rsale.entity.Supplier;
import com.dk.rsale.entity.UserMDetail;
import com.google.gson.Gson;

import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

@Controller
@RequestMapping(value = "/POS")
public class MainController {
	Authentication authentication;
	@Autowired
	ProductDao productDao;
	@Autowired
	MainGroupDAO MGDAO;
	@Autowired
	MainGroupService mgservice;
	@Autowired
	SubGroupService sgservice;
	@Autowired
	ProductListServices pls;
	@Autowired
	SupplierService ss;
	@Autowired
	PurchaseService purse;
	@Autowired
	NewBarcodeGenSer nbgs;
	@Autowired
	PurchasedetailServ pdss;
	@Autowired
	InwardRegisterSer iws;
	@Autowired
	StockService stsr;
	@Autowired
	StockDetailService sdts;
	@Autowired
	BCryptPasswordEncoder brc;
	@Autowired
	UserMDetailService umds;
	@Autowired
	OrgDetailService ords;
	@Autowired
	BillDaoService blds;
	@Autowired
	IndianStateUTDAOService isus;
	@Autowired
	CustomersDAOService csdaos;
	@Autowired
	BillDetailDAOService blldtdaosr;
	@Autowired
	StockRegisterDAOService srdaosr;
 	@RequestMapping(value = { "/", "/home" })
	public ModelAndView HomeCont() {
		//Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		ModelAndView mv = new ModelAndView("Page1");
		mv.addObject("title", "Home");

		mv.addObject("userClickHome", true);
		//mv.addObject("userName", authentication);
		return mv;
	}

	@RequestMapping(value = "/login")
	public String login(Model model, String error, String logout) {
		// ModelAndView mv = new ModelAndView("Home");
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");
		 
		return "login";
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		// ModelAndView mv = new ModelAndView("Home");
		ModelAndView mv = new ModelAndView("Page1");
		mv.addObject("title", "About Us");

		mv.addObject("userClickAbout", true);

		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		// ModelAndView mv = new ModelAndView("Home");
		ModelAndView mv = new ModelAndView("Page1");
		mv.addObject("title", "Contact Us");

		mv.addObject("userClickContact", true);

		return mv;
	}

	@RequestMapping(value = "/mg", method = RequestMethod.GET)
	public ModelAndView proli(@RequestParam(name = "operation", required = false) String operation) {
		// ModelAndView mv = new ModelAndView("Home");
		ProductList pl = new ProductList();
		pl.setActive(true);
		MainGroup categ= new MainGroup();
		SubGroup subcategory=new SubGroup();
		ModelAndView mv = new ModelAndView("Page1");
		mv.addObject("maingroup", MGDAO.findAll());
		mv.addObject("category", categ);
		mv.addObject("subcategory", subcategory);
		mv.addObject("product", pl);
		mv.addObject("title", "Product Master");

		mv.addObject("userClickProduct", true);
		if (operation != null) {
			if (operation.equals("product")) {
				mv.addObject("message", "Product Submitted Successfully!");
			}

		}
		return mv;
	}
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String handleMainCategory(@ModelAttribute MainGroup category) {
		
		mgservice.addData(category); 
	return "redirect:/POS/mg"; 
	}
	@RequestMapping(value="/subcategory", method=RequestMethod.POST)
	public String handlesubMainCategory(@ModelAttribute SubGroup subcategory) {
		
		  
		sgservice.addSbgroup(subcategory);
	return "redirect:/POS/mg"; 
	}
	
	@RequestMapping(value="/changepass", method=RequestMethod.POST)
	public String handlechangepass(@RequestParam(name = "userid") String userid ,@RequestParam(name = "newpass") String changepass) {
		//System.out.println("value of changepass"+changepass);
		//System.out.println("value of userid"+userid);
		 String encryPwd=brc.encode(changepass);
		 //System.out.println("new password"+changepass+" , and encypt"+encryPwd);
		  umds.updatepass(userid,encryPwd);
		//sgservice.addSbgroup(subcategory);
	return "redirect:/POS/register"; 
	}
	
	@RequestMapping(value = "/supplier")
	public ModelAndView supplier(@RequestParam(name = "operation", required = false) String operation) {

		// ModelAndView mv = new ModelAndView("Home");
		ModelAndView mv = new ModelAndView("Page1");
		if (operation != null) {
			if (operation.equals("supplier")) {
				mv.addObject("message", "Supplier Added Successfully!");
			}

		}

		Supplier s1 = new Supplier();

		mv.addObject("supplier", s1);

		mv.addObject("title", "Supplier");

		mv.addObject("userClickSupplier", true);

		return mv;
	}

	@RequestMapping(value = "/supplier/{id}", method = RequestMethod.GET)
	public ModelAndView supplierUpdate(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("Page1");

		Supplier s1 = ss.getbyAdrrID(id);

		mv.addObject("supplier", s1);

		mv.addObject("title", "Supplier");

		mv.addObject("userClickSupplier", true);

		return mv;
	}

	@RequestMapping(value = "/supplier", method = RequestMethod.POST)
	public String handleSupplierSubmission(@Valid @ModelAttribute("supplier") Supplier spp, BindingResult result,
			Model model) {
		if (result.hasErrors()) {

			model.addAttribute("userClickSupplier", true);
			model.addAttribute("title", "Supplier");
			return "Page1";
		}
		if (spp.getSid() == 0) {
			ss.addSupplier(spp);
		} else {

			ss.updatad(spp);
		}

		return "redirect:/POS/supplier?operation=supplier";
	}

	@RequestMapping(value = "/json/supplier", method = RequestMethod.GET)
	@ResponseBody
	public List<Supplier> suplierdetails() {
		return ss.getbyAll();

	}

	@RequestMapping(value = "/json/purchase", method = RequestMethod.GET)
	@ResponseBody
	public InwardRegister purchased() {
		return iws.getPurId("PR_1");

	}

	@RequestMapping(value = "/json/purchaseall", method = RequestMethod.GET)
	@ResponseBody
	public List<InwardRegister> purchasedAl() {
		return iws.getallInty("purchase");

	}

	@RequestMapping(value = "/purchase")
	public ModelAndView purchase(@RequestParam(name = "pur_id") String purid) {
		Boolean trnv;
		// ModelAndView mv = new ModelAndView("Home");
		ModelAndView mv = new ModelAndView("Page1");
		InwardRegister p1;
		if (purid.equals("0")) {
			p1 = new InwardRegister();
			p1.setTransf(false);
			trnv = false;
			System.out.println("Inside 0:- ");
			// System.out.println("value of transfer "+trnv);
		} else {
			p1 = iws.getPurId(purid);
			trnv = p1.getTransf();
			System.out.println("Inside other condition:- ");
		}
		Purchasedetail pd = new Purchasedetail();
		mv.addObject("purid", purid);
		mv.addObject("purchase", p1);
		mv.addObject("purrege", pd);
		mv.addObject("title", "Purchase");
		mv.addObject("transfdv", trnv);
		mv.addObject("userClickPurchase", true);

		return mv;
	}

	@RequestMapping(value = "/purchase", method = RequestMethod.POST)
	@ResponseBody
	public String handlepurchase(@Valid @ModelAttribute("purchase") InwardRegister niwr, BindingResult result,
			Model model) {
		String s;
		System.out.println("value of niw  = " + niwr);
		System.out.println("value of niw.getPid() is = " + niwr.getPid());
		if (result.hasErrors()) {

			model.addAttribute("userClickPurchase", true);
			model.addAttribute("title", "Purchase");
			return "Page1";
		}
		if (niwr.getPid().equals("")) {
			s = iws.addenty(niwr);

			System.out.println("value of s inside add method:-" + s);
		} else {
			iws.uppur(niwr);
			s = niwr.getPid();
			System.out.println("value of s inside update method:-" + s);
		}
		System.out.println("{\"status\":\"success\"}");
		// return "redirect:/purchase?pur_id=" + s;
		return "{\"status\":\"" + s + "\"}";
	}

	@RequestMapping(value = "/purrege", method = RequestMethod.POST)
	@ResponseBody
	public String handlepurchasereg(@Valid @ModelAttribute("purrege") Purchasedetail pudr, BindingResult result,
			Model model) {
		System.out.println("I m inseide post function /purrege and value of pudr is " + pudr);
		String s = "";

		System.out.println("value of niw.getPid() is = " + pudr);
		System.out.println("value of niw.getPid() is = " + pudr.getBarcode());
		if (result.hasErrors()) {
			System.out.println("Inside error");
			System.out.println("value of result" + result.toString());
			model.addAttribute("userClickPurchase", true);
			model.addAttribute("title", "Purchase");
			return "Page1";
		}

		if (pudr.getBarcode().equals("") || pudr.getBarcode() == null) {
			pdss.addpd(pudr);

			System.out.println("value of s inside add method:-" + s);
		} else {
			pdss.uppPd(pudr);

			s = pudr.getBarcode();
			System.out.println("value of s inside update method:-" + s);
		}
		System.out.println("{\"status\":\"success\"}");
		// return "redirect:/purchase?pur_id=" + s;
		return "{\"status\":\"" + s + "\"}";
	}

	@RequestMapping(value = "/pliupdate")
	public ModelAndView updatestkdetail(@RequestParam(name = "bar") String bar) {

		
		Purchasedetail pdu = pdss.getPdbyId(bar);
		
		
		ModelAndView mv = new ModelAndView("Page1");

		mv.addObject("title", "ProductListUpdate");

		mv.addObject("userClickPurchaselistupdate", true);
		mv.addObject("purrege", pdu);
		// System.out.println("value of main group "+sg1 );
		return mv;
	}
	@RequestMapping(value = "/rsup")
	public ModelAndView updatersdetailg(@RequestParam(name = "bar") String bar,@RequestParam(name = "indt") String indt) {

		  BillDetail pdu = blldtdaosr.getproduct(bar, indt);
		  String bar1=bar.substring(1, 9);
		StockDetail getaone = sdts.getaone(bar1);
		ModelAndView mv = new ModelAndView("Page1");

		mv.addObject("title", "Update Sale");

		mv.addObject("userClickRsBill", true);
		mv.addObject("rsaledupd", pdu);
		mv.addObject("stkdt",getaone);
		System.out.println("value of main pdu "+pdu );
		return mv;
	}

	@RequestMapping(value = "/pliupdate", method = RequestMethod.POST)
	@ResponseBody
	public String updatestkdetailP(@Valid @ModelAttribute("purrege") Purchasedetail pudr,
			@RequestParam(name = "bar", required = false) String bar, BindingResult result, Model model) {

		Purchasedetail uppPd = pdss.uppPd(pudr);

		String s = uppPd.getBarcode();
		System.out.println("value of s inside update method:-" + s);
		return s;
	}
	
	@RequestMapping(value = "/rsup", method = RequestMethod.POST)
	@ResponseBody
	public String updatersale(@Valid @ModelAttribute("rsaledupd") BillDetail bd,
			@RequestParam(name = "bar", required = false) String bar, BindingResult result, Model model) {

		BillDetail getproduct = blldtdaosr.getproduct(bar, bd.getBill().getBillInvId());
		
		//Purchasedetail uppPd = pdss.uppPd(pudr);

		String s = getproduct.getBarcode();
		System.out.println("value of s inside update method:-" + s);
		return s;
	}
//Stock Update//
	@RequestMapping(value = "/stkdetupdate")
	public ModelAndView updatepuddetail(@RequestParam(name = "bar") String bar) {

		StockDetail pdu = sdts.getbyID(bar);
		ModelAndView mv = new ModelAndView("Page1");

		mv.addObject("title", "Stock Update");

		mv.addObject("userClickStockupdate", true);
		mv.addObject("purrege", pdu);
		// System.out.println("value of main group "+sg1 );
		return mv;
	}

	@RequestMapping(value = "/stkdetupdate", method = RequestMethod.POST)
	@ResponseBody
	public String updatepuddetailP(@Valid @ModelAttribute("purrege") StockDetail pudr,
			@RequestParam(name = "bar", required = false) String bar, BindingResult result, Model model) {

		//Purchasedetail uppPd = pdss.uppPd(pudr);
		StockDetail uppPd = sdts.uppstkdt(pudr);
		Stock stkid = uppPd.getStkid();
		/*
		 * StockDetail sd1 = sdts.uppstkdt(pudr); //
		 * 
		 * Stock stkid = sd1.getStkid();
		 */
		
		//StockDetail pdu = sdts.getbyID(pudr);
		String s = uppPd.getBarcode();
		
		stkid.setAmount(sdts.getprtotal(uppPd.getStkid().getStockid()));
	    stkid.setNor(sdts.getcolcount(uppPd.getStkid().getStockid()));
		    stsr.uppstock(stkid);
		// System.out.println("value of updated stk"+stkid);
		System.out.println("value of s inside update method:-" + s);
		return s;
	}
//End Stock Update//	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public String deletebarrecord(@RequestParam(name = "bar") String bar) {
		 
		return "Record deleted with id:-" + pdss.deleteba(bar);

	}
	@RequestMapping(value = "/openingdelete", method = RequestMethod.POST)
	@ResponseBody
	public String deleteopeninrecord(@RequestParam(name = "bar") String bar) {
		
		StockDetail sdt1 = sdts.getbyID(bar);
		String stockid = sdt1.getStkid().getStockid();
		Stock stkid = sdt1.getStkid();
		String deleteba = sdts.deleteba(bar);
		
		stkid.setAmount(sdts.getprtotal(stockid));
	    stkid.setNor(sdts.getcolcount(stockid));
		    stsr.uppstock(stkid);
		
		    
		
		return "Record deleted with id:-" + deleteba;

	}
	@RequestMapping(value = "/userup", method = RequestMethod.POST)
	@ResponseBody
	public String actdectup(@RequestParam(name = "bar") String bar,@RequestParam(name="userid") String id) {
		System.out.println("value of bar"+bar);
	Boolean status;
		if(bar.equals("true"))
		{
			status=true;
			System.out.println("I m inside if condition");
		}
		else {
			status=false;
			System.out.println("I m inside else condition");
		}
		
		return "Record deleted with id:-" + umds.updateaactdect(id, status);

	}
	@RequestMapping(value = "/json/purinwl", method = RequestMethod.GET)
	@ResponseBody
	public List<Purchasedetail> purchdetail() {
		return pdss.getAllPrd();

	}
	@RequestMapping(value = "/json/bill", method = RequestMethod.GET)
	@ResponseBody
	public List<Bill> bills() {
		return blds.getallbill();

	}
	@RequestMapping(value = "/json/purinwl/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Purchasedetail purchdetailAll(@PathVariable String id) {

		return pdss.getPdbyId(id);
	}

	@RequestMapping(value = "/json/purdetail/{prid}", method = RequestMethod.GET)
	@ResponseBody
	public List<Purchasedetail> purchdetailbyPrID(@PathVariable String prid) {
		//System.out.println("value of prid"+prid);
		List<String>prida = new ArrayList<>();
		String[] as=prid.split(",");
		 System.out.println("value of as"+as);
		 for(int i=0;i<as.length;i++)
		 {
			 prida.add(as[i]);
		 }
		// System.out.println("value of prida"+prida);
		return pdss.getPdbyPrId(prida);
		 
	}
	
	//*******//
	@RequestMapping(value = "/json/rsldbill/{rsale}", method = RequestMethod.GET)
	@ResponseBody
	public List<BillDetail> rsalebybilldd(@PathVariable String rsale) {
 
		  return blldtdaosr.getbillitem(rsale);
		 
		 
	}
//*********//
	@ModelAttribute("maingroup")
	public List<MainGroup> getMaingroup() {
		return MGDAO.findAll();
	}

	@RequestMapping(value = "loadSubgroupByMainGroup/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String loadSubgroupByMainGroup(@PathVariable("id") int id) {
		ModelMap mp = new ModelMap();
		// mp.addAttribute("secondgroup", sgservice.findAllSubgroup(id));
		Gson gson = new Gson();
		return gson.toJson(sgservice.findAllSubgroup(id));
	}

	@RequestMapping(value = "/mg", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") ProductList mproduct, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("userClickProduct", true);
			model.addAttribute("title", "Product Master");

			return "Page1";
		}

		pls.addPL(mproduct);
		return "redirect:/POS/mg?operation=product";
	}

	@RequestMapping(value = "/json/da", method = RequestMethod.GET)
	@ResponseBody
	public List<ProductObject> prodlist() {

		return pls.findBySomefunction();
	}

	@RequestMapping(value = "/json/barcode", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String,Object>> getallbarct(@RequestParam(value="brc", required=false, defaultValue="" )String ad) {
List<Map<String,Object>> asd=new ArrayList<Map<String,Object>>();
 //ad=ad.concat("%");
		   // sdts.getall();
System.out.println("value of brc"+ad);
		 int i=1;
		 for(StockDetail sd :sdts.getlikeall(ad))
		 {
			 Map<String,Object> mydata=new HashMap<String,Object>();
			 mydata.put("l1", i);
			 mydata.put("l2", sd.getBarcode());
			 mydata.put("l3", sd.getPl().getPName());
			 mydata.put("l4", sd.getPcs());
			 mydata.put("l5", sd.getQty());
			 mydata.put("l6", sd.getBvalue());
			 mydata.put("l7", sd.getMrp());
			 asd.add(mydata);
			 i++;
		 }
		 System.out.println("value of asd"+asd);
		 return asd;
	}
	
	//***********
	
	@RequestMapping(value = "/enddata", method = RequestMethod.GET)
	@ResponseBody
	public List<LabelValueDTO> getdtb(@RequestParam(value="brc", required=false, defaultValue="" )String ad) {
List<LabelValueDTO> asd=new ArrayList<LabelValueDTO>();
 //ad=ad.concat("%");
		   // sdts.getall();
 
System.out.println("value of brc"+ad);
		  
		 for(StockDetail sd :sdts.getlikeall(ad))
		 {
			 if(sd.getBarcode().toString().concat(ad) != null) {
				 LabelValueDTO lv = new LabelValueDTO();
					lv.setLabel(sd.getBarcode().toString()); 
					lv.setValue(sd.getPl().getPName());
					asd.add(lv);
			 }
			  
		 }
		 System.out.println("value of asd"+asd);
		 return asd;
	}
	//*********
	
	
	//
	@RequestMapping(value = "/json/barcode/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getonebarct(@PathVariable String id) {
 
 
		    StockDetail sd = sdts.getaone(id);
		  int i=1;
			 Map<String,Object> mydata=new HashMap<String,Object>();
			 mydata.put("l1", i);
			 mydata.put("l2", sd.getBarcode());
			 mydata.put("l3", sd.getPl().getPName());
			 mydata.put("l4", sd.getPcs());
			 mydata.put("l5", sd.getQty());
			 mydata.put("l6", sd.getBvalue());
			 mydata.put("l7", sd.getMrp());
			 mydata.put("l8", sd.getPl().getPType()); 
			 mydata.put("l9", sd.getPl().getGSTP());
			 mydata.put("l10", sd.getPl().getGSTonSale());
			 mydata.put("l11", sd.getPl().getGSTPM());
			 mydata.put("l12", sd.getPl().getPrId());
		 
		 return mydata;
	}
	
	//
	
	@RequestMapping(value = "/json/data", method = RequestMethod.GET)
	@ResponseBody
	public List<ProductList> prodlistf() {

		return pls.allproduct();
	}

	@RequestMapping(value = "/json/data/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ProductList prodlistfid(@PathVariable String id) {

		return pls.allproductId(id);
	}

	@RequestMapping("/inventory/signin")
	public ModelAndView sighnin() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "Welcome");
		return mv;
	}

	@RequestMapping("/inventory/mg")
	public ModelAndView mgadd() {
		System.out.println("Inside deepak");
		ProductList pl = new ProductList();
		pl.setActive(true);

		ModelAndView mv = new ModelAndView("Pdemo");
		mv.addObject("maingroup", MGDAO.findAll());
		mv.addObject("product", pl);

		System.out.println("value of main group " + MGDAO.findAll());

		return mv;
	}

	@RequestMapping("/tr")
	public ModelAndView trialmap() {
		ModelAndView mv = new ModelAndView("Page1");

		mv.addObject("title", "ProductList");

		mv.addObject("userClickPurchaselist", true);

		return mv;
	}

	@RequestMapping("/trial")
	public ModelAndView trialmap1() {

		ModelAndView mv = new ModelAndView("Page1");

		mv.addObject("title", "PurchaseDetail");

		mv.addObject("userClickPurchasedetails", true);

		// System.out.println("value of main group "+sg1 );
		return mv;
	}
	@RequestMapping("/Rsaledt")
	public ModelAndView rsaled1() {

		ModelAndView mv = new ModelAndView("Page1");

		mv.addObject("title", "Retail Sale Bill");

		mv.addObject("userClickRSale", true);

		// System.out.println("value of main group "+sg1 );
		return mv;
	}
	@RequestMapping(value = "/inward", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Purchasedetail getInward(Purchasedetail p1) {

		return pdss.addpd(p1);

	}
	/*
	 * @RequestMapping(value="/purinvoic/{format}", method=RequestMethod.GET) public
	 * String purchasebill(@PathVariable String format) throws
	 * FileNotFoundException, JRException { return iws.report(format); }
	 */

	/*
	 * @RequestMapping(value = "/product", method = RequestMethod.GET) public String
	 * getAllProduct(ModelMap modelMap, HttpServletRequest request) {
	 * modelMap.addAttribute("products", productDao.getAllProduct());
	 * modelMap.addAttribute("sm", request.getParameter("sm"));
	 * modelMap.addAttribute("em", request.getParameter("em")); return "product";
	 * 
	 * }
	 */

	/*
	 * @RequestMapping(value = "/addProduct", method = RequestMethod.POST) public
	 * String saveProduct(ModelMap modelMap, HttpServletRequest request) { Product
	 * product = new Product(); product.setPname(request.getParameter("pname"));
	 * product.setPrice(Double.parseDouble(request.getParameter("price")));
	 * product.setQty(Integer.parseInt(request.getParameter("qty"))); boolean status
	 * = productDao.add(product);
	 * System.out.println("value of product inside Main Controller " + product);
	 * System.out.println("value of status " + status); if (status) {
	 * modelMap.addAttribute("sm", "Product Info Saved Successfully"); } else {
	 * modelMap.addAttribute("em", "Product Info Not Saved"); } return
	 * "redirect:/product";
	 * 
	 * }
	 */
	@RequestMapping(value = "/purinvoic/{format}", method = RequestMethod.GET)
	public ResponseEntity<InputStreamResource> getTermsConditions(@PathVariable String format)
			throws FileNotFoundException, JRException {

		return iws.report(format);

	}

	@RequestMapping(value = "/myreporttrial/{prid}", method = RequestMethod.GET)
	public void mytrialreportmethod(HttpServletResponse res, @PathVariable String prid)
			throws JRException, IOException {
		InwardRegister inwd = iws.getpurdetbyPr(prid);
		inwd.getSplid().getSname();

		res.setContentType("application/pdf");
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		List<String>prida = new ArrayList<>();
		String[] as=prid.split(",");
		 System.out.println("value of as"+as);
		 for(int i=0;i<as.length;i++)
		 {
			 prida.add(as[i]);
		 }
		for (Purchasedetail ir : pdss.getPdbyPrId(prida)) {
			Map<String, Object> item = new HashMap<String, Object>();
			 
			item.put("barcode", ir.getBarcode());
			item.put("bvalue", ir.getBvalue());
			item.put("mrp", ir.getMrp());
			item.put("exdate", ir.getExdate());
			item.put("pcs", ir.getPcs());
			item.put("qty", ir.getQty());
			item.put("pname", ir.getPl().getPName());
			int rowt = (int) (ir.getPcs() * ir.getQty() * ir.getMrp());
			item.put("rowt", rowt);
			result.add(item);
		}

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("sname", inwd.getSplid().getSname());

		param.put("state", inwd.getSplid().getState());

		param.put("pid", inwd.getPid());

		param.put("sbill", inwd.getSplinv());

		param.put("exdate", inwd.getSpldt());
		param.put("GST", inwd.getSplid().getGstno());
		param.put("address", inwd.getSplid().getAdd1() + "," + inwd.getSplid().getAdd2() + ","
				+ inwd.getSplid().getCity() + "," + inwd.getSplid().getDistrcit());
		 
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(result);
		InputStream ist = this.getClass().getResourceAsStream("/PurchaseInvoic.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(ist);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, ds);

		 
		JRPdfExporter jrPdfExporter = new JRPdfExporter(DefaultJasperReportsContext.getInstance());
		jrPdfExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		jrPdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(res.getOutputStream()));
		jrPdfExporter.exportReport();

	}

	///
	@RequestMapping(value = "/allreport/{prid}", method = RequestMethod.GET)
	public void allreportmethod(HttpServletResponse res, @PathVariable String prid)
			throws JRException, IOException {
		//InwardRegister inwd = iws.getpurdetbyPr(prid);
		//inwd.getSplid().getSname();

		res.setContentType("application/pdf");
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		List<String>prida = new ArrayList<>();
		String[] as=prid.split(",");
		 System.out.println("value of as"+as);
		 for(int i=0;i<as.length;i++)
		 {
			 prida.add(as[i]);
		 }
		for (StockDetail ir : sdts.getstkdtbystkId(prida)) {
			Map<String, Object> item = new HashMap<String, Object>();
			 
			item.put("barcode", ir.getBarcode());
			item.put("bvalue", ir.getBvalue());
			item.put("mrp", ir.getMrp());
			item.put("exdate", null);
			item.put("pcs", ir.getPcs());
			item.put("qty", ir.getQty());
			item.put("pname", ir.getPl().getPName());
			int rowt = (int) (ir.getPcs() * ir.getQty() * ir.getMrp());
			item.put("rowt", rowt);
			result.add(item);
		}

		Map<String, Object> param = new HashMap<String, Object>();
		 

		param.put("pid", prid);

		 
		 
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(result);
		InputStream ist = this.getClass().getResourceAsStream("/OpeningStock.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(ist);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, ds);

		 
		JRPdfExporter jrPdfExporter = new JRPdfExporter(DefaultJasperReportsContext.getInstance());
		jrPdfExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		jrPdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(res.getOutputStream()));
		jrPdfExporter.exportReport();

	}
	///
	
	@RequestMapping(value = "/prbarcodeprint", method = RequestMethod.GET)
	public void mybarcodeprint(HttpServletResponse res, @RequestParam Map<String, String> customQuery)
			throws JRException, IOException {
		 

		String barcodedarr = customQuery.get("barcoded");
		String textearr = customQuery.get("textv");
		String radv = customQuery.get("rad");
		String ctoselect=customQuery.get("ctos"); 
		String sbar[] = barcodedarr.split(",");
		String stext[] = textearr.split(",");

		 
System.out.println("value of ctos"+ctoselect);
		/*
		 * InwardRegister inwd = iws.getpurdetbyPr("PR_1"); inwd.getSplid().getSname();
		 */

		res.setContentType("application/pdf");
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();

		/*
		 * for(Purchasedetail ir:pdss.getPdbyPrId("PR_1")) { Map<String, Object> item=
		 * new HashMap<String, Object>();
		 * 
		 * item.put("barcode", ir.getBarcode()); item.put("bvalue", ir.getBvalue());
		 * item.put("mrp", ir.getMrp()); item.put("exdate", ir.getExdate());
		 * item.put("pcs", ir.getPcs()); item.put("qty", ir.getQty()); item.put("pname",
		 * ir.getPl().getPName()); int rowt= (int)
		 * (ir.getPcs()*ir.getQty()*ir.getMrp()); item.put("rowt", rowt);
		 * result.add(item); }
		 */

		for (int i = 0; i < sbar.length; i++) {
			if (sbar[i].equals("1")) {

			} else {
				 
				//String barcode = pdss.getPdbyId(sbar[i]).getBarcode();
				if(ctoselect.equals("Print-All-Barcode"))
				{
					for (int j = 0; j <  Integer.parseInt(stext[i]); j++) {
						//System.out.println("Value of barcode" + barcode);
						Map<String, Object> item = new HashMap<String, Object>();
						 
						item.put("barcode", sbar[i]);
						item.put("ProductName",sdts.getbyID(sbar[i]).getPl().getPName());
						if (radv.equals("W")) {
							item.put("mrp", sdts.getbyID(sbar[i]).getMrp());
						} else {
							item.put("mrp", sdts.getbyID(sbar[i]).getBvalue());
						}
						result.add(item);
					}
					
				}else {
					for (int j = 0; j <= Integer.parseInt(stext[i]); j++) {
						//System.out.println("Value of barcode" + barcode);
						Map<String, Object> item = new HashMap<String, Object>();
						item.put("barcode", pdss.getPdbyId(sbar[i]).getBarcode());
						item.put("ProductName", pdss.getPdbyId(sbar[i]).getPl().getPName());
						if (radv.equals("W")) {
							item.put("mrp", pdss.getPdbyId(sbar[i]).getMrp());
						} else {
							item.put("mrp", pdss.getPdbyId(sbar[i]).getBvalue());
						}
						result.add(item);
					}
				}
				
			}

		}

		/*
		 * Map<String, Object> param= new HashMap<String, Object>();
		 * param.put("sname",inwd.getSplid().getSname());
		 * 
		 * param.put("state",inwd.getSplid().getState());
		 * 
		 * param.put("pid",inwd.getPid());
		 * 
		 * param.put("sbill",inwd.getSplinv());
		 * 
		 * param.put("exdate",inwd.getSpldt());
		 * param.put("GST",inwd.getSplid().getGstno()); param.put("address",
		 * inwd.getSplid().getAdd1()+","+inwd.getSplid().getAdd2()+","+inwd.getSplid().
		 * getCity()+","+inwd.getSplid().getDistrcit());
		 */
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(result);
		InputStream ist = this.getClass().getResourceAsStream("/Barcode.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(ist);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, ds);

		JRPdfExporter jrPdfExporter = new JRPdfExporter(DefaultJasperReportsContext.getInstance());
		jrPdfExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		jrPdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(res.getOutputStream()));
		jrPdfExporter.exportReport();

	}
	@RequestMapping(value = "/stocktransfer/{prid}", method = RequestMethod.GET)
	public String StockTransfer(@PathVariable String prid) {
 		iws.inwardtransfer(iws.getPurId(prid));
		return "redirect:/POS/trial";
		
	}

	@RequestMapping(value = "/barcodeprintp/{prid}", method = RequestMethod.GET)
	public ModelAndView barcodeprint(@PathVariable String prid,@RequestParam(name="ptop") String asd) {
System.out.println("value of asd"+asd);
		ModelAndView mv = new ModelAndView("Page1");
		mv.addObject("title", "BarcodePrint");
		mv.addObject("prid", prid);
		mv.addObject("userClickBarcodePrint", true);
		mv.addObject("oppur", asd);
		return mv;
	}
	
	@RequestMapping(value = "/stock", method = RequestMethod.GET)
	public ModelAndView stockdetail( ) {

		ModelAndView mv = new ModelAndView("Page1");
		mv.addObject("title", "Stock Detail");
		 
		mv.addObject("userClicStock", true);

		return mv;
	}
	@RequestMapping(value = "/json/st", method = RequestMethod.GET)
	@ResponseBody
	public List<Stock>  stockalldetail() {

		  return stsr.findstockall();
	}
	@RequestMapping(value = "/stockOpening", method = RequestMethod.GET)
	public ModelAndView stockopening(@RequestParam(name = "opn_id") String purid) {
		 
		
		
		StockDetail pdop= new StockDetail();
		ModelAndView mv = new ModelAndView("Page1");
		mv.addObject("title", "Opening Batch");
		 mv.addObject("stockOpeningdet", pdop);
		mv.addObject("userClicStockOpening", true);
		mv.addObject("purid", purid);
		return mv;
	}

	//
	@RequestMapping(value = "/stockOpening", method = RequestMethod.POST)
	@ResponseBody
	public String handleopenstock(  Stock stk, BindingResult result,
			Model model) {
		String s="";
System.out.println("value of stk"+stk);
		
		  System.out.println("value of niw.getPid() is = " + stk.getStockid());
			/*
			 * if (result.hasErrors()) {
			 * 
			 * model.addAttribute("userClickPurchase", true); model.addAttribute("title",
			 * "Purchase"); return "Page1"; }
			 */
		  if (stk.getStockid().equals("")||stk.getStockid().isEmpty()||stk.getStockid()==null) 
		  {  Stock saveStock1 = stsr.saveStock(stk); 
		  s=saveStock1.getStockid();
		   
		  
		  System.out.println("value of s inside add method:-" + s); 
		  } 
		  else {
		  stsr.uppstock(stk); 
		  s = stk.getStockid();
		  System.out.println("value of s inside update method:-" + s); }
		 
		System.out.println("{\"status\":\"success\"}");
		 // return "redirect:/purchase?pur_id=" + s;
		return "{\"status\":\"" + s + "\"}";
	}


	//
	//
	@RequestMapping(value = "/stockOpeningdet", method = RequestMethod.POST)
	@ResponseBody
	public String handleopenbat(@Valid @ModelAttribute("stockOpeningdet") StockDetail pudr, BindingResult result,
			Model model) {
		System.out.println("I m inseide post function /stockOpeningdet and value of pudr is " + pudr);
		String s = "";

		System.out.println("value of niw.getPid() is = " + pudr);
		System.out.println("value of niw.getPid() is = " + pudr.getBarcode());
		if (result.hasErrors()) {
			System.out.println("Inside error");
			System.out.println("value of result" + result.toString());
			model.addAttribute("userClicStockOpening", true);
			model.addAttribute("title", "Purchase");
			return "Page1";
		}

		if (pudr.getBarcode().equals("") || pudr.getBarcode() == null) {
			System.out.println("Inside if condition");
			StockDetail sd1 = sdts.addstkdt(pudr);
			    Stock stkid = sd1.getStkid();
			    String stkist = sd1.getStkid().getStockid();
			    System.out.println("value of stkist inside update "+stkist);
			    stkid.setAmount(sdts.getprtotal(sd1.getStkid().getStockid()));
			    stkid.setNor(sdts.getcolcount(sd1.getStkid().getStockid()));
			stsr.uppstock(stkid);
			System.out.println("value of s inside add method:-" + s);
		} else {
			StockDetail sd1 = sdts.uppstkdt(pudr);
//
			 
		    Stock stkid = sd1.getStkid();
		    String stkist = sd1.getStkid().getStockid();
		    System.out.println("value of stkist inside update "+stkist);
		    stkid.setAmount(sdts.getprtotal(sd1.getStkid().getStockid()));
		    stkid.setNor(sdts.getcolcount(sd1.getStkid().getStockid()));
		stsr.uppstock(stkid);
			//
			s = pudr.getBarcode();
			System.out.println("value of s inside update method:-" + s);
		}
		System.out.println("{\"status\":\"success\"}");
		// return "redirect:/purchase?pur_id=" + s;
		return "{\"status\":\"" + s + "\"}";
	}

	//
	@RequestMapping(value = "/json/opdetail/{prid}", method = RequestMethod.GET)
	@ResponseBody
	public List<StockDetail> stockdetailbyStkID(@PathVariable String prid) {
		//System.out.println("value of prid"+prid);
		List<String>prida = new ArrayList<>();
		String[] as=prid.split(",");
		 System.out.println("value of as"+as);
		 for(int i=0;i<as.length;i++)
		 {
			 prida.add(as[i]);
		 }
		// System.out.println("value of prida"+prida);
		return sdts.getstkdtbystkId(prida);
		 
	}
	//
	
	//
	@RequestMapping(value = "/json/rsaledetail", method = RequestMethod.GET)
	@ResponseBody
	public List<Bill> rsaledtid() {
		//System.out.println("value of prid"+prid);
		 
		return  blds.getallbill();
		
		 
	}
	
	//
	
	  @RequestMapping(value="/register", method=RequestMethod.POST)
	  public String saveUserByAdmin(@Valid @ModelAttribute("userd") UserMDetail umd, BindingResult result,Model model)
	  { 	String s;
		
	  			System.out.println("value of umd is = " + umd);

				System.out.println("value of niw.getPid() is = " + umd.getUsername());
				if (result.hasErrors()) {
						
					model.addAttribute("title", "User Management");
					model.addAttribute("userClickUserMg", true);
					return "Page1";
				}
				 authentication =  SecurityContextHolder.getContext().getAuthentication();
				 String name = authentication.getName();
				 System.out.println("value of name"+name);
				 // OrgDetail orgdetail2 = umds.getuser(username).getOrgdetail();
				umd.setEnabled(true);
				UserMDetail getuser = umds.getuser(name);
				OrgDetail orgdetail = getuser.getOrgdetail();
				 
				umd.setOrgdetail(orgdetail);
				System.out.println("value of umd after update = " + umd);
				 
				 
				
				 
				  String pwd =umd.getPassword();
				  System.out.println("value of pass"+pwd);
				   
				  String encryPwd=brc.encode(pwd); 
				  System.out.println("value of encryPwd"+encryPwd);
				   
				  umd.setPassword(encryPwd); 
				  umds.addMasterUser(umd);
				 
	  return "redirect:/POS/register"; 
	  }
	  @RequestMapping(value="/register", method=RequestMethod.GET)
	  public ModelAndView getUserByAdmin()
	  {UserMDetail userMDetail = new UserMDetail();
	  ModelAndView mv = new ModelAndView("Page1");
	  mv.addObject("userd", userMDetail);
	  mv.addObject("changepass", userMDetail);
		mv.addObject("title", "User Management");

		mv.addObject("userClickUserMg", true);

		return mv;
		  
	  }
@RequestMapping(value="/logidet", method=RequestMethod.GET)
@ResponseBody	
	public List<UserMDetail> addUserByAdmin()
	{
	return umds.getalluser();
	 
	}
@RequestMapping(value = "/bill", method = RequestMethod.POST)
@ResponseBody
public String handlebill(@Valid @ModelAttribute("billd") Bill bl, BindingResult result, Model model) {
	String s;
	System.out.println("value of bill is = " + bl);
	if (result.hasErrors()) {

		model.addAttribute("userClickBill", true);
		model.addAttribute("title", "Retail Sale");
		return "Page1";
	}
	if (bl.getBillInvId().equals("")) {
		authentication =  SecurityContextHolder.getContext().getAuthentication();
		String name = authentication.getName();
		//System.out.println("value of name"+name);
		UserMDetail getuser = umds.getuser(name);
		 bl.setUser(getuser);
	 Bill newBill = blds.newBill(bl);
	 s=newBill.getBillInvId();
		System.out.println("value of s inside add method:-" + s);
	} else {
		blds.uppBill(bl);
		s = bl.getBillInvId();
		System.out.println("value of s inside update method:-" + s);
	}
	System.out.println("{\"status\":\"success\"}");
	// return "redirect:/purchase?pur_id=" + s;
	return "{\"status\":\"" + s + "\"}";
}
@RequestMapping(value="/bill", method=RequestMethod.GET)
public ModelAndView bill(@RequestParam(name = "bill_id") String billid)
{
	//IndianStateandUT Ist= isus.getnewstate("1");
	 UserMDetail u1 = umds.finduser("Us");
	 Customers c1 = new Customers();
	 Bill b1 = new Bill();
	 BillDetail bd= new BillDetail();
	SimpleDateFormat sm = new SimpleDateFormat("MM-dd-yyyy");
 	b1.setDate(new Date());
	ModelAndView mv = new ModelAndView("Page1");
	mv.addObject("billid", billid);
	mv.addObject("billd", b1);
	mv.addObject("customer", c1);
	mv.addObject("billdt", bd);
	mv.addObject("State", isus.getallstate());
	mv.addObject("title", "Retail Sale");
	mv.addObject("userClickBill", true);
	return mv;
}

////

@RequestMapping(value="/trb", method=RequestMethod.GET)
public ModelAndView tbsta()
{
	//IndianStateandUT Ist= isus.getnewstate("1");
	 
	 
	ModelAndView mv = new ModelAndView("testtrial");
	 
	return mv;
}
///

@RequestMapping(value = "/billdet", method = RequestMethod.POST)
@ResponseBody
public String handlebilldtsq(@Valid @ModelAttribute("billdt") BillDetail pudr, BindingResult result,
		Model model) {
	System.out.println("I m inseide post function /billdet and value of pudr is " + pudr);
	String s = "";

	System.out.println("value of niw.getPid() is = " + pudr);
	System.out.println("value of niw.getPid() is = " + pudr.getBilldid());
	if (result.hasErrors()) {
		System.out.println("Inside error");
		System.out.println("value of result" + result.toString());
		model.addAttribute("userClickBill", true);
		model.addAttribute("title", "Retail Sale");
		return "Page1";
	}
	 
  
	if (pudr.getBilldid()==0 ) {
		if(pudr.getQty()==0)
		{
			pudr.setQty(1);
		}
		ProductList prname = pudr.getPrname();
		//String prname = pudr.getPrname();
		//ProductList findPL = pls.findPL(prname);
		int gsTonSale = prname.getGSTonSale();
		if(gsTonSale==0) {
			pudr.setGst(prname.getGSTP());
		}else {
			if(gsTonSale>pudr.getBprice())
			{
				pudr.setGst(prname.getGSTP()); 	
			}else {
				pudr.setGst(prname.getGSTPM()); 
			}
		}
		
		String barcode1 = pudr.getBarcode();
		System.out.println("value of barcode1 is "+barcode1);
		System.out.println("value of Bill"+pudr.getBill().getBillInvId());
		BillDetail addbilldetl;
		BillDetail getproduct2 = blldtdaosr.getproduct(pudr.getBarcode(),pudr.getBill().getBillInvId());
		System.out.println("value of getproduct2"+getproduct2);
		if(getproduct2==null) {
			  addbilldetl = blldtdaosr.addbilldetl(pudr);
		}
		else {
			BillDetail getproduct = blldtdaosr.getproduct(pudr.getBarcode(),pudr.getBill().getBillInvId());
			if(getproduct.getQty()==1)
			{
				int pcs = pudr.getPcs();
				pudr.setPcs(pcs+getproduct.getPcs());
				pudr.setBilldid(getproduct.getBilldid());
				pudr.setNet(pudr.getNet()+getproduct.getNet());
				pudr.setDiscount(pudr.getDiscount()+getproduct.getDiscount());
				blldtdaosr.updateBd(pudr);
			}
			else {
				 addbilldetl = blldtdaosr.addbilldetl(pudr);
			}
			
		}
		  //addbilldetl = blldtdaosr.addbilldetl(pudr);
		 StockRegister sr = new StockRegister();
		 sr.setStkbar(pudr.getBarcode().substring(1, 10));
		 sr.setTqty(pudr.getQty()*pudr.getPcs());
		 srdaosr.removeStock(sr);
		 String billInvId = pudr.getBill().getBillInvId();
		 blds.updetail(billInvId);
	} else {
		BillDetail updateBd = blldtdaosr.updateBd(pudr);
		StockRegister sr = new StockRegister();
		 sr.setStkbar(updateBd.getBarcode().substring(1, 10));
		 sr.setTqty(pudr.getQty()*pudr.getPcs());
		 srdaosr.removeStock(sr);
		 String billInvId = pudr.getBill().getBillInvId();
		 blds.updetail(billInvId);
		s = pudr.getBarcode();
		System.out.println("value of s inside update method:-" + s);
	}
	System.out.println("{\"status\":\"success\"}");
	// return "redirect:/purchase?pur_id=" + s;
	return "{\"status\":\"" + s + "\"}";
}
@RequestMapping(value = "/billadddet", method = RequestMethod.POST)
@ResponseBody
public String handlebilladddtsq(@Valid @ModelAttribute("billadddet") BillDetail pudr, BindingResult result,
		Model model) {
			return null;

}
@RequestMapping(value = "/json/stockrg/{id}", method = RequestMethod.GET)
@ResponseBody
public StockRegister stockbalancechk(@PathVariable String id) {

	return srdaosr.findStkRrg(id);
}
}
