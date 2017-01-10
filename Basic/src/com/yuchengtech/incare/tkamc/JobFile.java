package com.yuchengtech.incare.tkamc;

/**
 * @ClassName:JobFile
 * @Description:TODO(JobFile实体类)
 * @Company:yusys.com.cn
 * @author junbao.ma
 * @date 2016年11月8日 下午4:25:05
 * @version V1.0
 */
public class JobFile {
	/**
	 * id
	 */
	public String id;
	/**
	 * 文件名格式
	 */
	public String name; 
	/**
	 * 当前处理的文件
	 */
	public String currFile;
	/** 
	 * 该文件是否必须
	 */
	public String isNeed;
	/** 
	 * 最后修改时间
	 */
	public String lastModify;
	 
	/**
	 * 控制文件名称
	 */
	public String state; 
	/** 
	 * copy等待时间
	 */
	public String waitTime;
	/** 
	 * 显示名称
	 */
	public String display;
	/** 
	 * 文件大小
	 */
	public String size;
	/** 
	 * 文件处理器类型
	 */
	public String type;
	/** 
	 * ctl文件名称
	 */
	public String ctlFile;
	/** 
	 * 数据对应的table
	 */
	public String tableName;
	/**
	 * 数据文件中的数据量
	 */
	public String srcNum;
	/**
	 * 导入到ODS的数据量
	 */
	public String dbNum;
	
	/**
	 * 数据名称
	 */
	public String srcTable;
	/**
	 * 数据数量
	 */
	public String srcField;
	/**
	 * 表名称
	 */
	public String objTable;
	/**
	 * Fabric数量
	 */
	public String objField;
	/**
	 * 是否分片
	 */
	public String scope;
	
}
