package jdbcmysql;

import java.sql.*;
import java.util.*;

public class Result_set_without_like_operator {
public static void main(String[] args) throws Exception{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/miracle","root","M1racle@123");
	PreparedStatement ps=con.prepareStatement("select * from employ");
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter the first name:");
	String fn=sc.nextLine();
	System.out.print("Enter the last name:");
	String ln=sc.nextLine();
	System.out.print("Enter the user name:");
	String un=sc.nextLine();
	ResultSet rs=ps.executeQuery();
	ResultSetMetaData rm = rs.getMetaData();
	int count = rm.getColumnCount();
	for(int i = 1; i<=count; i++) {
		   System.out.print(rm.getColumnName(i)+"         ");
		}
	while(rs.next()) {
		if((rs.getString(2)).startsWith(fn) && (rs.getString(3)).startsWith(ln) && (rs.getString(7)).startsWith(un)){
			System.out.println();
			System.out.print(rs.getInt(1)+"              "+rs.getString(2)+"                "+rs.getString(3)+"                "+rs.getString(4)+"           "+rs.getString(5)+"   "+rs.getString(6)+"    "+rs.getString(7)+"   "+rs.getString(8));
			
			}
		}
	}
}