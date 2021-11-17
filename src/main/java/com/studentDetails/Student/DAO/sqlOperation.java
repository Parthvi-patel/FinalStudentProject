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
                +" "+rs.getString(4)+" "+rs.getString(5));
                studentmodel[count] = new studentModel(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5)  );
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


    public int InsertStudent(int studentId, String studentName, String departmentName, String studentMobileNo, String studentAddmissionDate){
        int counterinsert=0;
        try{
            con=sqlconnection.getCon();
           // stmt=con.createStatement();
            pstmt=con.prepareStatement(queries.InsertStudent);
            studentModel.setStudentId(studentId);
            studentModel.setStudentName(studentName);
            studentModel.setDepartmentName(departmentName);
            studentModel.setStudentMobileNo(studentMobileNo);
            studentModel.setStudentAddmissionDate(studentAddmissionDate);

            pstmt.setInt(1,studentModel.getStudentId());
            pstmt.setString(2,studentModel.getStudentName());
            pstmt.setString(3,studentModel.getDepartmentName());
            pstmt.setString(4,studentModel.getStudentMobileNo());
            pstmt.setString(5,studentModel.getStudentAddmissionDate());


            counterinsert=pstmt.executeUpdate();
            System.out.println("Record inserted sucessfully..");
            con.close();
            System.out.println("Connection closed");
        }catch (Exception e){
            System.out.println(e);
        }
        return counterinsert;

    }

    public int UpdateStudent(int studentId,String studentName){

        int counterupdate=0;
        try{
            con=sqlconnection.getCon();
            stmt=con.createStatement();
            pstmt=con.prepareStatement(queries.UpdateStudent);
            pstmt.setString(1,studentName);
            pstmt.setInt(2,studentId);
            counterupdate=pstmt.executeUpdate();
            System.out.println("updated sucessfully");
            con.close();
            System.out.println("Connection closed");
        }catch(Exception e){
            System.out.println(e);
        }

        return counterupdate;
    }
    public int DeleteStudent(int studentId){

        int deletecounter=0;
        try{

            con=sqlconnection.getCon();
            pstmt=con.prepareStatement(queries.DeleteStudent);
            pstmt.setInt(1,studentId);

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
