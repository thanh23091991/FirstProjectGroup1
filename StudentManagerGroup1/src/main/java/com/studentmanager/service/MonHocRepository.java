
package com.studentmanager.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.studentmanager.entity.MonHoc;

@Repository
public interface MonHocRepository extends JpaRepository<MonHoc, String> {

	List<MonHoc> findAll();

	List<MonHoc> findByMaMH(Pageable pageable);

	@Query("SELECT e FROM MonHoc e")
	Page<MonHoc> findMonHocs(Pageable pageable);
	
	@Transactional
	@Modifying
	@Query("Update MonHoc d set d.tenMH = :tenMH, d.soTrinh = :soTrinh where d.maMH = :maMH")
	public void updateMonHoc(@Param("maMH") String maMH, @Param("tenMH") String tenMH, @Param("soTrinh") int soTrinh);

}
