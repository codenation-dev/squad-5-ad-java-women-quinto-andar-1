package br.com.quintoandar.sakuraerrorcaptor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Occurrence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "This field is mandatory")
    private String title;

    @NotEmpty(message = "This field is mandatory")
    private String detail;

    public Occurrence() {
    }

    public Occurrence(Long id, String title, String detail) {
		super();
		this.id = id;
		this.title = title;
		this.detail = detail;
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

}
