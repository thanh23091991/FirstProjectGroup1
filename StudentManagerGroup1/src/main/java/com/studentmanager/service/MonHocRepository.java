package com.studentmanager.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentmanager.entity.Diem;
import com.studentmanager.entity.MonHoc;

@Repository
public interface MonHocRepository extends JpaRepository<MonHoc, String> {

	List<MonHoc> findAll();
	List<MonHoc> findByMaMH(String maMH);
	List<MonHoc> findByTenMH(String tenMH);
	
}
