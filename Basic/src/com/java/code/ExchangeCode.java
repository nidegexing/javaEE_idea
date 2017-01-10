package com.java.code;


public class ExchangeCode {
	public static void main(String[] args) throws Exception {
		String str = "�Ҳ���ָ���ĳ���";
		System.out.println(new String(str.getBytes("utf-8"),"utf-8"));
	}
}
