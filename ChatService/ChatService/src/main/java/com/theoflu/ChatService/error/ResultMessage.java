package com.theoflu.ChatService.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class ResultMessage {
    private String message;
    private int statusCode;

}
