package io.springlab.springsecurityv3.exceptionhandler;

public class StudentNotFoundException  extends  RuntimeException{

    private String message;

    public StudentNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
