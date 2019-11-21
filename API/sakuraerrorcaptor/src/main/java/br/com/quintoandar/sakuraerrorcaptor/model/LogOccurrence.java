package br.com.quintoandar.sakuraerrorcaptor.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
public class LogOccurrence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Log log;

    @NotNull
    @ManyToOne
    private Occurrence occurrence;

    @NotNull
    @CreatedDate
    private LocalDateTime occurredIn;

	public LogOccurrence() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

	public Occurrence getOccurrence() {
		return occurrence;
	}

	public void setOccurrence(Occurrence Occurrence) {
		this.occurrence = Occurrence;
	}

	public LocalDateTime getOccurredIn() {
		return occurredIn;
	}

	public void setOccurredIn(LocalDateTime occurredIn) {
		this.occurredIn = occurredIn;
	}

}