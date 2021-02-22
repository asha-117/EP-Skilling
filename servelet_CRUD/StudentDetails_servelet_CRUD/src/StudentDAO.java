import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



//CRUD OPERATIONS
public class StudentDAO {

	public int StudentInsert(StudentBean sb)throws ClassNotFoundException, SQLException {
		Connection con=DBUtil.DBConnection();
		String sql="insert  into studentdetails values(?,?)";
		PreparedStatement ps=con.prepareStatement(sql); 
		ps.setInt(1, sb.getRegno());
		ps.setString(2, sb.getName());
		int i=ps.executeUpdate();    
		con.close();  
		return i;
		
	}
	public int StudentUpdate(StudentBean sb)throws ClassNotFoundException, SQLException {
		Connection con=DBUtil.DBConnection();
		String sql="update studentdetails set name=? where regno=?";
		PreparedStatement ps=con.prepareStatement(sql); 
		ps.setString(1, sb.getName());
		ps.setInt(2, sb.getRegno());
		int i=ps.executeUpdate();    
		con.close();  
		return i;
		
	}
	public int StudentDelete(StudentBean sb)throws ClassNotFoundException, SQLException {
		Connection con=DBUtil.DBConnection();
		String sql="delete from studentdetails where regno=?";
		PreparedStatement ps=con.prepareStatement(sql); 
		ps.setInt(1, sb.getRegno());
		int i=ps.executeUpdate();    
		con.close();  
		return i;
}
}
