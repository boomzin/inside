package com.example.inside.repository;

import com.example.inside.model.Sender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SenderRepository extends JpaRepository<Sender, Integer> {
    Optional<Sender> findByUsername(String name);
}
