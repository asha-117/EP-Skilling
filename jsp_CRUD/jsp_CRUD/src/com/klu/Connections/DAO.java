package com.klu.Connections;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.klu.Bean.Bean;

public class DAO {
	public int insert(Bean b) throws ClassNotFoundException, SQLException {
        Connection con=DBUtil.DBConnection();
        String sql="insert into employee values(?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, b.getName());
        ps.setString(2, b.getPassword());
        ps.setString(3, b.getEmail());
        ps.setString(4, b.getCountry());
       int i=ps.executeUpdate();
        return i;
}
	public int update(Bean b,String oldname)throws ClassNotFoundException, SQLException{  
	    	Connection con=DBUtil.DBConnection();  
	        PreparedStatement ps=con.prepareStatement("update employee set name=?,password=?,email=?,country=? where name=?");  
	        ps.setString(1,b.getName());  
	        ps.setString(2,b.getPassword());  
	        ps.setString(3,b.getEmail());  
	        ps.setString(4,b.getCountry());  
	        ps.setString(5, oldname);
	        int i=ps.executeUpdate();
	    return i;  
	
}
	public static int delete(Bean b)throws ClassNotFoundException, SQLException{
		Connection con=DBUtil.DBConnection();
		PreparedStatement ps=con.prepareStatement(" delete from employee where name=?");  
		ps.setString(1,b.getName()); 
		int j=ps.executeUpdate();
		return j;
		
	
	}
}




