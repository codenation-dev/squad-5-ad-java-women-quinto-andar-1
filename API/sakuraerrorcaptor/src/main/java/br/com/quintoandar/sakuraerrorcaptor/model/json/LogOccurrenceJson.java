package br.com.quintoandar.sakuraerrorcaptor.model.json;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Convert;

import br.com.quintoandar.sakuraerrorcaptor.util.LocalDateTimeConverter;

public class LogOccurrenceJson implements Serializable{
	private Long id;
	
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime occurredIn;

	public LogOccurrenceJson(Long id, LocalDateTime occurredIn) {
		this.id = id;
		this.occurredIn = occurredIn;
	}
	
	public LogOccurrenceJson() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getOccurredIn() {
		return occurredIn;
	}

	public void setOccurredIn(LocalDateTime occurredIn) {
		this.occurredIn = occurredIn;
	}
	@Override
	public String toString() {
		String result = "                \"id\": \""+this.id+"\""
				+",\n                \"occurredIn\": \""+this.occurredIn+"\"";
		return result;
	}
	
}
