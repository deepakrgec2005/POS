package com.dk.rsale.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dk.rsale.dao.UserDao;
import com.dk.rsale.daoimpl.UserDAOImpl;
import com.dk.rsale.entity.Users;

@Controller
public class UsersController {
    
    @Autowired
    private UserDao userDAO;
     
    
    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public String loginCheck(ModelMap modelMap, HttpServletRequest request){
        
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
		
		  System.out.println("value of userName"+userName);
		  System.out.println("before printing value of user"); 
			/*
			 * Users user1 = new Users(); user1.setUserName("admin");
			 * user1.setEmail("abc@fmail.com"); user1.setPassword("1234"); boolean u1
			 * =userDAO.addUser(user1);
			 */
		 
        Users u = userDAO.getByUserName(userName); 
        		System.out.println("value of u"+u);
        HttpSession session = request.getSession();
        if(u != null){
            session.setAttribute("user_id", u.getUserId());
        }else{
            modelMap.addAttribute("em", "User Not Found, try again");
        }
        
        return "redirect:/";
        
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("user_id") != null){
            session.setAttribute("user_id", null);
        }
        return "index";
    }
    
}
