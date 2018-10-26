package com.studentmanager.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MonHoc")
public class MonHoc {
	@Id
	@Column(name = "MaMH", columnDefinition = "char(5)", nullable = false)
	private String maMH;
	
	@Column(name = "TenMH", columnDefinition = "nvarchar(30)", nullable = false)
	private String tenMH;
	
	@Column(name = "SoTrinh", columnDefinition = "int", nullable = false)
	private int soTrinh;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="MaMH", referencedColumnName = "MaMH")
	private List<Diem> listDiem;

	public String getMaMH() {
		return maMH;
	}

	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}

	public String getTenMH() {
		return tenMH;
	}

	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}

	public int getSoTrinh() {
		return soTrinh;
	}

	public void setSoTrinh(int soTrinh) {
		this.soTrinh = soTrinh;
	}

	public List<Diem> getListDiem() {
		return listDiem;
	}

	public void setListDiem(List<Diem> listDiem) {
		this.listDiem = listDiem;
	}
	
	
	
	
	
	public MonHoc(String maMH, String tenMH, int soTrinh) {
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.soTrinh = soTrinh;
	}

	@Override
	public String toString() {
		return "MonHoc [MaMH=" + this.maMH + ", TenMH=" + this.tenMH + ", SoTrinh=" + this.soTrinh + "]";
	}
	
}
