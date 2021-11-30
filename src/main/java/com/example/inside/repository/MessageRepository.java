package com.example.inside.repository;

import com.example.inside.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface MessageRepository extends JpaRepository<Message, Integer> {

    @Query(value = "SELECT * FROM Message m WHERE m.sender_id=?1 ORDER BY m.message_datetime DESC LIMIT ?2", nativeQuery = true)
    List<Message> getPackMessageForSender(int userId, int count);

}
