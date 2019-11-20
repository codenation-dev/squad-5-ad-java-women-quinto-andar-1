package br.com.quintoandar.sakuraerrorcaptor.dto;

import java.util.Base64;

import br.com.quintoandar.sakuraerrorcaptor.model.Tenant;

public class SignInDTO {
	private Long id;
	private String name;
	private String email;
	private String password;
	private String token;
	private Tenant tenant;
		
	public SignInDTO(Long id, String name, String email, String password, String token, Tenant tenant) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.token = Base64.getEncoder().encodeToString(new String (getEmail()+":"+getPassword()).getBytes());
		this.tenant = tenant;
		
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Tenant getTenant() {
		return tenant;
	}
	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
}
