package br.com.quintoandar.sakuraerrorcaptor.dto;

import br.com.quintoandar.sakuraerrorcaptor.model.Tenant;

public class TrackedSystemDTO {

	private String name;
	private String location;
	public Tenant tenant;
	
	public TrackedSystemDTO() {
		
	}
	
	public TrackedSystemDTO(String name, String location, Tenant tenant) {
		super();
		this.name = name;
		this.location = location;
		this.tenant = tenant;
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
	public Tenant getTenant() {
		return tenant;
	}
	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
}
