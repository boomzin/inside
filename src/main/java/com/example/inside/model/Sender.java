package com.example.inside.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "sender")
public class Sender extends AbstractBaseEntity{

    @Column(name = "username", nullable = false, unique = true)
    @NotEmpty
    @NotBlank
    @Size(max = 128)
    private String username;

    @Column(name = "password")
    @Size(min = 4, max = 256)
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "username")
    @OrderBy("dateTime DESC")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonManagedReference
    private List<Message> messages;
}
