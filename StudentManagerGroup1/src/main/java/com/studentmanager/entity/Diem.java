package com.studentmanager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(Diem.class)
@Table(name = "Diem")
public class Diem implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MaSV", columnDefinition = "char(15)", nullable = false)
	private String maSV;
	
	@Id
	@Column(name = "MaMH", columnDefinition = "char(5)", nullable = false)
	private String maMH;
	
	@Column(name = "HocKy", columnDefinition = "int", nullable = false)
	private int hocKy;
	
	@Column(name = "DiemLan1", columnDefinition = "int", nullable = false)
	private int diemLan1;
	
	@Column(name = "DiemLan2", columnDefinition = "int", nullable = false)
	private int diemLan2;

	public Diem() {
		super();
	}

	public Diem(String maSV, String maMH, int hocKy, int diemLan1, int diemLan2) {
		super();
		this.maSV = maSV;
		this.maMH = maMH;
		this.hocKy = hocKy;
		this.diemLan1 = diemLan1;
		this.diemLan2 = diemLan2;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getMaMH() {
		return maMH;
	}

	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}

	public int getHocKy() {
		return hocKy;
	}

	public void setHocKy(int hocKy) {
		this.hocKy = hocKy;
	}

	public int getDiemLan1() {
		return diemLan1;
	}

	public void setDiemLan1(int diemLan1) {
		this.diemLan1 = diemLan1;
	}

	public int getDiemLan2() {
		return diemLan2;
	}

	public void setDiemLan2(int diemLan2) {
		this.diemLan2 = diemLan2;
	}

}
