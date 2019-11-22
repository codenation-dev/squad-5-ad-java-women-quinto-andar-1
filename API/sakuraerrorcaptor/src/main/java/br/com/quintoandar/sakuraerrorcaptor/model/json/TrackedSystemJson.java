package br.com.quintoandar.sakuraerrorcaptor.model.json;

import java.io.Serializable;

public class TrackedSystemJson implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5768505056856530910L;
	private Long id;
	private String name;
	private String location;
	private String token;
	
	public TrackedSystemJson(Long id, String name, String location, String token) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.token = token;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}	
	@Override
	public String toString() {
		String result = "            \"id\": \""+this.id+"\""
				+",\n            \"name\": \""+this.name+"\""
				+",\n            \"location\": \""+this.location+"\""
				+",\n            \"token\": \""+this.token+"\"";
		return result;
	}
}
