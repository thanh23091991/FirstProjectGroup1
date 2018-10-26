package com.studentmanager.service;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.studentmanager.entity.Diem;

public class DiemRepositoryCustomImpl implements DiemRepositoryCustom {
	
	@Autowired
    EntityManager entityManager;

	@Override
	public Diem getMaxDiem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateDiem(String maSV, String maMH, int hocKy, int diemLan1, int diemLan2) {
		try {
            String sql = "update diem set hoc_ky = " + Integer.toString(hocKy) + 
            " diem_lan1 = " + Integer.toString(diemLan1) + " diem_lan2 = " + Integer.toString(diemLan2)
            + " where masv = " + maSV + " and mamh = " + maMH;
            
            Query query = entityManager.createQuery(sql);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
        	return false;
        }
	}
}
