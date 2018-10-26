package com.studentmanager.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SinhVien")
public class SinhVien {
	@Id
	@Column(name="MaSV", columnDefinition="char(15)", nullable=false)
	private String maSV;
	
	@Column(name = "TenSV",columnDefinition="nvarchar(30)", nullable = false)
	private String tenSV;
	
	@Column(name = "GioiTinh",columnDefinition="bit", nullable = false)
	private boolean gioiTinh;
	
	@Column(name = "NgaySinh", nullable = false)
	private Date ngaySinh;
	
	@Column(name="MaLop", columnDefinition="char(5)", nullable=false)
	private String maLop;
	
	@Column(name="QueQuan", columnDefinition="nvarchar(100)", nullable=false)
	private String queQuan;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="MaSV", referencedColumnName="MaSV")
	private List<Diem> listDiemSV;
	
	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getTenSV() {
		return tenSV;
	}
	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	public String getQueQuan() {
		return queQuan;
	}
	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}
	public List<Diem> getListDiemSV() {
		return listDiemSV;
	}
	public void setListDiemSV(List<Diem> listDiemSV) {
		this.listDiemSV = listDiemSV;
	}
}
