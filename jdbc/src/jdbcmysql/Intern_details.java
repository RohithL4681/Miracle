package jdbcmysql;

import java.sql.*;
import java.util.Scanner;

class Server{
	 void insert(String role, Connection c) throws SQLException {
		if(role.equals("hr") || role.equals("hr1")) {
			try (Scanner sc = new Scanner(System.in)) {
				System.out.println("Enter employ details");
				System.out.println("Enter first name: ");
				String fn=sc.nextLine();
				System.out.println("Enter last name: ");
				String ln=sc.nextLine();
				System.out.println("Enter employ id: ");
				int id=sc.nextInt();
				String e=fn.substring(0,1)+ln+"@miraclesoft.com";
				String u=fn.substring(0,1)+ln;
				String p=fn.substring(0,2)+ln.substring(0,2)+"99595";
				
				PreparedStatement ps1=c.prepareStatement("insert into emp values(?,?,?,?,?,?,?) ");
				ps1.setInt(1, id);
				ps1.setString(2,fn);
				ps1.setString(3, ln);
				ps1.setString(4, u);
				ps1.setString(5,p);
				ps1.setString(6, e);
				ps1.setString(7, role);
				ps1.executeUpdate();
			}
		}
	}

	public void update(String role,Connection c,Object sc) throws SQLException {
		System.out.println("hii");
		
		if(role.equals("hr") || role.equals("hr1")) {
		try (Scanner sc1 = new Scanner(System.in)) {
			System.out.println("Enter which field to update: ");
			System.out.println("emp_id 	firstname  lastname  password  email ");
			String update=sc1.nextLine();
			System.out.println("Enter value: ");
			String value=sc1.nextLine();
			System.out.println("Enter id: ");
			int id=sc1.nextInt();
			PreparedStatement ps=c.prepareStatement("update  emp set "+update+" ='"+value+"' where emp_id=? ");
			System.out.println("hii");
//		String a="update table  emp set "+update+" ='"+value+"' where id=? ";
//		System.out.println(a);
			ps.setInt(1, id);
			ps.executeUpdate();
		}	
	}
	}
	void delete(String role,Connection c) throws SQLException {
		if(role.equals("hr") || role.equals("hr1")) {
		System.out.println("Enter emp name: ");
		try (Scanner sc2 = new Scanner(System.in)) {
			String delete=sc2.nextLine();
			PreparedStatement ps=c.prepareStatement("delete from emp where firstname='"+delete+"'");
			ps.executeUpdate();
		}
	}}
	void view(String role,Connection c,String name) throws SQLException {
		if(role.startsWith("hr")||role.startsWith("trainer")) {
		if(role.startsWith("hr") ){
			try (Scanner sc3 = new Scanner(System.in)) {
				System.out.println("1.personal details   2.employ details");
				int choice=sc3.nextInt();
				if(choice==1) {
				PreparedStatement ps1=c.prepareStatement("select * from team where name=?");	
				ps1.setString(1, name);
				ResultSet rs=ps1.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" " +rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" " +rs.getLong(5)+" "+rs.getString(6));
				}
				}else if(choice==2) {
					PreparedStatement ps2=c.prepareStatement("select * from emp where add_by=?");	
					ps2.setString(1, role);
					ResultSet rs=ps2.executeQuery();
					ResultSetMetaData rm = rs.getMetaData();
					int count = rm.getColumnCount();
					for(int i = 1; i<=count; i++) {
						   System.out.print(rm.getColumnName(i)+"   ");
						}
						System.out.println();
				    while(rs.next()) {
				    	System.out.println(rs.getInt(1)+" " +rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" " +rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
				    }
				}
			}
		}
		else {
			System.out.println("Enter employ id: ");
			try (Scanner sc3 = new Scanner(System.in)) {
				int id=sc3.nextInt();
				PreparedStatement ps3=c.prepareStatement("select * from emp where emp_id=?");	
				ps3.setInt(1,id);
				ResultSet rs=ps3.executeQuery();
				ResultSetMetaData rm = rs.getMetaData();
				int count = rm.getColumnCount();
				for(int i = 1; i<=count; i++) {
					   System.out.print(rm.getColumnName(i)+"   ");
					}
					System.out.println();
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" " +rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" " +rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
				}
			}
		}
		
	}else {
		System.out.println("Enter your name: ");
		try (Scanner sc4 = new Scanner(System.in)) {
			String namee=sc4.nextLine();
			PreparedStatement ps3=c.prepareStatement("select * from emp where firstname=?");	
			ps3.setString(1,namee);
			ResultSet rs=ps3.executeQuery();
			ResultSetMetaData rm = rs.getMetaData();
			int count = rm.getColumnCount();
			for(int i = 1; i<=count; i++) {
				   System.out.print(rm.getColumnName(i)+"   ");
				}
				System.out.println();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" " +rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" " +rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
			}
		}
	}
		
	}
}
public class Intern_details {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Server s=new Server();
		String name ="",password,role="";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/miracle","root","M1racle@123");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter user name: ");
		String nam=sc.nextLine();
		System.out.println("Enter password: ");
		String pass=sc.nextLine();
		
		PreparedStatement ps=c.prepareStatement("select * from team where name =?");
		ps.setString(1, nam);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			name=rs.getString(2);
			role=rs.getString(3);
			password=rs.getString(4);
		}
		System.out.println("Enter your choice: ");
		System.out.println("1. insert ");
		System.out.println("2. update ");
		System.out.println("3. delete ");
		System.out.println("4. view ");
		System.out.println("5. exit ");
		int choice=sc.nextInt();
		switch(choice) {
		
		case 1:
			 s.insert(role,c);
			break;
		case 2:
			s.update(role,c, choice);
			break;
		case 3:
			s.delete(role,c);
			break;
		case 4:
			s.view(role,c,name);
			break;
		case 5:
			break;
			
		}
		
		

	}

}
