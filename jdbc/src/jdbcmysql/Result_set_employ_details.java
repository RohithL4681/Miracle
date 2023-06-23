package jdbcmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import java.sql.ResultSetMetaData;

public class Result_set_employ_details {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter first name: ");
			String fn=sc.nextLine();
			System.out.println("Enter last name: ");
			String ln=sc.nextLine();
			System.out.println("Enter user name: ");
			String un=sc.nextLine();
			
			
			// load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// establish connection
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/miracle","root","M1racle@123");
			// prepared statement 
//	String r="select * from employ where (emp_firstname like '"+fn+"%' and emp_lastname like '"+ln+"%' and user_name like '"+un+"%' )" ;
			String r="select * from employ where emp_firstname='"+fn+"' and emp_lastname='"+ln+"' and user_name='"+un+"' " ;

			System.out.println(r);
			System.out.println();
			PreparedStatement ps=c.prepareStatement(r);		
			
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rm = rs.getMetaData();
			System.out.println(rm.getColumnCount());
			System.out.println(rm.getColumnType(2));
			int count = rm.getColumnCount();
			for(int i = 1; i<=count; i++) {
			   System.out.print(rm.getColumnName(i)+"         ");
			}
			System.out.println();
			while(rs.next()) {
			System.out.println(rs.getInt(1)+"              "+rs.getString(2)+"                "+rs.getString(3)+"                "+rs.getString(4)+"           "+rs.getLong(5)+"       "+rs.getString(6)+"     "+rs.getString(7)+"    "+rs.getString(8));
			}
			// close the connection
			c.close();
		}
		System.out.println("Done");
		
	}

}
