package com.example.inside.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    @ManyToOne
    @JsonBackReference
    private Sender sender;

    @Column(name = "message_datetime", nullable = false, columnDefinition = "timestamp(0) default now()")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;

    @Column(name = "message")
    @NotNull
    private String message;

    public Sender getSender() {
        return sender;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
