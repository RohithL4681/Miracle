package jdbcmysql;

import java.sql.*;

public class Result_set {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/miracle","root","M1racle@123");
       PreparedStatement ps=c.prepareStatement("select* from student");
    
        ResultSet rs=ps.executeQuery();
        while(rs.next()) {
        	System.out.println(rs.getInt(1)+" " +rs.getString(2)+" "+rs.getInt(3));
        }
        
        
	}

}
