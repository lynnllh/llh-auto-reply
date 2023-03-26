package com.yupi.autoreply.api.openai.model;

import lombok.Data;

@Data
public class Message {
    private String role;
    private String content;
}
