package com.studentmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentmanager.entity.Diem;
import com.studentmanager.service.DiemRepository;
import com.studentmanager.service.DiemRepositoryCustomImpl;

@Controller
public class PointController {
	@Autowired
	private DiemRepository diemRepository;

	@RequestMapping(value = { "/point" }, method = RequestMethod.GET)
	public String viewListPoint(Model model) {
		List<Diem> diems = diemRepository.findAll();
		model.addAttribute("pointList", diems);

		return "Point";
	}

	@RequestMapping("/insPoint")
	public String goToInsertPoint() {
		
		return "InsertPoint";
	}

	@RequestMapping(value = { "/udpPoint" }, method = RequestMethod.GET)
	public String goToUpdatePoint(@RequestParam("masv") String masv, @RequestParam("mamh") String mamh,
			@RequestParam("diem1") int diem1, @RequestParam("diem2") int diem2, @RequestParam("hocky") int hocky,
			Model model) {
		Diem diem = new Diem(masv, mamh, hocky, diem1, diem2);
		model.addAttribute("point", diem);

		return "UpdatePoint";
	}

	@RequestMapping("/insertPoint")
	public String insertPoint(@RequestParam("masv") String masv, @RequestParam("mamh") String mamh,
			@RequestParam("diem1") int diem1, @RequestParam("diem2") int diem2, @RequestParam("hocky") int hocky,
			Model model) {
		try {
			Diem diem = new Diem(masv, mamh, hocky, diem1, diem2);
			diemRepository.save(diem);
			model.addAttribute("insertMsg", "Insert Success!");
		}catch(Exception e) {
			model.addAttribute("insertMsg", "Insert Fail! Please try again!");
		}
		
		return "InsertPoint";
	}

	@RequestMapping("/deletePoint")
	public String deletePoint(@RequestParam("masv") String masv, @RequestParam("mamh") String mamh,
			@RequestParam("diem1") int diem1, @RequestParam("diem2") int diem2, @RequestParam("hocky") int hocky
			, Model model) {
		Diem diem = new Diem(masv, mamh, hocky, diem1, diem2);
		diemRepository.delete(diem);
		model.addAttribute("deletedMsg", "Delete success!");
		
		return "redirect:/point";
	}

	@RequestMapping(value = {"/updatePoint"}, method = RequestMethod.POST)
	public String updatePoint(@RequestParam("masv") String masv, @RequestParam("mamh") String mamh,
			@RequestParam("diem1") int diem1, @RequestParam("diem2") int diem2, @RequestParam("hocky") int hocky
			, Model model) {
		DiemRepositoryCustomImpl diemRepositoryCustomImpl = new DiemRepositoryCustomImpl();
		if(diemRepositoryCustomImpl.updateDiem(masv, mamh, hocky, diem1, diem2)) {
			model.addAttribute("updatedMsg", "Update success!");
		}else {
			model.addAttribute("updatedMsg", "Update fail!");
		}
		
		return "redirect:/point";
	}
}
