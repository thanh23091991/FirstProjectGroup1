package com.studentmanager.controller;

import java.util.List;
import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.studentmanager.entity.MonHoc;
import com.studentmanager.service.DiemRepository;
import com.studentmanager.service.MonHocRepository;

@Controller
public class SubjectController {
	
	private static final Logger logger = LoggerFactory.getLogger(SubjectController.class);
	@Autowired
	MonHocRepository monhocRepository;

	@Autowired
	DiemRepository diemRepository;

	/**
	 * @param model
	 * @des Performs a return of the course list from the database 
	 * returned view TableSubjectResult
	 * @return
	 */
	@RequestMapping(value = { "/subject-show" }, method = RequestMethod.GET)
	public String viewListPoint(Model model,
				@RequestParam(name = "page", required = false, defaultValue = "0") String page,
				@RequestParam(name = "size", required = false, defaultValue = "3") Integer size) {
			try {
				// Calculate number of pages
				List<MonHoc> monhocList = monhocRepository.findAll();
				int x = monhocList.size() / 3;
				int y = monhocList.size() % 3;
				if (y > 0) {
					x++;
				}
				model.addAttribute("monhocListSize", x);

				// Get page
				Sort sortable = Sort.by("maMH").ascending();
				int pagenum = Integer.parseInt(page);
				if (pagenum > 0) {
					pagenum--;
				}
				Pageable pageable = PageRequest.of(pagenum, size, sortable);
				Page<MonHoc> pages = monhocRepository.findMonHocs(pageable);
				List<MonHoc> rs = pages.getContent();
				model.addAttribute("subjectlist", rs);
				return "TableSubjectResult";
			} catch (Exception e) {
				logger.error(e.getMessage());
				return "ErrorPage";
			}
	}

	/**
	 * @param id
	 * @param model
	 * @des Get requests from view with corresponding id to delete.
	 * Progress check in the table Point if id exists then do not delete.
	 * If there is no id to delete in the table Point then delete
	 * @return
	 */
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

	/**
	 * @des Displays a view to enter the data to be added
	 * @return
	 */
	@RequestMapping(value = "/insSubInfo", method = RequestMethod.GET)
	public String insertMonHocInfo() {
		return "InsertSubject";
	}

	/**
	 * @param MonHoc
	 * @param model
	 * @des Receive information from view and save subject to database 
	 * then display the list of all subjects
	 * @return
	 */
	@RequestMapping(value = "insertSubject", method = RequestMethod.POST)
	public String doInsertMonHoc(@ModelAttribute("monhoc") MonHoc MonHoc, Model model) {
		monhocRepository.save(MonHoc);
		model.addAttribute("mess", "Thêm thành công");
		return "redirect:/subject-show";
	}

	/**
	 * @param id
	 * @param model
	 * @des Obtaining a request from a view with the corresponding id needs to change the information 
	 * then passing the information to the view update with the corresponding properties
	 * @return
	 */
	@RequestMapping(value = "/updateSubInfo/{id}")
	public String updateMonHocInfo(@PathVariable String id, Model model) {
		Optional<MonHoc> monhoc = monhocRepository.findById(id);
		model.addAttribute("monhoc", monhoc.get());
		return "UpdateSubject";
	}

	/**
	 * @param maMH
	 * @param tenMH
	 * @param soTrinh
	 * @param model
	 * @return
	 */
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
