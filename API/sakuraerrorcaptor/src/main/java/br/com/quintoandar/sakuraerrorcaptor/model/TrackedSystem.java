package br.com.quintoandar.sakuraerrorcaptor.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class TrackedSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String name;

    @Column(length = 50, nullable = false)
    public String location;

    //public Tenant tenant;

    @Column(length = 100, nullable = false)
    public String token;
}
