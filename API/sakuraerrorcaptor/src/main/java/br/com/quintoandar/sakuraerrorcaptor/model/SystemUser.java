package br.com.quintoandar.sakuraerrorcaptor.model;

import java.util.Base64;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class SystemUser {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String name;
	
	@Email
	private String email;
	
	private String password;
	
	@ManyToOne
	private Tenant tenant;
	
	private String token;
	
	private Boolean admin;
	
	@CreatedDate
//    @NotEmpty(message = "This field is mandatory")
	private Date createdIn;
	
	private Boolean active;	
	
	private Date disabledIn;	

	public SystemUser() {
		
	}
	public SystemUser(Long id, String name, @Email String email, String password, 
			Tenant tenant, String token,
			Boolean admin, Date createdIn, Boolean active, Date disabledIn) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.tenant = tenant;
		this.token = token;
		this.admin = admin;
		this.createdIn = createdIn;
		this.active = active;
		this.disabledIn = disabledIn;
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

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public Date getDisabledIn() {
		return disabledIn;
	}

	public void setDisabledIn(Date disabledIn) {
		this.disabledIn = disabledIn;
	}
}
