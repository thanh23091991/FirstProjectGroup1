package com.studentmanager.service;

import java.sql.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.studentmanager.entity.SinhVien;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, String> {

	@Query("SELECT e FROM SinhVien e")
	Page<SinhVien> findSinhViens(Pageable pageable);

	@Transactional
	@Modifying
	@Query("UPDATE SinhVien c SET c.tenSV = :tenSV,c.gioiTinh = :gioiTinh,c.ngaySinh = :ngaySinh,c.maLop = :maLop,c.queQuan = :queQuan  WHERE c.maSV = :maSV")
	void updateSinhVien(@Param("maSV") String maSV, @Param("tenSV") String tenSV, @Param("gioiTinh") boolean gioiTinh,
			@Param("ngaySinh") Date ngaySinh, @Param("queQuan") String queQuan, @Param("maLop") String maLop);

}
