package br.com.quintoandar.sakuraerrorcaptor.model.json;

import java.io.Serializable;
import java.util.List;

public class OccurrenceJson implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5899642383477729907L;
	private Long id;
	private String title;
	private String detail;
	private List<LogOccurrenceJson> logOccurrences;
	
	public OccurrenceJson(String title, String detail, List<LogOccurrenceJson> logOccurrences) {
		this.title = title;
		this.detail = detail;
		this.logOccurrences = logOccurrences;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public List<LogOccurrenceJson> getLogOccurrences() {
		return logOccurrences;
	}
	public void setLogOccurrences(List<LogOccurrenceJson> logOccurrences) {
		this.logOccurrences = logOccurrences;
	}	
}
