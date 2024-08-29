package com.ssafy.meshroom.backend.domain.topic.chat.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;

@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageSubscribe {
    private String userName;
    private String sessionId;
    private String content;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Instant timestamp;
//    private Date timestamp = new Date(System.currentTimeMillis());

    public static ChatMessageSubscribe from (ChatMessagePublish chatMessagePublish, String userName) {
        return new ChatMessageSubscribe(
            userName,
            chatMessagePublish.getSessionId(),
            chatMessagePublish.getContent(),
            chatMessagePublish.getTimestamp()
        );
    }
}
