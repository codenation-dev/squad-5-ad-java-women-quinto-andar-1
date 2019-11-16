package br.com.quintoandar.sakuraerrorcaptor.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Environment environment;

    @Enumerated(EnumType.STRING)
    private Level level;

    // TODO: falta ainda definir tentant e trackedSystem

}
