package jdbcmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class dem {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int n=sc.nextInt();
		int m=sc.nextInt();
	
		// TODO Auto-generated method stub
		//load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//establish connection
	Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/miracle","root","M1racle@123");
     //prepare statement
	PreparedStatement ps=c.prepareStatement("insert into student values(?,?,?)");
	ps.setInt(1,n);
	ps.setString(2,s);
	ps.setInt(3, m);
	
//	PreparedStatement ps=c.prepareStatement("delete from employ where emp_id>2 ");
//	PreparedStatement ps=c.prepareStatement("update table  employ set name="sai" where id=2 ");

	ps.executeUpdate();
	
	}

}

