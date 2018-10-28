package com.studentmanager.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.studentmanager.entity.Diem;
import com.studentmanager.service.DiemRepository;

@Controller
public class PointController {
	// logger to write log for error
	private static final Logger logger = LoggerFactory.getLogger(PointController.class);
	@Autowired
	private DiemRepository diemRepository;

	@RequestMapping(value = { "/point" }, method = RequestMethod.GET)
	public String viewListPoint(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "0") String page,
			@RequestParam(name = "size", required = false, defaultValue = "3") Integer size) {
		try {
			// Calculate number of pages
			List<Diem> diems = diemRepository.findAll();
			int x = diems.size() / 3;
			int y = diems.size() % 3;
			if (y > 0) {
				x++;
			}
			model.addAttribute("diemsSize", x);

			// Get page
			Sort sortable = Sort.by("maSV").ascending();
			int pagenum = Integer.parseInt(page);
			if (pagenum > 0) {
				pagenum--;
			}
			Pageable pageable = PageRequest.of(pagenum, size, sortable);
			Page<Diem> pages = diemRepository.findDiems(pageable);
			List<Diem> rs = pages.getContent();
			model.addAttribute("pointList", rs);

			return "Point";
		} catch (Exception e) {
			logger.error(e.getMessage());
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
			logger.error(e.getMessage());
			return "ErrorPage";
		}
	}

	@RequestMapping(value = { "/insertPoint" }, method = RequestMethod.POST)
	public String insertPoint(@RequestParam("masv") String masv, @RequestParam("mamh") String mamh,
			@RequestParam("diem1") int diem1, @RequestParam("diem2") int diem2, @RequestParam("hocky") int hocky,
			Model model) {
		try {
			if (diem1 < 0 || diem1 > 10 || diem2 < 0 || diem2 > 10 || hocky < 0) {
				model.addAttribute("insertMsg", "Insert Fail! Please try again!");
				return "InsertPoint";
			} else {
				Diem diem = new Diem(masv, mamh, hocky, diem1, diem2);
				diemRepository.save(diem);
				return "redirect:/point";
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
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
			logger.error(e.getMessage());
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
			logger.error(e.getMessage());
			return "ErrorPage";
		}
	}
}
