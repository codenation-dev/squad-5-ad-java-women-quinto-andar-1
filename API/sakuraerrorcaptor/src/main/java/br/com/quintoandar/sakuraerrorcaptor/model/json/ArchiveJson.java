package br.com.quintoandar.sakuraerrorcaptor.model.json;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.quintoandar.sakuraerrorcaptor.model.Environment;
import br.com.quintoandar.sakuraerrorcaptor.model.Level;

public class ArchiveJson implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1582508694898401476L;

	@Enumerated(EnumType.STRING)
	private Environment environment;
	
	@Enumerated(EnumType.STRING)
	private Level level;
	
	private Long tenantId;
	
	private String tenant;
	
	private List<TrackedSystemJson> trackedSystem;
		
	private List<OccurrenceJson> occurrences;

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

	public String getTenant() {
		return tenant;
	}

	public void setTenant(String tenant) {
		this.tenant = tenant;
	}

	public List<TrackedSystemJson> getTrackedSystem() {
		return trackedSystem;
	}

	public void setTrackedSystem(List<TrackedSystemJson> trackedSystem) {
		this.trackedSystem = trackedSystem;
	}

	public List<OccurrenceJson> getOccurrences() {
		return occurrences;
	}

	public void setOccurrences(List<OccurrenceJson> occurrences) {
		this.occurrences = occurrences;
	}
}
