package com.example.freecrmbackend.domain.user.authority;

import com.example.freecrmbackend.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "authorities")
@Getter
@Setter
public class Authority {

    @Id
    @SequenceGenerator(
            name = "authority_id_sequence",
            sequenceName = "authority_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "authority_id_sequence"
    )
    private Integer authorityId;
    private String name;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;
}
