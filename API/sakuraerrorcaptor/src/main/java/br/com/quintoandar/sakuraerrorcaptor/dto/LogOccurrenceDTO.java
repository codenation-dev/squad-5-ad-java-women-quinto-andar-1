package br.com.quintoandar.sakuraerrorcaptor.dto;

public class LogOccurrenceDTO  {

	private Long event;
	private String level;
	private String environment;
	private String title;
	private String detail;
	private Long log_id;
	private Long occurrence_id;
	private String location;
	
	public LogOccurrenceDTO() {
	}
	
	public LogOccurrenceDTO(Long event, String level, String environment, String title, String detail, Long log_id,
			Long occurrence_id, String location) {
		super();
		this.event = event;
		this.level = level;
		this.environment = environment;
		this.title = title;
		this.detail = detail;
		this.log_id = log_id;
		this.occurrence_id = occurrence_id;
		this.location = location;
	}
	public Long getEvent() {
		return event;
	}
	public void setEvent(Long event) {
		this.event = event;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Long getLog_id() {
		return log_id;
	}
	public void setLog_id(Long log_id) {
		this.log_id = log_id;
	}
	public Long getOccurrence_id() {
		return occurrence_id;
	}
	public void setOccurrence_id(Long occurrence_id) {
		this.occurrence_id = occurrence_id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
