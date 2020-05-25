package io.springlab.springsecurityv3.exceptionhandler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentClassExceptionHandler{

    @ExceptionHandler
    public String studentDataNotFoundException(StudentNotFoundException s){
        return s.getMessage();
    }

}
