package com.example.inside.web;

import com.example.inside.dto.MessageDto;
import com.example.inside.model.Message;
import com.example.inside.model.Sender;
import com.example.inside.repository.MessageRepository;
import com.example.inside.repository.SenderRepository;
import com.example.inside.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping(value = MessageController.REST_URL)
public class MessageController {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MessageController.class);
    static final String REST_URL = "/api/messages";

    private MessageRepository messageRepository;
    private SenderRepository senderRepository;
    private JwtTokenProvider jwtTokenProvider;

    public MessageController(MessageRepository messageRepository, SenderRepository senderRepository, JwtTokenProvider jwtTokenProvider) {
        this.messageRepository = messageRepository;
        this.senderRepository = senderRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping
    @ResponseBody()
    public ResponseEntity getMessages(@RequestBody MessageDto messageDto, HttpServletRequest request) throws Exception {
        log.info("Post method in message controller");
        Sender sender = senderRepository
                .findByUsername(messageDto.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User with username: " + messageDto.getUsername() + " not found"));
        String username = jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(request));
        if (!sender.getUsername().equalsIgnoreCase(username)) {
            throw new IllegalAccessException("Sender "
                    + username
                    + " cannot manage messages belonging to the "
                    + messageDto.getUsername());
        }
        if (messageDto.getMessage().toLowerCase().startsWith("history ")) {
            log.info("return history");
            Pattern pattern = Pattern.compile("(?<=^history\\s)\\d*\\b");
            Matcher matcher = pattern.matcher(messageDto.getMessage().toLowerCase());
            if (matcher.find())
            {
                int count = Integer.parseInt(matcher.group(0));
                return ResponseEntity.ok(messageRepository.getPackMessageForSender(sender.getId(), count));
            }
        }

        Message message = new Message();
        message.setMessage(messageDto.getMessage());
        message.setSender(sender);
        message.setDateTime(LocalDateTime.now());
        return ResponseEntity.ok(messageRepository.save(message));
    }

}
