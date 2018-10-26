package com.studentmanager.service;

import com.studentmanager.entity.Diem;

public interface DiemRepositoryCustom {
	public Diem getMaxDiem();
	
	public boolean updateDiem(String maSV, String maMH, int hocKy, int diemLan1, int diemLan2);
}
