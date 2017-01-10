package com.yuchengtech.incare.tkamc;

import java.util.HashMap;

public class TestStartJobAction {
	public static void main(String[] args) {
		System.out.println("调用成功！");
		//定义交易码004：启动作业
		String TranCode="004"; 
		//获取作业ID
		String type = "GP3";
		//获取作业启动日期
		String date="20161120";  
		System.out.println("页面要启动的作业ID：" + type + "启动日期=" + date);
		//上送服务器消息内容
		String sendMsg=TranCode+"type="+type+"|date="+date;
		System.out.println("上送消息内容：" + sendMsg);
		//定义服务器返回消息
		String repMsg="";
		
		//向服务器发送启动命令
		try {
			TestSocket sendServer=new TestSocket();
			repMsg=sendServer.sendMsgToSvrver(sendMsg);
			System.out.println(repMsg);
		} catch (Exception e) {
			repMsg="00099";
		}  
		//处理返回码
		String returnCode=repMsg.substring(3,5);
		 String rmsg ="";
		// 返回码为"00",作业启动成功，否则失败,成功后取作业信息
		if(!"00".equals(returnCode)){
			rmsg = "作业"+type+"启动失败！";
			System.out.println("作业"+type+"启动失败！");
		} else{
			System.out.println("作业信息说明："+"【作业名称="+type+"】【执行日期="+date+"】");
		} 
	}
 }
