package br.com.quintoandar.sakuraerrorcaptor.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
public class LogOcurrence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "This field is mandatory")
    private Log log;

    @NotEmpty(message = "This field is mandatory")
    private Ocurrence ocurrence;

    @NotEmpty(message = "This field is mandatory")
    private LocalDateTime occurredIn;

}
