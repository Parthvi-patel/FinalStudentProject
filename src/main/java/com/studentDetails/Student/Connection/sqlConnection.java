package com.studentDetails.Student.Connection;

import com.studentDetails.Student.Consatnt.QueryConsatnt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;



@Component
public class sqlConnection {

    @Autowired
    QueryConsatnt queryConsatnt;
    Connection con;
    public Connection getCon(){
        try {
            con = DriverManager.getConnection(queryConsatnt.url,queryConsatnt.user,queryConsatnt.password);

        }catch (Exception e){
            System.out.println(e);
        }
        return con;

    }



}
