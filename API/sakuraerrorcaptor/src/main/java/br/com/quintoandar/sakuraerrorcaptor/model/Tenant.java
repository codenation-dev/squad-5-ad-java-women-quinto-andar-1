package br.com.quintoandar.sakuraerrorcaptor.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tenant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToMany
	private List<SystemUser> users;
	
	@OneToMany
	private List<TrackedSystem> trackedSystems;
	
	public Tenant() {
		
	}
	
	public Tenant(Long id,String name) {
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

	public List<SystemUser> getUsers() {
		return users;
	}

	public void setUsers(List<SystemUser> users) {
		this.users = users;
	}

	public List<TrackedSystem> getTrackedSystems() {
		return trackedSystems;
	}

	public void setTrackedSystems(List<TrackedSystem> trackedSystems) {
		this.trackedSystems = trackedSystems;
	}
	
}
