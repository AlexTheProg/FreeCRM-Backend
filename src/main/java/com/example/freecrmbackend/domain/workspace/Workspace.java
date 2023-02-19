package com.example.freecrmbackend.domain.workspace;

import com.example.freecrmbackend.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "workspaces")
public class Workspace {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    @Column(nullable = false)
    private UUID workspaceId;
    private String workspaceName;

    @OneToMany(mappedBy = "workspace",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<User> users;

}
