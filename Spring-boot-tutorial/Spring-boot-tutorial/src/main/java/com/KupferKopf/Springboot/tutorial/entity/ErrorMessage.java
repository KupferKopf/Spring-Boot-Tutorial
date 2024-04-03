package com.KupferKopf.Springboot.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    // used for customising the Responsetext to get some more details
    private HttpStatus status;
    private String message;
}
