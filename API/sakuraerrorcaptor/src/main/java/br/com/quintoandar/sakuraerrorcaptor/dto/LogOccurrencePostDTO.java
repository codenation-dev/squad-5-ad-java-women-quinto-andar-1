package br.com.quintoandar.sakuraerrorcaptor.dto;

public class LogOccurrencePostDTO {
	private String trackedSystemToken;
	private String logTtle;
	private String logDetail;
	private String environment;
	private String level;
	
	public LogOccurrencePostDTO(String trackedSystemToken, String logTtle, String logDetail, String environment,
			String level) {
		super();
		this.trackedSystemToken = trackedSystemToken;
		this.logTtle = logTtle;
		this.logDetail = logDetail;
		this.environment = environment;
		this.level = level;
	}
	public String getTrackedSystemToken() {
		return trackedSystemToken;
	}
	public void setTrackedSystemToken(String trackedSystemToken) {
		this.trackedSystemToken = trackedSystemToken;
	}
	public String getLogTtle() {
		return logTtle;
	}
	public void setLogTtle(String logTtle) {
		this.logTtle = logTtle;
	}
	public String getLogDetail() {
		return logDetail;
	}
	public void setLogDetail(String logDetail) {
		this.logDetail = logDetail;
	}
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
}
