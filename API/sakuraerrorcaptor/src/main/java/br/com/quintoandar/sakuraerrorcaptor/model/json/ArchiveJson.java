package br.com.quintoandar.sakuraerrorcaptor.model.json;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.Type;

public class ArchiveJson implements Serializable{
	private String environment;
	
	private String level;
	
	private Long tenantId;
	
	private String tenant;
	
	private List<TrackedSystemJson> trackedSystem;
		
	private List<OccurrenceJson> occurrences;

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
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

	public List<OccurrenceJson> getOccurrences() {
		return occurrences;
	}

	public void setOccurrences(List<OccurrenceJson> occurrences) {
		this.occurrences = occurrences;
	}

	public List<TrackedSystemJson> getTrackedSystem() {
		return trackedSystem;
	}

	public void setTrackedSystem(List<TrackedSystemJson> trackedSystem) {
		this.trackedSystem = trackedSystem;
	}	
	
}
