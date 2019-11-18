package br.com.quintoandar.sakuraerrorcaptor.model.json;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.quintoandar.sakuraerrorcaptor.model.enums.Environment;
import br.com.quintoandar.sakuraerrorcaptor.model.enums.Level;

public class ArchiveJson implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1582508694898401476L;

	@Enumerated(EnumType.STRING)
	private Environment environment;
	
	@Enumerated(EnumType.STRING)
	private Level level;
	
	private List<TenantJson> tenant;
	
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

	public List<TenantJson> getTenant() {
		return tenant;
	}

	public void setTenant(List<TenantJson> tenant) {
		this.tenant = tenant;
	}
	public void addTenant(Long id, String name) {
		if (tenant == null) {
			tenant = new ArrayList<TenantJson>();
		}
		this.tenant.clear();
		this.tenant.add(new TenantJson(id,name));
	}
	
	private String getOccurrencesToString() {
		String result  = "        {\n";
		for (OccurrenceJson o: this.occurrences) {
			if (!result.equals("        {\n")) {
				result = result +",";
			}
			result = result + o.toString()+"\n";
		}
		return result+"        }\n";
	}
	
	private String getTrackedSystemToString() {
		String result  = "        {\n";
		for (TrackedSystemJson t: this.trackedSystem) {
			if (!result.equals("        {\n")) {
				result = result +",";
			}
			result = result+ t.toString()+"\n";
		}
		return result+"        }\n";
	}
	
	private String getTenantToString() {
		String result = "        {\n";
		for (TenantJson t: this.tenant) {
			if (!result.equals("        {\n")) {
				result = result +",";
			}
			result = result + t.toString()+"\n";
		}
		return result+"        }\n";
	}
	
	@Override
	public String toString() {
		String result = "{\n" + 
				"    \"level\": \""+this.level+"\",\n" + 
				"    \"tenant\": [\n" + getTenantToString() + 
				"    ],\n" + 
				"    \"environment\": \""+this.environment+"\",\n" + 
				"    \"occurrences\":[\n" + getOccurrencesToString() +
				"    ],\n" + 
				"    \"trackedSystem\":[\n" + getTrackedSystemToString() +
				"    ]\n" +
				"}\n" + 
				"";
		return result;
	}
	
}
