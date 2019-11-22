package br.com.quintoandar.sakuraerrorcaptor.model;

import java.util.Base64;

import javax.persistence.*;

@Entity
public class TrackedSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String name;

    @Column(length = 50, nullable = false)
    public String location;

    @ManyToOne
    public Tenant tenant;

    @Column(length = 100)
    public String token;

    public TrackedSystem() {
    	
    }
    
	public TrackedSystem(Long id, String name, String location, Tenant tenant, String token) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.tenant = tenant;
		this.token = Base64.getEncoder().encodeToString(new String (getName()+":"+getLocation()).getBytes());
	}
	
	public TrackedSystem(Long id, String name, String location, Tenant tenant) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.tenant = tenant;
		this.token = Base64.getEncoder().encodeToString(new String (getName()+":"+getLocation()).getBytes());
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

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
    
}
