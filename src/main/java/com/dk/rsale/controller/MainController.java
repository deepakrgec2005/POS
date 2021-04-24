package com.dk.rsale.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.dk.rsale.Service.MainGroupService;
import com.dk.rsale.Service.NewBarcodeGenSer;
import com.dk.rsale.Service.ProductListServices;
import com.dk.rsale.Service.PurchaseService;
import com.dk.rsale.Service.SubGroupService;
import com.dk.rsale.Service.SupplierService;
import com.dk.rsale.dao.MainGroupDAO;
import com.dk.rsale.dao.ProductDao;
import com.dk.rsale.entity.MainGroup;
import com.dk.rsale.entity.NewBarcodeCreator;
import com.dk.rsale.entity.Product;
import com.dk.rsale.entity.ProductList;
import com.dk.rsale.entity.Purchase;
import com.dk.rsale.entity.Supplier;
import com.google.gson.Gson;

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
	@RequestMapping(value = { "/", "/home" })
	public ModelAndView HomeCont() {
		//ModelAndView mv = new ModelAndView("Home");
		ModelAndView mv = new ModelAndView("Page1");
		mv.addObject("title", "Home");

		mv.addObject("userClickHome", true);
		
		return mv;
	}
	
	@RequestMapping(value ="/login")
	public ModelAndView login() {
		//ModelAndView mv = new ModelAndView("Home");
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
		//ModelAndView mv = new ModelAndView("Home");
		ModelAndView mv = new ModelAndView("Page1");
		mv.addObject("title", "About Us");

		mv.addObject("userClickAbout", true);
		
		return mv;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		//ModelAndView mv = new ModelAndView("Home");
		ModelAndView mv = new ModelAndView("Page1");
		mv.addObject("title", "Contact Us");

		mv.addObject("userClickContact", true);
		
		return mv;
	}
	@RequestMapping(value = "/mg",method=RequestMethod.GET)
	public ModelAndView proli(@RequestParam(name="operation", required=false) String operation) {
		//ModelAndView mv = new ModelAndView("Home");
		ProductList pl = new ProductList();
		pl.setActive(true);
		
		
		ModelAndView mv = new ModelAndView("Page1");
		mv.addObject("maingroup", MGDAO.findAll());
		mv.addObject("product",pl);
		mv.addObject("title", "Product Master");

		mv.addObject("userClickProduct", true);
		if(operation!=null) 
		{
			if(operation.equals("product"))
			{
				mv.addObject("message","Product Submitted Successfully!");
			}
			 
		}
		return mv;
	}
	@RequestMapping(value = "/supplier")
	public ModelAndView supplier(@RequestParam(name="operation", required=false) String operation) {
		
		
		//ModelAndView mv = new ModelAndView("Home");
		ModelAndView mv = new ModelAndView("Page1");
		if(operation!=null) 
		{
			if(operation.equals("supplier"))
			{
				mv.addObject("message","Supplier Added Successfully!");
			}
			 
		}
		
		Supplier s1= new Supplier();
		 
		 
		
		mv.addObject("supplier", s1);
		 
		mv.addObject("title", "Supplier");

		mv.addObject("userClickSupplier", true);
		
		return mv;
	}

	@RequestMapping(value="/supplier/{id}",method=RequestMethod.GET)
	public ModelAndView supplierUpdate(@PathVariable int  id) 
	{
		ModelAndView mv = new ModelAndView("Page1");
		 
			 
		
		Supplier s1= ss.getbyAdrrID(id);
		 
		 
		
		mv.addObject("supplier", s1);
		 
		mv.addObject("title", "Supplier");

		mv.addObject("userClickSupplier", true);
		
		return mv;
	}
	
	@RequestMapping(value="/supplier", method=RequestMethod.POST)
	public String handleSupplierSubmission(@Valid @ModelAttribute("supplier") Supplier spp, BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			
			model.addAttribute("userClickSupplier", true);
			model.addAttribute("title", "Supplier");
			return "Page1";
		}
		if(spp.getSid()==0)
		{
			ss.addSupplier(spp);	
		}
		else {
			
			ss.updatad(spp);
		}
		
		return "redirect:/supplier?operation=supplier";
	}
	
	@RequestMapping(value="/json/supplier", method =RequestMethod.GET)
	@ResponseBody
	public List<Supplier> suplierdetails() {
		return ss.getbyAll();
		 
		
	}
	@RequestMapping(value="/json/purchase", method =RequestMethod.GET)
	@ResponseBody
	public Purchase purchased() {
		return purse.getPurId("PR_00001");
		 
		
	}
	
	@RequestMapping(value = "/purchase")
	public ModelAndView purchase() {
		
		
		//ModelAndView mv = new ModelAndView("Home");
		ModelAndView mv = new ModelAndView("Page1");
		 
		
		Purchase p1= new Purchase();
		 
		 
		
		mv.addObject("purchase", p1);
		 
		mv.addObject("title", "Purchase");

		mv.addObject("userClickPurchase", true);
		
		return mv;
	}

	
	
	@ModelAttribute("maingroup")
	public List<MainGroup>getMaingroup()
	{
		return MGDAO.findAll();
	}
	 
	@RequestMapping(value="loadSubgroupByMainGroup/{id}", method =RequestMethod.GET)
	@ResponseBody
	public String loadSubgroupByMainGroup(@PathVariable("id") int id )
	{ModelMap mp=new ModelMap();
	// mp.addAttribute("secondgroup", sgservice.findAllSubgroup(id));
	Gson gson= new Gson();
		return gson.toJson(sgservice.findAllSubgroup(id));
	}
	@RequestMapping(value="/mg", method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") ProductList mproduct, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			model.addAttribute("userClickProduct", true);
			model.addAttribute("title", "Product Master");
			 
			return "Page1";
		}
		
		pls.addPL(mproduct);
		return "redirect:/mg?operation=product";
	}
	@RequestMapping(value="/json/data", method =RequestMethod.GET)
	@ResponseBody
	public List<ProductList> prodlist()
	{
		
		return pls.allproduct();
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
		
		ModelAndView mv= new ModelAndView("Pdemo");
		mv.addObject("maingroup", MGDAO.findAll());
		mv.addObject("product",pl);
		
		System.out.println("value of main group "+MGDAO.findAll()  );
		 
		
		
		/*
		 * Optional<MainGroup> optional = MGDAO.findById(1); MainGroup mg =
		 * optional.get(); mg.setMid(1); mg.setMName("KHADI"); MGDAO.save(mg);
		 */
		/*
		 * Optional<MainGroup> mg1 = MGDAO.findById(1); SubGroup sg = new SubGroup();
		 * 
		 * sg.setSname("Saree"); sg.setMg(mg1.get());
		 * 
		 * sgservice.addSbgroup(sg);
		 */
		
		/*
		 * sg.setSname("Kurta"); sg.setMg(mg1.get());
		 * 
		 * sgservice.addSbgroup(sg);
		 */
		/*
		 * SubGroup sg = sgservice.findSubgroup(2); sgservice.deleteSbgroup(sg);
		 */
		
		/*
		 * MainGroup mg = mgservice.findMGID(1); SubGroup sg =
		 * sgservice.findSubgroup(1); sg.setMg(mg); sg.setSname("Dupata"); sg.setSid(1);
		 * sgservice.updateSubGroup(sg);
		 */
		/*
		 * SubGroup sg = sgservice.findSubgroup(1);
		 * 
		 * int mid = sg.getMg().getMid();
		 * 
		 * ProductList pg =new ProductList(); pg.setPrId("KAUSHIK_2");
		 * pg.setPName("Kaushik Product"); pg.setPSName("Kaushik Special Product");
		 * pg.setPType("Mesurable"); pg.setSg(sg); pg.setMid(mid); pg.setHSNCODE(1234);
		 * pg.setGSTP(5); pg.setGSTonSale(1000); pg.setGSTPM(12); pg.setActive(true);
		 * pls.updatePL(pg);
		 */
		
		/*
		 * ProductList pl1 = pls.findPL("KAUSHIK_2"); pl1.setActive(false);
		 * pls.updateAc(pl1);
		 * 
		 * System.out.println("value of mg ");
		 */
		
		
		return mv;
	}
	
	
	@RequestMapping("/tr")
	public ModelAndView trialmap() {
		
		System.out.println("Inside deepak");
		  
		 System.out.println("value of product of some columns");
		ModelAndView mv= new ModelAndView("trialpage");


		
	//	System.out.println("value of main group "+sg1 );
		 return mv;
	}
	
@RequestMapping(value = "/product", method = RequestMethod.GET)
public String getAllProduct(ModelMap modelMap, HttpServletRequest request) {
    modelMap.addAttribute("products", productDao.getAllProduct());
    modelMap.addAttribute("sm", request.getParameter("sm"));
    modelMap.addAttribute("em", request.getParameter("em"));
    return "product";

}
@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
public String saveProduct(ModelMap modelMap, HttpServletRequest request) {
    Product product = new Product();
    product.setPname(request.getParameter("pname"));
    product.setPrice(Double.parseDouble(request.getParameter("price")));
    product.setQty(Integer.parseInt(request.getParameter("qty")));
    boolean status = productDao.add(product);
    System.out.println("value of product inside Main Controller "+product);
    System.out.println("value of status "+ status);
    if (status) {
        modelMap.addAttribute("sm", "Product Info Saved Successfully");
    } else {
        modelMap.addAttribute("em", "Product Info Not Saved");
    }
    return "redirect:/product";
}

 


}
