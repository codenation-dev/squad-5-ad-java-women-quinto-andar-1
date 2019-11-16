package br.com.quintoandar.sakuraerrorcaptor.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Log {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private Environment environment;

	@Enumerated(EnumType.STRING)
	private Level level;

	private Long tenantId;

	private TrackedSystem trackedSystem;
	
	public Log() {
		
	}

	public Log(Long id, Environment environment, Level level, Long tenantId, TrackedSystem trackedSystem) {
		super();
		this.id = id;
		this.environment = environment;
		this.level = level;
		this.tenantId = tenantId;
		this.trackedSystem = trackedSystem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public TrackedSystem getTrackedSystem() {
		return trackedSystem;
	}

	public void setTrackedSystem(TrackedSystem trackedSystem) {
		this.trackedSystem = trackedSystem;
	}

}
