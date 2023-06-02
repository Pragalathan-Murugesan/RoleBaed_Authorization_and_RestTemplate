package com.example.RoleBaed_Authorization_and_RestTemplate.GlobalException;

import com.example.RoleBaed_Authorization_and_RestTemplate.api_response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalException {
    @Autowired
    private ApiResponse apiResponse;
    @ExceptionHandler(MethodArgumentNotValidException.class)
           public ApiResponse handleMethodArgumentsNotFoundException(MethodArgumentNotValidException e){
               HashMap<String, Object> errors = new HashMap<>();
               e.getBindingResult().getFieldErrors().forEach((error) ->{
                   String fieldError = error.getField();
                   String message = error.getDefaultMessage();
                   errors.put(fieldError,message);
                   apiResponse.setData(null);
                   apiResponse.setStatus(errors);
                   apiResponse.setMessage("Something Went To Wrong");
               });
               return apiResponse;
           }

@ExceptionHandler(IllegalException.class)
    public ApiResponse IllegalException(IllegalException e){
        apiResponse.setData(null);
        apiResponse.setMessage("UnAuthorized Token Access");
        apiResponse.setStatus(HttpStatus.UNAUTHORIZED);
        return apiResponse;
           }
}
