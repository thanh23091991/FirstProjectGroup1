package com.studentmanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentmanager.entity.MonHoc;
import com.studentmanager.service.DiemRepository;
import com.studentmanager.service.MonHocRepository;

@Controller
public class SubjectController {
	@Autowired
	MonHocRepository monhocRepository;

	@Autowired
	DiemRepository diemRepository;

	@RequestMapping("/subject-show")
	public String showMonHoc(Model model) {
		model.addAttribute("subjectlist", monhocRepository.findAll());
		return "TableSubjectResult";
	}

	@RequestMapping(value = "/subjectDelete/{id}", method = RequestMethod.GET)
	public String doDeleteMonHoc(@PathVariable String id, Model model) {

		if (diemRepository.findByMaMH(id).size() == 0) {
			monhocRepository.deleteById(id);
			model.addAttribute("subjectlist", monhocRepository.findAll());
			return "redirect:/subject-show";
		} else {
			System.out.println(diemRepository.findByMaMH(id).size());
			model.addAttribute("mess", "Bạn cần xoá thông tin trong bảng Điểm");
			model.addAttribute("subjectlist", monhocRepository.findAll());
			return "TableSubjectResult";
		}
	}

	@RequestMapping(value = "/insSubInfo", method = RequestMethod.GET)
	public String insertMonHocInfo() {
		return "InsertSubject";
	}

	@RequestMapping(value = "insertSubject", method = RequestMethod.POST)
	public String doInsertMonHoc(@ModelAttribute("monhoc") MonHoc MonHoc, Model model) {
		boolean check = false;
		if (MonHoc.getTenMH().isEmpty() || MonHoc.getTenMH() == null) {
			check = true;
			model.addAttribute("insertMsg", "Vui lòng điền đầy đủ thông tin!!!!");
		}
		if (MonHoc.getMaMH().isEmpty() || MonHoc.getMaMH() == null) {
			check = true;
			model.addAttribute("insertMsg", "Vui lòng điền đầy đủ thông tin!!!!");

		}
		if (String.valueOf(MonHoc.getSoTrinh()).isEmpty() || String.valueOf(MonHoc.getSoTrinh()) == null) {
			check = true;
			model.addAttribute("insertMsg", "Vui lòng điền đầy đủ thông tin!!!!");
		}
		if (MonHoc.getSoTrinh() < 0 || MonHoc.getSoTrinh() > 7) {
			check = true;
			model.addAttribute("insertMsg", "Số trình phải lớn hơn 0 và nhỏ hơn 7!!!!");
		}
		if ((MonHoc.getSoTrinh() < 0 || MonHoc.getSoTrinh() > 7)
				&& (MonHoc.getTenMH().isEmpty() || MonHoc.getTenMH() == null)
				&& (MonHoc.getMaMH().isEmpty() || MonHoc.getMaMH() == null)) {
			check = true;
			model.addAttribute("insertMsg", "Số trình phải lớn hơn 0 và nhỏ hơn 7!!!!");
		}
		if (check) {
			return "InsertSubject";
		} else
			monhocRepository.save(MonHoc);
		model.addAttribute("deletedMsg", "Thêm thành công");
		return "redirect:/subject-show";
	}

	@RequestMapping(value = "/updateSubInfo/{id}")
	public String updateMonHocInfo(@PathVariable String id, Model model) {
		Optional<MonHoc> monhoc = monhocRepository.findById(id);
		model.addAttribute("monhoc", monhoc.get());
		return "UpdateSubject";
	}

	@RequestMapping(value = { "/updateSubject" }, method = RequestMethod.POST)
	public String updateMonHoc(@RequestParam("maMH") String maMH, @RequestParam("tenMH") String tenMH,
			@RequestParam("soTrinh") int soTrinh, Model model) {
		try {
			monhocRepository.updateMonHoc(maMH, tenMH, soTrinh);
			return "redirect:/subject-show";
		} catch (Exception e) {
			return "ErrorPage";
		}
	}

}
