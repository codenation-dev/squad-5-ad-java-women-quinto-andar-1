package br.com.quintoandar.sakuraerrorcaptor.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;

import br.com.quintoandar.sakuraerrorcaptor.model.json.ArchiveJson;
import br.com.quintoandar.sakuraerrorcaptor.util.JSONBEntity;

@Entity
@Table(name = "archive")
public class Archive extends JSONBEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Type(type = "jsonb")
	@Column(columnDefinition = "jsonb",name = "archive")
	private ArchiveJson archive;
	
	@CreatedDate
	@Column(name = "archived_in")
	private LocalDateTime archivedIn;
	
	public Archive(Long id, ArchiveJson archive) {
		this.id = id;
		this.archive = archive;
		this.archivedIn = LocalDateTime.now();		
	}
	
	public Archive() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ArchiveJson getArchive() {
		return archive;
	}

	public void setArchive(ArchiveJson archive) {
		this.archive = archive;
	}

	public LocalDateTime getArchivedIn() {
		return archivedIn;
	}

	public void setArchivedIn(LocalDateTime archivedIn) {
		this.archivedIn = archivedIn;
	}
	
}
