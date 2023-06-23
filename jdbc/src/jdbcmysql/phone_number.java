package jdbcmysql;

import java.sql.*;
import java.util.Scanner;

public class phone_number {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc9=new Scanner(System.in);
		System.out.println("Enter name: ");
		String st=sc9.nextLine();
		System.out.println("Enter phone number: ");
		long ph=sc9.nextLong();
		System.out.println("Enter id");
		int id=sc9.nextInt();
		System.out.println("Enter age: ");
		int age=sc9.nextInt();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/miracle","root","M1racle@123");
		PreparedStatement ps=c.prepareStatement("insert into info values(?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, st);
		ps.setInt(3, age);
		String str=Long.toString(ph);
		str="+91 "+str;
		ps.setString(4, str);
		int result=ps.executeUpdate("delete from emp765 where id=33");  
		System.out.println(result+" records affected");  
		System.out.println("Done");
		
	}

}
