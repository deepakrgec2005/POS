package com.dk.rsale.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

import com.dk.rsale.Service.InwardRegisterSer;
import com.dk.rsale.Service.MainGroupService;
import com.dk.rsale.Service.NewBarcodeGenSer;
import com.dk.rsale.Service.ProductListServices;
import com.dk.rsale.Service.PurchaseService;
import com.dk.rsale.Service.PurchasedetailServ;
import com.dk.rsale.Service.SubGroupService;
import com.dk.rsale.Service.SupplierService;
import com.dk.rsale.dao.MainGroupDAO;
import com.dk.rsale.dao.ProductDao;
import com.dk.rsale.entity.InwardRegister;
import com.dk.rsale.entity.MainGroup;
import com.dk.rsale.entity.Product;
import com.dk.rsale.entity.ProductList;
import com.dk.rsale.entity.ProductObject;
import com.dk.rsale.entity.Purchasedetail;
import com.dk.rsale.entity.Supplier;
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
public class MainController {

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
	 
	@RequestMapping(value = { "/", "/home" })
	public ModelAndView HomeCont() {
		// ModelAndView mv = new ModelAndView("Home");
		ModelAndView mv = new ModelAndView("Page1");
		mv.addObject("title", "Home");

		mv.addObject("userClickHome", true);

		return mv;
	}

	@RequestMapping(value = "/login")
	public ModelAndView login() {
		// ModelAndView mv = new ModelAndView("Home");
		ModelAndView mv = new ModelAndView("login");
		/*
		 * mv.addObject("title", "Home");
		 * 
		 * mv.addObject("userClickHome", true);
		 */

		return mv;
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

		ModelAndView mv = new ModelAndView("Page1");
		mv.addObject("maingroup", MGDAO.findAll());
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

		return "redirect:/supplier?operation=supplier";
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
		Boolean trnv ;
		// ModelAndView mv = new ModelAndView("Home");
		ModelAndView mv = new ModelAndView("Page1");
		InwardRegister p1;
		if (purid.equals("0")) {
			p1 = new InwardRegister();
			p1.setTransf(false);
			trnv=false;
			System.out.println("Inside 0:- ");
			//System.out.println("value of transfer "+trnv);
		} else {
			p1 = iws.getPurId(purid);
			trnv = p1.getTransf();
			System.out.println("Inside other condition:- ");
		}
		Purchasedetail pd = new Purchasedetail();
		mv.addObject("purid", purid);
		mv.addObject("purchase", p1);
		mv.addObject("purrege",pd);
		mv.addObject("title", "Purchase");
		mv.addObject("transfdv",trnv);
		mv.addObject("userClickPurchase", true);

		return mv;
	}

	@RequestMapping(value = "/purchase", method = RequestMethod.POST)
	@ResponseBody
	public String handlepurchase(@Valid @ModelAttribute("purchase") InwardRegister niwr, BindingResult result,Model model) 
	{
		String s;

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
		//return "redirect:/purchase?pur_id=" + s;
		return "{\"status\":\""+s+"\"}";
	}

	@RequestMapping(value = "/purrege", method = RequestMethod.POST)
	@ResponseBody
	public String handlepurchasereg(@Valid @ModelAttribute("purrege") Purchasedetail pudr, BindingResult result,Model model) 
	{
		System.out.println("I m inseide post function /purrege and value of pudr is "+pudr);
		String s="";
		 
		System.out.println("value of niw.getPid() is = " + pudr); 
		System.out.println("value of niw.getPid() is = " + pudr.getBarcode());
		if (result.hasErrors()) {
			System.out.println("Inside error");
			System.out.println("value of result"+ result.toString());
			model.addAttribute("userClickPurchase", true);
			model.addAttribute("title", "Purchase");
			return "Page1";
		}
		
		if (pudr.getBarcode().equals("")||pudr.getBarcode()==null) {
			 pdss.addpd(pudr);

			System.out.println("value of s inside add method:-" + s);
		} 
		else {
			pdss.uppPd(pudr);
			 
			  	s = pudr.getBarcode();
			  	System.out.println("value of s inside update method:-" + s);
		}
System.out.println("{\"status\":\"success\"}");
		//return "redirect:/purchase?pur_id=" + s;
		return "{\"status\":\""+s+"\"}";
	}
	@RequestMapping(value = "/pliupdate")
	public ModelAndView updatepuddetail(@RequestParam(name = "bar") String bar) {
		
		Purchasedetail pdu =  pdss.getPdbyId(bar);
		ModelAndView mv = new ModelAndView("Page1");

		mv.addObject("title", "ProductListUpdate");

		mv.addObject("userClickPurchaselistupdate", true);
		mv.addObject("purrege", pdu);
		// System.out.println("value of main group "+sg1 );
		return mv;
 	}
	
