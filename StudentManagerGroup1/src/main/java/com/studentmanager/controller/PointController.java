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

@Controller
public class PointController {
	@Autowired
	private DiemRepository diemRepository;

	@RequestMapping(value = { "/point" }, method = RequestMethod.GET)
	public String viewListPoint(Model model) {
		try {
			List<Diem> diems = diemRepository.findAll();
			model.addAttribute("pointList", diems);

			return "Point";
		} catch (Exception e) {
			// TODO: handle exception
			return "ErrorPage";
		}
	}

	@RequestMapping(value = { "/insPoint" }, method = RequestMethod.GET)
	public String goToInsertPoint() {

		return "InsertPoint";
	}

	@RequestMapping(value = { "/udpPoint" }, method = RequestMethod.GET)
	public String goToUpdatePoint(@RequestParam("masv") String masv, @RequestParam("mamh") String mamh,
			@RequestParam("diem1") int diem1, @RequestParam("diem2") int diem2, @RequestParam("hocky") int hocky,
			Model model) {

		try {
			Diem diem = new Diem(masv, mamh, hocky, diem1, diem2);
			model.addAttribute("point", diem);

			return "UpdatePoint";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "ErrorPage";
		}
	}

	@RequestMapping(value = { "/insertPoint" }, method = RequestMethod.POST)
	public String insertPoint(@RequestParam("masv") String masv, @RequestParam("mamh") String mamh,
			@RequestParam("diem1") int diem1, @RequestParam("diem2") int diem2, @RequestParam("hocky") int hocky,
			Model model) {
		try {
			Diem diem = new Diem(masv, mamh, hocky, diem1, diem2);
			diemRepository.save(diem);
			model.addAttribute("insertedMsg", "Insert Success!");
			return "redirect:/point";
		} catch (Exception e) {
			model.addAttribute("insertedMsg", "Insert Fail! Please try again!");
			return "ErrorPage";
		}

		
	}

	@RequestMapping(value = { "/deletePoint" }, method = RequestMethod.GET)
	public String deletePoint(@RequestParam("masv") String masv, @RequestParam("mamh") String mamh,
			@RequestParam("diem1") int diem1, @RequestParam("diem2") int diem2, @RequestParam("hocky") int hocky,
			Model model) {
		try {
			Diem diem = new Diem(masv, mamh, hocky, diem1, diem2);
			diemRepository.delete(diem);
			model.addAttribute("deletedMsg", "Delete success!");

			return "redirect:/point";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "ErrorPage";
		}
	}

	@RequestMapping(value = { "/updatePoint" }, method = RequestMethod.POST)
	public String updatePoint(@RequestParam("masv") String masv, @RequestParam("mamh") String mamh,
			@RequestParam("diem1") int diem1, @RequestParam("diem2") int diem2, @RequestParam("hocky") int hocky,
			Model model) {
		try {
			diemRepository.updateDiem(masv, mamh, hocky, diem1, diem2);

			return "redirect:/point";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "ErrorPage";
		}
	}
}
