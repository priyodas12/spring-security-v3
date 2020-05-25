package io.springlab.springsecurityv3.controller;


import io.springlab.springsecurityv3.exceptionhandler.StudentNotFoundException;
import io.springlab.springsecurityv3.model.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/globalapi/v3/students")
public class StudentController {


    private final List<Student> students=Arrays.asList(
                                                    new Student(1,"adcf"),
                                                    new Student(2,"asaas"),
                                                    new Student(3,"aseed")
                                            );

    @RequestMapping(path = {"/{id}"},method = RequestMethod.GET)
    public Student getStudents(@PathVariable("id") Integer id){
        return students
                .stream()
                .filter(s->s.getId().equals(id))
                .findFirst()
                .orElseThrow(()->new StudentNotFoundException("404! Student info not found for student id= "+id));
    }
}
