package com.studentmanager.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.studentmanager.entity.Diem;
import com.studentmanager.service.DiemRepository;

@Controller
public class PointController {
	@Autowired
	private DiemRepository diemRepository;
	
	@RequestMapping("/point")
	public String viewListPoint(Model model) {
		List<Diem> diems = diemRepository.findAll();
		model.addAttribute("pointList", diems);
		
		return "Point";
	}
}
