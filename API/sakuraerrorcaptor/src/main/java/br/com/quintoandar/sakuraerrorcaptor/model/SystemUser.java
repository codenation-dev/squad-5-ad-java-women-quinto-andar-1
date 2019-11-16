package br.com.quintoandar.sakuraerrorcaptor.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class SystemUser {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String name;
	
	@Email
	private String email;
	
	//ManyToOne
	//private Tenant tenate;
	
	private String token;
	
	private Boolean admin;
	
	@CreatedDate
    @NotEmpty(message = "This field is mandatory")
	private Date createdIn;
	
	private Boolean active;
	
	@CreatedDate
    @NotEmpty(message = "This field is mandatory")
	private Date disabledIn;
	

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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public Date getCreatedIn() {
		return createdIn;
	}

	public void setCreatedIn(Date createdIn) {
		this.createdIn = createdIn;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getDisabledln() {
		return disabledIn;
	}

	public void setDisabledln(Date disabledln) {
		this.disabledIn = disabledln;
	}

	
	
	
	
	

}
