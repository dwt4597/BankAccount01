package com.biz.bank.VO;

public class bankVO {
	private String strnum;
	private int intdon;
	private String day;
	public String getStrnum() {
		return strnum;
	}
	public void setStrnum(String strnum) {
		this.strnum = strnum;
	}
	public int getIntdon() {
		return intdon;
	}
	public void setIntdon(int intdon) {
		this.intdon = intdon;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	@Override
	public String toString() {
		return "bankVO [strnum=" + strnum + ", intdon=" + intdon + ", day=" + day + "]";
	}
	
	
}
