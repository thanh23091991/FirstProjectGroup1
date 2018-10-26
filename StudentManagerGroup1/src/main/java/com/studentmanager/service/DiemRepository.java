package com.studentmanager.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentmanager.entity.Diem;

public interface DiemRepository extends JpaRepository<Diem, String> {
	List<Diem> findAll();
	List<Diem> findByMaSV(String maSV);
	List<Diem> findByMaMH(String maMH);
}
