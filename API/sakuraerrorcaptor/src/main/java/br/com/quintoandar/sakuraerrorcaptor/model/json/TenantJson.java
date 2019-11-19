package br.com.quintoandar.sakuraerrorcaptor.model.json;

import java.io.Serializable;

public class TenantJson implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5240078179270655002L;

	private Long id;
	private String name;
	
	public TenantJson(Long id, String name) {
		this.id=id;
		this.name=name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
		String result = "            \"id\": \""+this.id+"\""
				+",\n            \"name\": \""+this.name+"\"";
		return result;
	}
	
}
