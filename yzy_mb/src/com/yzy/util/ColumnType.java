package com.yzy.util;
/**
 * @author yangzhenyu
 * */
public class ColumnType {

	private String name;
	private String tfName;
	
	
	public ColumnType(String name, String tfName) {
		super();
		this.name = name;
		this.tfName = tfName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTfName() {
		return tfName;
	}
	public void setTfName(String tfName) {
		this.tfName = tfName;
	}
	
	
}
