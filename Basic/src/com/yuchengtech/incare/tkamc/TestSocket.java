package com.yuchengtech.incare.tkamc;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;

import com.yuchengtech.incare.tkamc.JobConfig;

/**
 * @ClassName:TestSocket
 * @Description:TODO(测试socket连接)
 * @Company:yusys.com.cn
 * @author junbao.ma
 * @date 2016年10月19日 上午9:40:44
 * @version V1.0
 */
public class TestSocket {
	
	//目标主机地址
	public static final String host = "127.0.0.1";
	
	//目标主机端口
	public static final String port = "9999";
	
	private Socket clientSocket;
	
	/**
	* @Title: TestSocketClient 
	* @Description: TODO(建立Socket连接) 
	* @param @throws IOException    设定文件 
	* @throws
	 */
	public TestSocket() throws IOException {
		clientSocket = new Socket(host, Integer.parseInt(port));
		clientSocket.setSoTimeout(30000000);
	}
	
	/**
	* @Title: sendMsgToSvrver 
	* @author: junbao.ma
	* @Description: TODO(获取作业信息) 
	* @param @param msg
	* @param @return
	* @param @throws IOException    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String sendMsgToSvrver(String msg) throws IOException{
		//服务器返回消息
		String responseMsg = "";
		
		try {
			//输出流
			DataOutputStream outputStream = new DataOutputStream(clientSocket
					.getOutputStream());
			
			//输入流
			BufferedInputStream rd = new BufferedInputStream(clientSocket  
			        .getInputStream());
			
			//在消息前加6个字节的消息长度
			String length=Integer.toString(msg.getBytes("GBK").length); 
			while(length.length()<6){
				length="0"+length;
			}
			msg=length+msg; 
			
			//往服务器发送消息
			outputStream.write(msg.getBytes("GBK"), 0,msg.getBytes("GBK").length);
			outputStream.flush();
			
			System.out.println("WEB:Web send to App data:" + msg); 
			
			//接收服务器消息
			byte[] blen=new byte[6];
			int readCount = rd.read(blen, 0, 6);
			System.out.println("readCount="+readCount);
			int len=Integer.parseInt(new String(blen)); 
			byte[] bmsg=new byte[len];
			//int readmsg = rd.read(bmsg, 0, len);  
			
			int   pos=0;
			int   rcvLen=0;   
		    while((rcvLen=rd.read(bmsg,pos,len-pos))>0)   
		    {   
		        pos+=rcvLen;   
		    }  
			
			responseMsg=new String(bmsg);
			
			if(responseMsg==null||responseMsg.equals("")){
				responseMsg="00099";
			}
			
			System.out.println("WEB:msg from app:" + msg); 
			// 关闭连接
			outputStream.close();
			rd.close();
			clientSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return responseMsg;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//交易码
		String TranCode="001";
		//作业ID
		String jobId="TA";  
		//发送消息内容
		String sendMsg=TranCode+"jobId="+jobId; 
		//返回消息
		String responseMsg = "";
		
		HashMap jobs=null;
		try {
			TestSocket ts = new TestSocket();
			//服务器返回消息
			responseMsg = ts.sendMsgToSvrver(sendMsg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			responseMsg="00099";
			System.out.println("服务未启动或网络连接失败");
			e.printStackTrace();
		}
		
		
		//处理返回码
		String returnCode=responseMsg.substring(3,5);
		if(!"00".equals(returnCode)){
			//throw new Exception(returnCode,"getJobInfo()",(String)sendRequestToApp.serverConfigTable.get(returnCode));
		} 
		try{
		String jobInfosStr=responseMsg.substring(5);
		
		ByteArrayInputStream is=new ByteArrayInputStream(jobInfosStr.getBytes());
		
		
		JobConfig jobConfig=new JobConfig(is);
		 
		jobs = jobConfig.getJobs(); 
		
		System.out.println("jobs:"+jobs);
		
		//setFieldValue("jobs", jobs); 
		} catch(Exception e){
			e.printStackTrace();
		} 
		
		
		System.out.println("服务器返回结果="+responseMsg );

	}

}
