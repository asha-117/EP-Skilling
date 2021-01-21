package com.klu.Main;

import java.sql.SQLException;
import java.util.Scanner;
import com.klu.Bean.StudentBean;
import com.klu.crudoperations.StudentCrud;

public class StudentMain {
public static void main(String args[]) throws Exception
{
	Scanner s=new Scanner(System.in);
	StudentBean sb=new StudentBean();
	StudentCrud si=new StudentCrud();
	while(true) {
	System.out.println("Select your CRUD opeartions");
	System.out.println("1.INSERTION");
	System.out.println("2.DELETION");
	System.out.println("3.UPDATE");
	System.out.println("4.DISPLAY");
	System.out.println("5.EXIT");
	int choice=s.nextInt();
	switch(choice) {
	  case 1:
		  System.out.println("Please enter the student details in the following order:REGNO,NAME,EMAIL");
		  int num=s.nextInt();
		  String name=s.next();
		  String email=s.next();
		    sb.setRegno(num);
			sb.setName(name);
			sb.setEmail(email);
		  int result_insertion=si.StudentInsert(sb);
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
		  int result_deletion=si.StudentDeletion();
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
		  int result_update=si.StudentUpdate();
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
		  si.StudentDisplay();
		  break;
	  case 5:
		  System.out.println("Thank you");
		  System.exit(0);;
	  default:
	    System.out.println(" Please enter a valid choice");
	}
	}
}
}
