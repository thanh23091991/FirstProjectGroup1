package com.studentmanager.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.studentmanager.entity.Diem;

public interface DiemRepository extends JpaRepository<Diem, String> {
	List<Diem> findAll();
	List<Diem> findByMaSV(String maSV);
	List<Diem> findByMaMH(String maMH);
	
	@Transactional
	@Modifying
	@Query("Update Diem d set d.hocKy = :hocky, d.diemLan1 = :diem1, d.diemLan2 = :diem2 where d.maSV = :masv and d.maMH = :mamh")
	public void updateDiem(@Param("masv") String masv, @Param("mamh") String mamh, @Param("hocky") int hocky, 
			@Param("diem1") int diem1, @Param("diem2") int diem2);
}
