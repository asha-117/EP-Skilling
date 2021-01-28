package com.klu.HospitalCRUD;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.Scanner;

import com.klu.Bean.HospitalBean;
import com.klu.Connections.DBUtil;
public class CRUD {
		static Scanner s=new Scanner(System.in);
	public int PatientInsert(HospitalBean Patient) throws ClassNotFoundException, SQLException
	{
		System.out.println("Patient details are being inserted");
		Connection con=DBUtil.DBConnection();
		PreparedStatement st1=con.prepareStatement("insert into Patient values(?,?,?,?,?)"); 
		st1.setLong(1,Patient.getAdhar_Num());
		st1.setString(2,Patient.getPatient_Name());
		st1.setString(3,Patient.getDoctorType());
		st1.setLong(4,Patient.getPatient_Mobile());
		st1.setInt(5,Patient.getPatient_Age());
		int i=st1.executeUpdate();    
		con.close();  
		return i;
	}
	public int PatientDeletion() throws ClassNotFoundException, SQLException
	{
		System.out.println("Please enter the patient adhar number  of the patient to be deleted:");
		int num=s.nextInt();
		Connection con=DBUtil.DBConnection();
		PreparedStatement st1=con.prepareStatement(" delete from Patient where Adhar_Num=?");  
		st1.setInt(1,num);  
		int i=st1.executeUpdate();    
		con.close();  
		return i;
	}
	public int PatientUpdate() throws ClassNotFoundException, SQLException
	{
	   	
		System.out.println("Please enter the updated name and the patient adhar number ");
		String column=s.next();
		int num=s.nextInt();
		Connection con=DBUtil.DBConnection();
		PreparedStatement st1=con.prepareStatement("update Patient set Patient_Name=? where Adhar_Num=?");  
		st1.setString(1,column);
		st1.setInt(2,num); 
		int i=st1.executeUpdate();    
		con.close();  
		return i;
	}
 
	public void PatientDisplay() throws ClassNotFoundException, SQLException
	{
		System.out.println("The Patients  details  are as follows ");
		Connection con=DBUtil.DBConnection();
		PreparedStatement st1=con.prepareStatement("Select * from Patient");  
		ResultSet rs=st1.executeQuery();  
		while(rs.next()){  
		System.out.println(rs.getInt(1)+"----"+rs.getString(2)+"----"+rs.getString(3)+"----"+rs.getLong(4)+"----"+rs.getInt(5));  
		}  
		
		con.close();  
	}
	
}
