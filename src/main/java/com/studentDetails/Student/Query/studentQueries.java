package com.studentDetails.Student.Query;

import org.springframework.stereotype.Component;

@Component
public class studentQueries {
    public static String SelectStudent="select * from student";
    //public static String InsertStudent = "INSERT INTO `student` (`student_id`, `student_name`,`department_name`,'student_mobile_no',`student_addmission_date`,'student_addmission_year)VALUES ('?','?','?','?','?','?')";
    public static String InsertStudent = "INSERT INTO `student` (student_id,student_name,department_name,student_mobile_no,student_addmission_date,student_addmission_year)VALUES (?,?,?,?,?,?)";
    public static String UpdateStudent ="UPDATE `student` SET student_name = ? WHERE student_id = ?";
    public static String DeleteStudent=  "delete from student where student_id=(?);";
    public static String conutStudent=" select count(*) as total from student";
}
