package com.studentDetails.Student.Controller;

import com.studentDetails.Student.DAO.sqlOperation;
import com.studentDetails.Student.Models.studentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class studentController {
    @Autowired
    sqlOperation sqloperation;
    List<studentModel> studentmodelsList=new ArrayList<>();

    @GetMapping(path = "/showStudentDetails")
    public List getstudentDetails() throws Exception{

        studentModel[] studentmodel=new studentModel[100];
        studentmodelsList=sqloperation.SelectStudent();

        return studentmodelsList;

    }
    @RequestMapping(path = "/inserstudentDetails",method = RequestMethod.POST)
    public studentModel inserStudentDetails(@RequestBody studentModel stud){
        studentModel counter=sqloperation.InsertStudent(stud);
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
    public int deleteStudent(HttpServletRequest request) throws Exception{

        int student_id=Integer.parseInt(request.getParameter("student_id"));
    int count=sqloperation.DeleteStudent(student_id);

    return count;
    }





}
