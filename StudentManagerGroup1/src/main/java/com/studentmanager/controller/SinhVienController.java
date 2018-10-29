package com.studentmanager.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.studentmanager.entity.SinhVien;
import com.studentmanager.service.DiemRepository;
import com.studentmanager.service.SinhVienRepository;

@Controller
public class SinhVienController {
	private static final Logger logger = LoggerFactory.getLogger(SinhVienController.class);
	@Autowired
	private SinhVienRepository sinhVienRepository;
	@Autowired
	DiemRepository diemRepository;
	//get list SV	
	@RequestMapping(value = { "/sinhVienList" }, method = RequestMethod.GET)
	public String viewListPoint(Model model,
			@RequestParam(name = "page", required = false, defaultValue = "0") String page,
			@RequestParam(name = "size", required = false, defaultValue = "3") Integer size) {
		try {
			// Calculate number of pages
			List<SinhVien> sinhVienList = sinhVienRepository.findAll();
			int x = sinhVienList.size() / 3;
			int y = sinhVienList.size() % 3;
			if (y > 0) {
				x++;
			}
			model.addAttribute("sinhVienListSize", x);

			// Get page
			Sort sortable = Sort.by("maSV").ascending();
			int pagenum = Integer.parseInt(page);
			if (pagenum > 0) {
				pagenum--;
			}
			Pageable pageable = PageRequest.of(pagenum, size, sortable);
			Page<SinhVien> pages = sinhVienRepository.findSinhViens(pageable);
			List<SinhVien> rs = pages.getContent();
			model.addAttribute("listSinhVien", rs);
			return "TableStudentResult";
		} catch (Exception e) {
			logger.error(e.getMessage());
			return "ErrorPage";
		}
	}
	
	//get sinhVien having param maSV
	@RequestMapping("/sinhVienUpdate/{maSV}")
	public String updateSinhVien(@PathVariable String maSV, Model model) {
		Optional<SinhVien> sinhVien = sinhVienRepository.findById(maSV);
		if (sinhVien.isPresent()) {
			model.addAttribute("selectedGender", sinhVien.get().isGioiTinh());
			model.addAttribute("sinhVien", sinhVien.get());
			System.out.println(sinhVien.get());
		}
		return "SinhVienUpdate";
	}
	//insert new SV
	@RequestMapping("/sinhVienInsert")
	public String doSaveSinhVien(@ModelAttribute("SinhVien") SinhVien sinhVien, Model model) {
		sinhVienRepository.save(sinhVien);
		model.addAttribute("listSinhVien", sinhVienRepository.findAll());
		return "redirect:/sinhVienList";
	}

	@RequestMapping("/insertInfoSinhVien")
	public String redirectSinhVien() {
		return "SinhVienInsert";
	}

	@RequestMapping("/sinhVienUpdate")
	public String doUpdateSinhVien(@ModelAttribute("sinhVien") SinhVien sinhVien, Model model) {
		sinhVienRepository.updateSinhVien(sinhVien.getMaSV(), sinhVien.getTenSV(), sinhVien.isGioiTinh(),
				sinhVien.getNgaySinh(), sinhVien.getQueQuan(), sinhVien.getMaLop());
		model.addAttribute("listSinhVien", sinhVienRepository.findAll());
		return "redirect:/sinhVienList";
	}
	//delete SV having maSV
	@RequestMapping("/sinhVienDelete/{maSV}")
	public String doDeleteSinhVien(@PathVariable String maSV, Model model) {
		//check constraint in Diem table
		if (diemRepository.findByMaSV(maSV).size() == 0) {
			sinhVienRepository.deleteById(maSV);
			model.addAttribute("listSinhVien", sinhVienRepository.findAll());
			return "redirect:/sinhVienList";
		} else {
			//show delete error
			model.addAttribute("deletedMsg", "Bạn cần xoá thông tin trong bảng Điểm của sinh viên có mã SV = " + maSV +" trước!!!");
			model.addAttribute("listSinhVien", sinhVienRepository.findAll());
			return "TableStudentResult";
		}
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchLop(@RequestParam String keyword, Model model, HttpServletRequest request) {
	System.out.println("Key word = " + keyword);
	SinhVienController controller = new SinhVienController();
	List<SinhVien> list = controller.search(keyword);
	System.out.println("Result size = "+ list.size());
	PagedListHolder<?> pages = new PagedListHolder<>(list);
	request.getSession().setAttribute("listSinhVien", pages);
	return "redirect:/sinhVienList";
	}
	
	public  List<SinhVien> search(String keyword) {

		List<SinhVien> result = new ArrayList<>();
		List<SinhVien> sinhVienList = sinhVienRepository.findAll();
		if (keyword == null && "".equals(keyword)) { // if empty keyword return all SinhVien
			result = sinhVienList;
		} else {
			for (SinhVien sinhVien : sinhVienList) {
				if (sinhVien.getMaLop().toLowerCase().contains(keyword.toLowerCase()) // contains full field on object
																						// Lop
						|| sinhVien.getMaSV().toLowerCase().contains(keyword.toLowerCase())
						|| (sinhVien.getNgaySinh().toString()).toLowerCase().contains(keyword.toLowerCase())
						|| sinhVien.getQueQuan().toLowerCase().contains(keyword.toLowerCase())
						|| sinhVien.getTenSV().toLowerCase().contains(keyword.toLowerCase())) {
					result.add(sinhVien);
				}
			}
		}
		return result;
	}
}
