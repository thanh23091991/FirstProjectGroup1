package com.studentmanager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {
	@RequestMapping(value ="/Logout", method = RequestMethod.POST)
	public String defaul(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
