package com.example.inside.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "message")
public class Message extends AbstractBaseEntity {

    public Sender getUsername() {
        return username;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getMessage() {
        return message;
    }

    @ManyToOne
    @JsonBackReference
    private Sender username;

    @Column(name = "message_datetime")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @NotNull
    private LocalDateTime dateTime;

    @Column(name = "message")
    @NotNull
    private String message;
}
