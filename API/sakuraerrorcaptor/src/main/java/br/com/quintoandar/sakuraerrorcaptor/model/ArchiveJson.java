package br.com.quintoandar.sakuraerrorcaptor.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class ArchiveJson implements Serializable{
	private String environment;
	private String level;
	private Long tenantId;
	private String tenant;
	private Long trackedSystemId;
	private String trackedSystemName;
	private LocalDateTime occurredIn;
	private List<String> title;
	private List<String> detail;
	
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
	public Long getTrackedSystemId() {
		return trackedSystemId;
	}
	public void setTrackedSystemId(Long trackedSystemId) {
		this.trackedSystemId = trackedSystemId;
	}
	public String getTrackedSystemName() {
		return trackedSystemName;
	}
	public void setTrackedSystemName(String trackedSystemName) {
		this.trackedSystemName = trackedSystemName;
	}
	public LocalDateTime getOccurredIn() {
		return occurredIn;
	}
	public void setOccurredIn(LocalDateTime occurredIn) {
		this.occurredIn = occurredIn;
	}
	public List<String> getTitle() {
		return title;
	}
	public void setTitle(List<String> title) {
		this.title = title;
	}
	public List<String> getDetail() {
		return detail;
	}
	public void setDetail(List<String> detail) {
		this.detail = detail;
	}	
}
