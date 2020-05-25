package io.springlab.springsecurityv3.controller;

import io.springlab.springsecurityv3.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/adminapi/v3/students")
public class StudentManagementController {

    private final List<Student> students= Arrays.asList(
            new Student(1,"adcf"),
            new Student(2,"asaas"),
            new Student(3,"aseed")
    );

    @RequestMapping(method = RequestMethod.GET)
    public List<Student> getStudents(){
        return students;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void regNewStudent(@RequestBody  Student student){
        System.out.println(student);
    }

    @RequestMapping(method = RequestMethod.DELETE,path = "{id}")
    public void delStudentById(@PathVariable("id")  Integer id){
        System.out.println(id);
    }

    @RequestMapping(method = RequestMethod.PUT,path="{id}")
    public void updateStudent(@PathVariable("id") Integer id,@RequestBody  Student student){
        System.out.println(String.format("%s,%s",id,student));
    }
}
