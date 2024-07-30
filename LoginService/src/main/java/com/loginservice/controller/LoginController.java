package com.loginservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.loginservice.model.UserModel;
import com.loginservice.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService service;
	
	@RequestMapping("/")
	public String homePage() {
		return "homepage";
	}
	
	@RequestMapping("login") 
	public String loginPage() {
		return "loginpage";
	}
	
	@RequestMapping("signup") 
	public String signUpPage() {
		return "signuppage";
	}
	
	@RequestMapping("loginvalidate")
	public ModelAndView validateLogin(@RequestParam("email") String email,@RequestParam("password") String password, ModelAndView mv) {

		String msg = service.validateLogin(email, password);
		mv.addObject("message",msg);
		mv.setViewName("display");
		
		return mv;
	}
	
	@RequestMapping("signinvalidate")
	public ModelAndView validateSignUp(@ModelAttribute("UserModel") UserModel user ,ModelAndView mv) {
//	public ModelAndView validateSignUp(@RequestParam("email") String email,@RequestParam("password") String password, @RequestParam("username") String username ,ModelAndView mv) {

		String msg = service.validateSignUp(user);
		mv.addObject("message",msg);
		mv.setViewName("display");
		
		return mv;
	}
	
	
}
