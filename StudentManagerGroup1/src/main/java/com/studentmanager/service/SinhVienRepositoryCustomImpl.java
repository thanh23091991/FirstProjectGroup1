package com.studentmanager.service;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

public class SinhVienRepositoryCustomImpl implements SinhVienRepositoryCustom {
	@Autowired
	EntityManager entityManager;

	@Override
	public void updateSinhVien(String maSV, String tenSV, boolean gioiTinh, Date ngaySinh, String queQuan,
			String maLop) {
		
	}

}