	@RequestMapping(value = "/pliupdate", method = RequestMethod.POST)
	@ResponseBody 
	public String updatepuddetailP(@Valid @ModelAttribute("purrege") Purchasedetail pudr,@RequestParam(name = "bar", required = false) String bar, BindingResult result,Model model) {
		
		
			Purchasedetail uppPd = pdss.uppPd(pudr);
			 
		String 	s = uppPd.getBarcode();
			System.out.println("value of s inside update method:-" + s);
		 return s;
 	}
	
@RequestMapping(value="/delete", method= RequestMethod.POST)
@ResponseBody
public String deletebarrecord(@RequestParam(name = "bar") String bar)
{
	return "Record deleted with id:-"+pdss.deleteba(bar);
	 
}
	
	@RequestMapping(value = "/json/purinwl", method = RequestMethod.GET)
	@ResponseBody
	public List<Purchasedetail> purchdetail() {
		return pdss.getAllPrd();

	}
	@RequestMapping(value = "/json/purinwl/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Purchasedetail purchdetailAll(@PathVariable String id) {

		return pdss.getPdbyId(id);
	}@RequestMapping(value = "/json/purdetail/{prid}", method = RequestMethod.GET)
	@ResponseBody
	public List<Purchasedetail> purchdetailbyPrID(@PathVariable String prid) {

		return pdss.getPdbyPrId(prid);
	}
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
		return "redirect:/mg?operation=product";
	}

	@RequestMapping(value = "/json/da", method = RequestMethod.GET)
	@ResponseBody
	public List<ProductObject> prodlist() {

		return pls.findBySomefunction();
	}

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

		System.out.println("Inside deepak");

		System.out.println("value of product of some columns");
	 
		ModelAndView mv = new ModelAndView("Page1");

		mv.addObject("title", "PurchaseDetail");

		mv.addObject("userClickPurchasedetails", true);

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
	public ResponseEntity<InputStreamResource> getTermsConditions(@PathVariable String format) throws FileNotFoundException, JRException {

		
		 
        return  iws.report(format);
        
    }
	
	@RequestMapping(value = "/myreporttrial/{prid}", method = RequestMethod.GET)
	public void mytrialreportmethod(HttpServletResponse res,@PathVariable String prid) throws JRException, IOException
	{
		InwardRegister inwd = iws.getpurdetbyPr(prid);
		 inwd.getSplid().getSname();
		
		res.setContentType("application/pdf");
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		
		for(Purchasedetail ir:pdss.getPdbyPrId(prid)) {
			Map<String, Object> item= new HashMap<String, Object>();
			/*
			 * item.put("pid", ir.getPid()); item.put("intype", ir.getIntype());
			 * item.put("pdate", ir.getPdate()); item.put("spldt", ir.getSpldt());
			 * item.put("splinv", ir.getSplinv()); item.put("transf", ir.getTransf());
			 * item.put("splid", ir.getSplid());
			 */
			item.put("barcode", ir.getBarcode());
			item.put("bvalue", ir.getBvalue());
			item.put("mrp", ir.getMrp());
			item.put("exdate", ir.getExdate());
			item.put("pcs", ir.getPcs());
			item.put("qty", ir.getQty());
			item.put("pname", ir.getPl().getPName());
			int rowt= (int) (ir.getPcs()*ir.getQty()*ir.getMrp());
			item.put("rowt", rowt);
			 result.add(item);
		}
		
		 Map<String, Object> param= new HashMap<String, Object>();
		 param.put("sname",inwd.getSplid().getSname());
		 
		param.put("state",inwd.getSplid().getState());
		 
		param.put("pid",inwd.getPid());
		 
		param.put("sbill",inwd.getSplinv());
		 
		param.put("exdate",inwd.getSpldt());
		param.put("GST",inwd.getSplid().getGstno());
		param.put("address", inwd.getSplid().getAdd1()+","+inwd.getSplid().getAdd2()+","+inwd.getSplid().getCity()+","+inwd.getSplid().getDistrcit());
		//result.add(item);
		//List<InwardRegister> getallInty = iws.getallInty("purchase");
		
		//JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(iws.getallInty("purchase"));
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(result);
		InputStream ist=this.getClass().getResourceAsStream("/PurchaseInvoic.jrxml");
		JasperReport jasperReport =JasperCompileManager.compileReport(ist);
		JasperPrint jasperPrint =JasperFillManager.fillReport(jasperReport, param,ds);
		  
		/*
		 * HtmlExporter htmlexp = new
		 * HtmlExporter(DefaultJasperReportsContext.getInstance());
		 * htmlexp.setExporterInput(new SimpleExporterInput(jasperPrint));
		 * htmlexp.setExporterOutput(new SimpleHtmlExporterOutput(res.getWriter()));
		 * htmlexp.exportReport();
		 */
		JRPdfExporter jrPdfExporter = new JRPdfExporter(DefaultJasperReportsContext.getInstance());
		jrPdfExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		jrPdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(res.getOutputStream()));
		jrPdfExporter.exportReport();
		 
	}
	
	@RequestMapping(value = "/prbarcodeprint", method = RequestMethod.GET)
	public void mybarcodeprint(HttpServletResponse res, @RequestParam Map<String, String> customQuery) throws JRException, IOException
	{
		System.out.println("customQuery = barcoded "+customQuery.containsKey("barcoded"));
		 
		String barcodedarr=customQuery.get("barcoded");
		String textearr=customQuery.get("textv");
		String  radv=customQuery.get("rad");
		System.out.println("value of barcodedarr"+barcodedarr);
		System.out.println("value of textearr"+textearr);
		System.out.println("value of radv"+radv);
		String sbar[]=barcodedarr.split(",");
		String stext[]=textearr.split(",");
		
		System.out.println("value of sbar"+sbar[0]);
		System.out.println("value of stext"+stext[0]);
		
		System.out.println("value of sbar length"+sbar.length);
		System.out.println("value of stext length"+stext.length);
		
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
		
		 for(int i=0;i<sbar.length;i++)
		 {
			 if(sbar[i].equals("1"))
			 {
				 
			 }else {
				 System.out.println("value of sbar[i]"+sbar[i]);
				   String barcode = pdss.getPdbyId(sbar[i]).getBarcode();
				 
				 for(int j=0;j<Integer.parseInt(stext[i]);j++)
				 {
					 System.out.println("Value of barcode"+barcode);
					 Map<String, Object> item= new HashMap<String, Object>();
					 item.put("barcode", pdss.getPdbyId(sbar[i]).getBarcode());
					 item.put("ProductName", pdss.getPdbyId(sbar[i]).getPl().getPName());
					 if(radv.equals("W"))
					 {
						 item.put("mrp", pdss.getPdbyId(sbar[i]).getMrp());
					 }
					 else {
						 item.put("mrp", pdss.getPdbyId(sbar[i]).getBvalue());
					 }
					 result.add(item);
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
		InputStream ist=this.getClass().getResourceAsStream("/Barcode.jrxml");
		JasperReport jasperReport =JasperCompileManager.compileReport(ist);
		JasperPrint jasperPrint =JasperFillManager.fillReport(jasperReport, null,ds);
		  
		 
		JRPdfExporter jrPdfExporter = new JRPdfExporter(DefaultJasperReportsContext.getInstance());
		jrPdfExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		jrPdfExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(res.getOutputStream()));
		jrPdfExporter.exportReport();
		 
	}
	
	
	
	@RequestMapping(value ="/barcodeprintp/{prid}" , method = RequestMethod.GET)
	public ModelAndView barcodeprint(@PathVariable String prid) {
		
		 
		ModelAndView mv = new ModelAndView("Page1");
		mv.addObject("title", "BarcodePrint");
		mv.addObject("prid",prid);
		mv.addObject("userClickBarcodePrint", true);

		return mv;
	}
}
