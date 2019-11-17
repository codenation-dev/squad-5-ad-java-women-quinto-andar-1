package br.com.quintoandar.sakuraerrorcaptor.model;

import lombok.Getter;
import lombok.Setter;

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

    @Column(length = 100, nullable = false)
    public String token;

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
