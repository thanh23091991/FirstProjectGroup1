package com.studentmanager.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentmanager.entity.Users;
import com.studentmanager.service.UsersService;

@Controller
public class LoginControler {
	@Autowired
	UsersService usersService;

	@RequestMapping("/")
	public String defaul() {
		return "Login";
	}

	@RequestMapping(value = "/LoginForm", method = RequestMethod.POST)
	public String loginForm(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		
		if (email == null || email.isEmpty()) {
			modelMap.addAttribute("errEmail", "Vui lòng nhập email!");
		}

		if (password == null || password.isEmpty()) {
			modelMap.addAttribute("errPassword", "Vui lòng nhập password!");
		}

		modelMap.addAttribute("email", email);
		modelMap.addAttribute("password", password);
		Users user = usersService.findByEmailAndPassword(email, password);
		if (user != null) {
			session.setAttribute("email", email);
			if (request.getParameter("remember") != null) {
				Cookie ckEmail = new Cookie("email", email);
				ckEmail.setMaxAge(60);
				response.addCookie(ckEmail);
				Cookie ckPassword = new Cookie("password", password);
				ckPassword.setMaxAge(60);
				response.addCookie(ckPassword);
			}
			return "redirect:/Home";
		} else {
			if (email != "" && password != "") {
				modelMap.addAttribute("errLogin", "Email hoặc password sai. Bạn vui lòng nhập lại!");
			}
			return "Login";
		}
	}
}
