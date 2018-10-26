package com.studentmanager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginControler {
	@RequestMapping("/")
	public String defaul() {		
		return "Login";
	}
	
	@RequestMapping(value = "/LoginForm", method = RequestMethod.POST)
	public String loginForm(@RequestParam ("email")String email,@RequestParam("password") String password, ModelMap modelMap, HttpSession session) {
		if(email == null || email.isEmpty()) {
			modelMap.addAttribute("errEmail", "Vui lòng nhập email!");
		}
		
		if(password == null || password.isEmpty()) {
			modelMap.addAttribute("errPassword", "Vui lòng nhập password!");
		}
		
		modelMap.addAttribute("email", email);
		modelMap.addAttribute("password", password);
		session.setAttribute("email", email);
		
		if(email.equals("thanh@gmail.com") && password.equals("123456")) {
			return "redirect:/Home";
		}else {
			if(email != "" && password !="") {
			modelMap.addAttribute("errLogin", "Email hoặc password sai. Bạn vui lòng nhập lại!");
			}
			return "Login";
		}
		
	}
}
