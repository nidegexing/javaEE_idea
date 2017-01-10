package com.yuchengtech.incare.tkamc;

import java.util.HashMap;

/**
 * @ClassName:JobInfo
 * @Description:TODO(作业信息实体类)
 * @Company:yusys.com.cn
 * @author junbao.ma
 * @date 2016年10月26日 上午10:08:51
 * @version V1.0
 */
public class JobInfo {
	
	/**
	 * 作业名称
	 */
	public String jobName; 
	/** 
	 * 连接的数据库
	 */
	public String dbUser;  
	/**
	 * 作业调度时间表达式
	 */
	public String jobCronExpression; 
	/**
	 * 目标文件路径
	 */
	public String objFileDir;  
	/**
	 * 源文件路径
	 */
	public String srcFileDir;
	/**
	 * ctl的存放目录
	 */
	public String ctlDir;
	/**
	 *  log 的存放目录
	 */
	public String logDir;
	/**
	 *  badfile的存放目录
	 */
	public String badDir;
	/**
	 * 作业当前状态
	 */
	public String batchStep; 
	/**
	 * 	定义前置作业任务，如果parents=root，则没有前置作业；否则必须在前置作业完成后该作业才能执行
	 */
	public String parents;
	
	/**
	 * 调度日期
	 */
	public String date;
	
	/**
	 * 要处理的文件
	 */
	public HashMap jobFiles; 
	/**
	 * 作业类型
	 */
	public String type;
	/**
	 * 上次处理时间
	 */
	public String lastDealTime;
	/**
	 * 处理第一层数据，该job执行完即立刻执行
	 */
	public String DO1;
	/**  
	 * 获取作业名称  
	 * @return jobName 作业名称  
	 */
	public String getJobName() {
		return jobName;
	}
	/**  
	 * 设置作业名称  
	 * @param jobName 作业名称  
	 */
	
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	/**  
	 * 获取连接的数据库  
	 * @return dbUser 连接的数据库  
	 */
	public String getDbUser() {
		return dbUser;
	}
	/**  
	 * 设置连接的数据库  
	 * @param dbUser 连接的数据库  
	 */
	
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
	/**  
	 * 获取作业调度时间表达式  
	 * @return jobCronExpression 作业调度时间表达式  
	 */
	public String getJobCronExpression() {
		return jobCronExpression;
	}
	/**  
	 * 设置作业调度时间表达式  
	 * @param jobCronExpression 作业调度时间表达式  
	 */
	
	public void setJobCronExpression(String jobCronExpression) {
		this.jobCronExpression = jobCronExpression;
	}
	/**  
	 * 获取目标文件路径  
	 * @return objFileDir 目标文件路径  
	 */
	public String getObjFileDir() {
		return objFileDir;
	}
	/**  
	 * 设置目标文件路径  
	 * @param objFileDir 目标文件路径  
	 */
	
	public void setObjFileDir(String objFileDir) {
		this.objFileDir = objFileDir;
	}
	/**  
	 * 获取源文件路径  
	 * @return srcFileDir 源文件路径  
	 */
	public String getSrcFileDir() {
		return srcFileDir;
	}
	/**  
	 * 设置源文件路径  
	 * @param srcFileDir 源文件路径  
	 */
	
	public void setSrcFileDir(String srcFileDir) {
		this.srcFileDir = srcFileDir;
	}
	/**  
	 * 获取ctl的存放目录  
	 * @return ctlDir ctl的存放目录  
	 */
	public String getCtlDir() {
		return ctlDir;
	}
	/**  
	 * 设置ctl的存放目录  
	 * @param ctlDir ctl的存放目录  
	 */
	
	public void setCtlDir(String ctlDir) {
		this.ctlDir = ctlDir;
	}
	/**  
	 * 获取log的存放目录  
	 * @return logDir log的存放目录  
	 */
	public String getLogDir() {
		return logDir;
	}
	/**  
	 * 设置log的存放目录  
	 * @param logDir log的存放目录  
	 */
	
	public void setLogDir(String logDir) {
		this.logDir = logDir;
	}
	/**  
	 * 获取badfile的存放目录  
	 * @return badDir badfile的存放目录  
	 */
	public String getBadDir() {
		return badDir;
	}
	/**  
	 * 设置badfile的存放目录  
	 * @param badDir badfile的存放目录  
	 */
	
	public void setBadDir(String badDir) {
		this.badDir = badDir;
	}
	/**  
	 * 获取作业当前状态  
	 * @return batchStep 作业当前状态  
	 */
	public String getBatchStep() {
		return batchStep;
	}
	/**  
	 * 设置作业当前状态  
	 * @param batchStep 作业当前状态  
	 */
	
	public void setBatchStep(String batchStep) {
		this.batchStep = batchStep;
	}
	/**  
	 * 获取定义前置作业任务，如果parents=root，则没有前置作业；否则必须在前置作业完成后该作业才能执行  
	 * @return parents 定义前置作业任务，如果parents=root，则没有前置作业；否则必须在前置作业完成后该作业才能执行  
	 */
	public String getParents() {
		return parents;
	}
	/**  
	 * 设置定义前置作业任务，如果parents=root，则没有前置作业；否则必须在前置作业完成后该作业才能执行  
	 * @param parents 定义前置作业任务，如果parents=root，则没有前置作业；否则必须在前置作业完成后该作业才能执行  
	 */
	
	public void setParents(String parents) {
		this.parents = parents;
	}
	/**  
	 * 获取调度日期  
	 * @return date 调度日期  
	 */
	public String getDate() {
		return date;
	}
	/**  
	 * 设置调度日期  
	 * @param date 调度日期  
	 */
	
	public void setDate(String date) {
		this.date = date;
	}
	/**  
	 * 获取要处理的文件  
	 * @return jobFiles 要处理的文件  
	 */
	public HashMap getJobFiles() {
		return jobFiles;
	}
	/**  
	 * 设置要处理的文件  
	 * @param jobFiles 要处理的文件  
	 */
	
	public void setJobFiles(HashMap jobFiles) {
		this.jobFiles = jobFiles;
	}
	/**  
	 * 获取作业类型  
	 * @return type 作业类型  
	 */
	public String getType() {
		return type;
	}
	/**  
	 * 设置作业类型  
	 * @param type 作业类型  
	 */
	
	public void setType(String type) {
		this.type = type;
	}
	/**  
	 * 获取上次处理时间  
	 * @return lastDealTime 上次处理时间  
	 */
	public String getLastDealTime() {
		return lastDealTime;
	}
	/**  
	 * 设置上次处理时间  
	 * @param lastDealTime 上次处理时间  
	 */
	
	public void setLastDealTime(String lastDealTime) {
		this.lastDealTime = lastDealTime;
	}
	/**  
	 * 获取dO1  
	 * @return dO1 dO1  
	 */
	public String getDO1() {
		return DO1;
	}
	/**  
	 * 设置dO1  
	 * @param dO1 dO1  
	 */
	
	public void setDO1(String dO1) {
		DO1 = dO1;
	}
	
}