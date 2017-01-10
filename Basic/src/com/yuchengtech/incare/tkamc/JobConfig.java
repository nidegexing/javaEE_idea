package com.yuchengtech.incare.tkamc;


import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
 

public class JobConfig {

	private Node rootNode;
	private Document doc; 
	static Logger logger = Logger.getLogger(JobConfig.class);
	public JobConfig(InputStream xmlStr) {   
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			factory.setValidating(false);
			doc = factory.newDocumentBuilder().parse(xmlStr);
			NodeList list = doc.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				if (list.item(i) instanceof Element) {
					rootNode = list.item(i);
					break;
				}
			}
		} catch (Exception ex) {
			logger.warn("解析xml失败:"+ex.getMessage());
			ex.printStackTrace();
		}
	}

	public HashMap getJobs() {
		HashMap jobs = new HashMap();
		NodeList NodeList = rootNode.getChildNodes().item(0).getChildNodes();
		int size = NodeList.getLength();
		for (int i = 0; i < size; i++) {
			Node node = NodeList.item(i);
			if (node.getNodeType() != Node.ELEMENT_NODE)
				continue;
			addJobConfig(jobs, node);
		}
		return jobs;
	}

	/**
	 * 解析XML节点
	 */
	public void addJobConfig(HashMap jobs, Node configFieldNode) { 
		JobInfo job=new JobInfo();
		Field[] fields= JobInfo.class.getFields();
		for(int i=0;i<fields.length;i++){
			Node node = configFieldNode.getAttributes().getNamedItem(fields[i].getName());
			String value = getNode(node);
			try {
				fields[i].set(job, value); 
			} catch (IllegalArgumentException e) { 
				e.printStackTrace();
			} catch (IllegalAccessException e) { 
				e.printStackTrace();
			}
		} 

		job.jobFiles=new HashMap();
		NodeList NodeList = configFieldNode.getChildNodes();//.item(1).getChildNodes();
		int size = NodeList.getLength();  
		for (int i = 0; i < size; i++) {
			Node node = NodeList.item(i);
			if (node.getNodeType() != Node.ELEMENT_NODE)
				continue;
			addJobFiles(job, node);
		} 
		jobs.put(job.jobName, job);
	}
	
	public void addJobFiles(JobInfo job,Node configFieldNode){
		JobFile jobFile=new JobFile();
		Field[] fields= JobFile.class.getFields();
		for(int i=0;i<fields.length;i++){
			Node node = configFieldNode.getAttributes().getNamedItem(fields[i].getName());
			String value = getNode(node);
			try {
				fields[i].set(jobFile, value); 
			} catch (IllegalArgumentException e) { 
				e.printStackTrace();
			} catch (IllegalAccessException e) { 
				e.printStackTrace();
			}
		} 
		job.jobFiles.put(jobFile.id, jobFile);
	}
	/**
	 * Method getNode.
	 * 
	 * @param dataFieldNode
	 *            Node
	 * @return String
	 */
	private String getNode(Node dataFieldNode) {
		return dataFieldNode == null ? null : dataFieldNode.getNodeValue();
	} 
}
