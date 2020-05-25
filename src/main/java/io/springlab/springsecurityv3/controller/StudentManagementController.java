package io.springlab.springsecurityv3.controller;

import io.springlab.springsecurityv3.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/adminapi/v3/students")
public class StudentManagementController {

    Logger logger= LoggerFactory.getLogger(StudentManagementController.class);

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
        logger.debug("regNewStudent called to post {}",student.getId());
    }

    @RequestMapping(method = RequestMethod.DELETE,path = "{id}")
    public void delStudentById(@PathVariable("id")  Integer id){
        logger.debug("delStudentById called to delete {}",id);
    }

    @RequestMapping(method = RequestMethod.PUT,path="{id}")
    public void updateStudent(@PathVariable("id") Integer id,@RequestBody  Student student){
        logger.debug("updateStudent called to update {}",student.getId());
    }
}
