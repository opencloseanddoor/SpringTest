package com.asm.spring.test.mvc2.domain;

public class Realtor
{
	private int id; //트랜잭션을 사용을 할 때 왜? id를 사용을 해야하는지 이해한 다음 그 내용을 이 곳에 적자~
	private String office;
	private String phoneNumber;
	private String address;
	private String grade;
	
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}	
}
