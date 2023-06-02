package com.example.RoleBaed_Authorization_and_RestTemplate.api_response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Component
public class ApiResponse {
    private Object data;
    private Object status;
    private String message;
}
