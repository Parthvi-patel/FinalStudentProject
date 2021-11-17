package com.studentDetails.Student.Query;

import org.springframework.stereotype.Component;

@Component
public class studentQueries {
    public static String SelectStudent="select * from student";
    public static String InsertStudent = "INSERT INTO `student` (studentId,studentName,departmentName,studentMobileNo,studentAddmissionDate)VALUES (?,?,?,?,?)";
    public static String UpdateStudent ="UPDATE `student` SET studentName = ? WHERE studentId = ?";
    public static String DeleteStudent=  "delete from student where studentId=(?);";
    public static String conutStudent=" select count(*) as total from student";

}
