package com.hp.cc.model;
/**
 * @author ck
 * @date 2019年2月27日 下午4:04:16
 */

public class SysRole {

	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "SysRole [id=" + id + ", name=" + name + "]";
	}
	public SysRole(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public SysRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
