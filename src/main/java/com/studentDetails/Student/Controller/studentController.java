package com.studentDetails.Student.Controller;

import com.google.gson.Gson;
import com.studentDetails.Student.DAO.sqlOperation;
import com.studentDetails.Student.Models.studentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@EnableSwagger2
@RequestMapping("/api")
public class studentController {
    @Autowired
    sqlOperation sqloperation;
    List<studentModel> studentmodelsList=new ArrayList<>();


    @GetMapping(path = "/showStudentDetails")

    public String getstudentDetails() {

        Gson studentmodeljson=new Gson();
        String studentjsonObj=studentmodeljson.toJson(sqloperation.SelectStudent());
//        studentModel[] studentmodel=new studentModel[100];
//        studentmodelsList=sqloperation.SelectStudent();
        System.out.println(studentjsonObj);

        return studentjsonObj;

    }

//    public studentModel inserStudentDetails(@RequestBody studentModel stud){
//        studentModel counter=sqloperation.InsertStudent(stud);
//        return counter;
//    }
    @RequestMapping(path = "/inserstudentDetails",method = RequestMethod.POST)
    public  int insertStudentDetails(@RequestParam int student_id ,@RequestParam String student_name ,@RequestParam String department_name,@RequestParam String student_mobile_no ,@RequestParam String student_addmission_date ,@RequestParam String student_addmission_year){
        int counter=0;
        counter=sqloperation.InsertStudent(student_id,student_name,department_name,student_mobile_no,student_addmission_date,student_addmission_year);

        return counter;
    }
    //@RequestMapping(path = "/updateStudentDetails",method = RequestMethod.PUT)
   @PutMapping("/updateStudentDetails")

    public int updateStudentdetails(@RequestParam ("student_id") int student_id, @RequestParam("student_name") String student_name) {
        int count = 0;
       count=sqloperation.UpdateStudent(student_id,student_name);
        return count;
    }

    @RequestMapping(path = "/deleteStudentDetails",method = RequestMethod.DELETE)
    public int deleteStudent(@RequestParam int student_id) throws Exception{

        int count=0;

     count=sqloperation.DeleteStudent(student_id);

    return count;
    }
    @GetMapping("/totalStudentDetails")
    public int totalDetails(){
        int counter=0;
        counter=sqloperation.counttotalDetails();
        return counter;
    }





}
