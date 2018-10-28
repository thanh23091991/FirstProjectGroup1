package com.studentmanager.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.studentmanager.entity.SinhVien;
import com.studentmanager.service.DiemRepository;
import com.studentmanager.service.SinhVienRepository;

@Controller
public class SinhVienController {

	// Mapping table SinhVien
	@Autowired
	private SinhVienRepository sinhVienRepository;
	@Autowired
	DiemRepository diemRepository;

	@RequestMapping("/sinhVienList")
	public String listCustomer(Model model) {
		model.addAttribute("listSinhVien", sinhVienRepository.findAll());
		return "TableStudentResult";
	}

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

	@RequestMapping("/sinhVienDelete/{maSV}")
	public String doDeleteSinhVien(@PathVariable String maSV, Model model) {
		if (diemRepository.findByMaSV(maSV).size() == 0) {
			sinhVienRepository.deleteById(maSV);
			model.addAttribute("listSinhVien", sinhVienRepository.findAll());
			return "redirect:/sinhVienList";
		} else {
			model.addAttribute("deletedMsg", "Bạn cần xoá thông tin trong bảng Điểm của sinh viên có mã SV = " + maSV +" trước!!!");
			model.addAttribute("listSinhVien", sinhVienRepository.findAll());
			return "TableStudentResult";
		}
	}

}
