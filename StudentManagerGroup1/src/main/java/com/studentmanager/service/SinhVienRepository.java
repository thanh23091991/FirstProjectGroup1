package com.studentmanager.service;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.studentmanager.entity.SinhVien;


@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, String> {
	
}
	

