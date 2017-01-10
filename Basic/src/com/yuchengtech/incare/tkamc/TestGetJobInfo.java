package com.yuchengtech.incare.tkamc;

import java.io.ByteArrayInputStream;
import java.util.HashMap;

/**
 * @ClassName:TestGetJobInfo
 * @Description:TODO(获取作业信息)
 * @Company:yusys.com.cn
 * @author junbao.ma
 * @date 2016年10月20日 下午1:57:10
 * @version V1.0
 */
public class TestGetJobInfo {

	@SuppressWarnings("unchecked")
	public static HashMap<String, JobInfo> getJobInfo(String jobId) throws Exception{
		//定义交易码
		String tranCode = "001";
		
		//定义上送到服务器消息内容
		String sengMsg = tranCode + "jobId=" + jobId;
		//定义返回消息
		String returnMsg = "";
		//定义返回码
		String returnCode = "";
		//
		String jobInfoStr = "";
		//定义返回作业信息
		HashMap<String, JobInfo> jobs = null;
		
		//建立socket连接，将消息传送到Server端
		try {
			TestSocket ts = new TestSocket();
			//接收Server返回消息
			returnMsg = ts.sendMsgToSvrver(sengMsg);
			System.out.println("返回作业报文信息：" + returnMsg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			returnMsg="00099";
			System.out.println("服务未启动或网络连接失败");
			e.printStackTrace();
		}
		
		//处理Server端返回码
		returnCode = returnMsg.substring(3, 5);
		if(!"00".equals(returnCode)){
			System.out.println("返回码=" + returnCode);
		}
		
		//获取作业信息
		try {
			jobInfoStr = returnMsg.substring(5);
			ByteArrayInputStream is=new ByteArrayInputStream(jobInfoStr.getBytes());
			JobConfig jobConfig=new JobConfig(is);
			jobs=jobConfig.getJobs(); 
			System.out.println("jobs:"+jobs.get(jobId).jobName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jobs;
	}
	
	/**
	* @Title: main 
	* @author: junbao.ma
	* @Description: TODO(测试获取作业信息方法) 
	* @param @param args    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//定义作业ID
		String jobId = "DS";
		TestGetJobInfo tgji = new TestGetJobInfo();
		try {
			tgji.getJobInfo(jobId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
