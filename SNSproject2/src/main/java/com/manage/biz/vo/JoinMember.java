package com.manage.biz.vo;

public class JoinMember {
	int member_no;
	String member_id;
	String member_password;
	String member_name;
	String member_birth;
	String member_sex;
	String password_q;//비밀번호 질문
	String password_a;//비밀번호 답
	
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_password() {
		return member_password;
	}
	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_birth() {
		return member_birth;
	}
	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}
	public String getMember_sex() {
		return member_sex;
	}
	public void setMember_sex(String member_sex) {
		this.member_sex = member_sex;
	}
	public String getPassword_q() {
		return password_q;
	}
	public void setPassword_q(String password_q) {
		this.password_q = password_q;
	}
	public String getPassword_a() {
		return password_a;
	}
	public void setPassword_a(String password_a) {
		this.password_a = password_a;
	}
	
}
