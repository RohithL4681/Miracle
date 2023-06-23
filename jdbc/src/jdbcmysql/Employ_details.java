package jdbcmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Employ_details {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter No.Of employees : ");
		int n=sc1.nextInt();
		
		
		for(int i=0;i<n;i++) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter employ details");
		System.out.println("Enter first name: ");
		String fn=sc.nextLine();
		System.out.println("Enter last name: ");
		String ln=sc.nextLine();
		System.out.println("Enter role: ");
		String er=sc.nextLine();
		System.out.println("Enter phone number: ");
		long ph=sc.nextLong();
		System.out.println("Enter id");
		int id=sc.nextInt();
		
		
		
		String e=fn.substring(0,1)+ln.substring(0)+"@miraclesoft.com";
		String u=fn.substring(0,1)+ln.substring(0);
		
        // load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		// establish connection
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/miracle","root","M1racle@123");
		// prepared statement 
		PreparedStatement ps=c.prepareStatement("insert into employ values(?,?,?,?,?,?,?,?)");
		ps.setInt(1, id);
		ps.setString(2,fn);
		ps.setString(3, ln);
		ps.setString(4,er);
		ps.setLong(5,ph);
		ps.setString(6, e);
		ps.setString(7, u);
		String st=Long.toString(ph);
		String p=fn.substring(0,2)+ln.substring(0,2)+st.substring(5);
		ps.setString(8, p);
		
//		PreparedStatement ps=c.prepareStatement("delete from employ where emp_id>2 ");
		
       	ps.executeUpdate();

		// close the connection
		c.close();
		}
		
		System.out.println("Done");
		
	}

}
