package com.studentmanager.service;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.studentmanager.entity.SinhVien;

@Service
@Transactional
public class SinhVienRepositoryCustomImpl implements SinhVienRepositoryCustom {
	@Autowired
	EntityManager entityManager;
	@Autowired
	private SinhVienRepository sinhVienRepository;

	@Override
	public void updateSinhVien(String maSV, String tenSV, boolean gioiTinh, Date ngaySinh, String queQuan,
			String maLop) {

	}

	

}
