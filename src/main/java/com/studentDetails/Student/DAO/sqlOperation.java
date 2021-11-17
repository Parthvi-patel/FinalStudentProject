package com.studentDetails.Student.DAO;

import com.google.gson.Gson;
import com.studentDetails.Student.Connection.sqlConnection;
import com.studentDetails.Student.Models.studentModel;
import com.studentDetails.Student.Query.studentQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class sqlOperation {
    @Autowired
    sqlConnection sqlconnection;
    @Autowired
    studentQueries queries;
    @Autowired
            private Gson gson;

    studentModel studentModel = new studentModel();

    Statement stmt;

    PreparedStatement pstmt;

    Connection con;



    public List SelectStudent(){

        int count=0;

        studentModel[] studentmodel=new studentModel[5];
        List<studentModel> studentModelList=new ArrayList<>();
        try{
            con=sqlconnection.getCon();
            stmt=con.createStatement();

            ResultSet rs= stmt.executeQuery(queries.SelectStudent);

            while (rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)
                +" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
                studentmodel[count] = new studentModel(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6) );
                studentModelList.add(studentmodel[count]);
                count++;
            }
            con.close();
        }catch (Exception e)
        {
            System.out.println(e);
        }
        return studentModelList;
    }


    public int InsertStudent(int student_id, String student_name, String department_name, String student_mobile_no, String student_addmission_date, String student_addmission_year){
        int counterinsert=0;
        try{
            con=sqlconnection.getCon();
           // stmt=con.createStatement();
            pstmt=con.prepareStatement(queries.InsertStudent);
            studentModel.setStudent_id(student_id);
            studentModel.setStudent_name(student_name);
            studentModel.setDepartment_name(department_name);
            studentModel.setStudent_mobile_no(student_mobile_no);
            studentModel.setStudent_addmission_date(student_addmission_date);
            studentModel.setStudent_addmission_year(student_addmission_year);
            pstmt.setInt(1,studentModel.getStudent_id());
            pstmt.setString(2,studentModel.getStudent_name());
            pstmt.setString(3,studentModel.getDepartment_name());
            pstmt.setString(4,studentModel.getStudent_mobile_no());
            pstmt.setString(5,studentModel.getStudent_addmission_date());
            pstmt.setString(6,studentModel.getStudent_addmission_year());

            counterinsert=pstmt.executeUpdate();
            System.out.println("Record inserted sucessfully..");
            con.close();
            System.out.println("Connection closed");
        }catch (Exception e){
            System.out.println(e);
        }
        return counterinsert;

    }

    public int UpdateStudent(int student_id,String student_name){

        int counterupdate=0;
        try{
            con=sqlconnection.getCon();
            stmt=con.createStatement();
            pstmt=con.prepareStatement(queries.UpdateStudent);
            pstmt.setString(1,student_name);
            pstmt.setInt(2,student_id);
            counterupdate=pstmt.executeUpdate();
            System.out.println("updated sucessfully");
            con.close();
            System.out.println("Connection closed");
        }catch(Exception e){
            System.out.println(e);
        }

        return counterupdate;
    }
    public int DeleteStudent(int student_id){

        int deletecounter=0;
        try{

            con=sqlconnection.getCon();
            pstmt=con.prepareStatement(queries.DeleteStudent);
            pstmt.setInt(1,student_id);

            deletecounter=pstmt.executeUpdate();
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return deletecounter;
    }
    public int counttotalDetails(){
        int counter=0;
        try{
            con=sqlconnection.getCon();
            stmt=con.createStatement();

            ResultSet rs=stmt.executeQuery(queries.conutStudent);
            while (rs.next()){
               counter=rs.getInt("total");
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return counter;
    }

    





}
