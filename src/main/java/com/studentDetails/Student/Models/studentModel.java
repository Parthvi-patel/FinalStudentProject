package com.studentDetails.Student.Models;

import org.springframework.stereotype.Component;

@Component
public class studentModel {
    int student_id;
    String student_name,department_name,student_mobile_no,student_addmission_date,student_addmission_year;

    public studentModel(int student_id, String student_name, String department_name, String student_mobile_no, String student_addmission_date, String student_addmission_year) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.department_name = department_name;
        this.student_mobile_no = student_mobile_no;
        this.student_addmission_date = student_addmission_date;
        this.student_addmission_year = student_addmission_year;
    }

    public studentModel() {

    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getStudent_mobile_no() {
        return student_mobile_no;
    }

    public void setStudent_mobile_no(String student_mobile_no) {
        this.student_mobile_no = student_mobile_no;
    }

    public String getStudent_addmission_date() {
        return student_addmission_date;
    }

    public void setStudent_addmission_date(String student_addmission_date) {
        this.student_addmission_date = student_addmission_date;
    }

    public String getStudent_addmission_year() {
        return student_addmission_year;
    }

    public void setStudent_addmission_year(String student_addmission_year) {
        this.student_addmission_year = student_addmission_year;
    }
}
