package com.klu.Main;
import java.sql.SQLException;
import java.util.Scanner;

import com.klu.Bean.HospitalBean;
import com.klu.HospitalCRUD.CRUD;
public class HospitalMain {
	public static void main(String args[]) throws Exception
	{
		Scanner s=new Scanner(System.in);
		HospitalBean hb=new HospitalBean();
		CRUD c=new CRUD();
		while(true) {
		System.out.println("Select your CRUD opeartions");
		System.out.println("1.INSERT");
		System.out.println("2.DELETE");
		System.out.println("3.UPDATE");
		System.out.println("4.DISPLAY");
		System.out.println("5.EXIT");
		int choice=s.nextInt();
		switch(choice) {
		  case 1:
			  System.out.println("Please enter the patient details in the following order:ADHAR-NUM,NAME,DOCTORTYPE,MOBILE-NUMBER,AGE");
			  System.out.println("Please select Doctor type from our available list:-");
			  System.out.println("1.Cardiologist\n2.Dentist\n3.ENT\n4.Gynaecologist\n5.Paediatrician");
			  int num=s.nextInt();
			  String name=s.next();
			  String dtype=s.next();
			  long mnum=s.nextLong();
			  int age=s.nextInt();
			    hb.setAdhar_Num(num);
				hb.setPatient_Name(name);
				hb.setDoctorType(dtype);
				hb.setPatient_Mobile(mnum);
				hb.setPatient_Age(age);
			  int result_insertion=c.PatientInsert(hb);
			  if(result_insertion>0)
			  {
				  System.out.println("Insertion successful");
			  }
			  else
			  {
				  System.out.println("Insertion unsuccessfull");
			  }
		    break;
		  case 2:
			  int result_deletion=c.PatientDeletion();
			  if(result_deletion>0)
			  {
				  System.out.println("Deletion successful");
			  }
			  else
			  {
				  System.out.println("Deletion unsuccessfull");
			  }
		    break;
		  case 3:
			  int result_update=c.PatientUpdate();
			  if(result_update>0)
			  {
				  System.out.println("Updation successful");
			  }
			  else
			  {
				  System.out.println("Updation unsuccessfull");
			  }
			  break;
		  case 4:
			  c.PatientDisplay();
			  break;
		  case 5:
			  System.out.println("THANK-YOU");
			  System.exit(0);;
		  default:
		    System.out.println(" Please enter a valid choice");
		}
		}
	}
}
