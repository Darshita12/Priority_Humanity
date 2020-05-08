package com.Admin.bean;

public class AdminBean {

	private static int id;
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		AdminBean.id = id;
	}
	private static String email;
	private static String password;
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		AdminBean.email = email;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		AdminBean.password = password;
	}
}
