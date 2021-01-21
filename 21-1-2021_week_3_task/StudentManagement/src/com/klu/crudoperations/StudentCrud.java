package com.klu.crudoperations;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.Scanner;
import com.klu.Bean.StudentBean;
import com.klu.Connections.DBUtil;

public class StudentCrud {
	static Scanner s=new Scanner(System.in);
public int StudentInsert(StudentBean student) throws ClassNotFoundException, SQLException
{
	System.out.println("Student details are being inserted");
	Connection con=DBUtil.DBConnection();
	PreparedStatement st1=con.prepareStatement("insert into Student values(?,?,?)");  
	st1.setInt(1,student.getRegno());
	st1.setString(2,student.getName());
	st1.setString(3,student.getEmail());
	int i=st1.executeUpdate();    
	con.close();  
	return i;
}
public int StudentDeletion() throws ClassNotFoundException, SQLException
{
	System.out.println("Please enter the register number  of the student to be deleted:");
	int num=s.nextInt();
	Connection con=DBUtil.DBConnection();
	PreparedStatement st1=con.prepareStatement(" delete from Student where regno=?");  
	st1.setInt(1,num);  
	int i=st1.executeUpdate();    
	con.close();  
	return i;
}
public int StudentUpdate() throws ClassNotFoundException, SQLException
{
	System.out.println("Please enter the updation details like column name and the student id ");
	String column=s.next();
	int num=s.nextInt();
	Connection con=DBUtil.DBConnection();
	PreparedStatement st1=con.prepareStatement("update Student set name=? where regno=?");  
	st1.setString(1,column);
	st1.setInt(2,num); 
	int i=st1.executeUpdate();    
	con.close();  
	return i;
}

public void StudentDisplay() throws ClassNotFoundException, SQLException
{
	System.out.println("The student details  are as follows ");
	Connection con=DBUtil.DBConnection();
	PreparedStatement st1=con.prepareStatement("Select * from Student");  
	ResultSet rs=st1.executeQuery();  
	System.out.println("REGNO\t\tNAME\t\tEMAILID");	
	while(rs.next()){  
	System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3));  
	}  
	
	con.close();  
}
}
