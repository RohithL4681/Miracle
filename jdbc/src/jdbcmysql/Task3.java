//package jdbcmysql;
//import java.sql.Connection;
//import java.util.*;
//import java.sql.*;
//public class Task3{
//void dileep() throws Exception {
//System.out.println("Enter Data");
//Scanner sc=new Scanner(System.in);
//int id =sc.nextInt();
//String fn =sc.nextLine();
//String ln=sc.nextLine();
//String un=sc.nextLine();
//String password=sc.nextLine();
//String gmail=sc.nextLine();
//String Addby=sc.nextLine();
//String NName;
//String desig;
//Class.forName("com.mysql.cj.jdbc.Driver");
//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Miracle","root","M1racle@123");
//System.out.println("enter your name:");
//String name=sc.nextLine();
//PreparedStatement ps=con.prepareStatement("select * from team where name=?");
//ps.setString(1, name);
//ResultSet rs=ps.executeQuery();
//while(rs.next()) {
//NName=rs.getString(3);
//desig=rs.getString(2);
//}
//while(name.equals(NName)) {
//if(desig.equals("Hr")) {
//System.out.println("1 insert");
//System.out.println("2 delete");
//System.out.println("3 update");
//System.out.println("4 view");
//System.out.println("5 exit");
//System.out.print("Enter your choice between 1 to 4");
//int choice=sc.nextInt();
//switch(choice) {
//case 1:
//System.out.println("inserting the values into the table:");
//PreparedStatement ps1=con.prepareStatement("insert into employeess values(?,?,?,?,?,?,?)");
//ps1.setInt(1, id);
//ps1.setString(2, fn);
//ps1.setString(3, ln);
//ps1.setString(4, un);
//ps1.setString(5, password);
//ps1.setString(6, gmail);
//ps1.setString(7, Addby);
//ps1.executeUpdate();
//break;
//case 2:
//	System.out.println("deleting the values from the table:");
//	PreparedStatement ps2=con.prepareStatement("delete from employeess where id=4");
//	ps2.executeUpdate();
//	break;
//case 3:
//	System.out.println("updating the values of the table:");
//	PreparedStatement ps3=con.prepareStatement("UPDATE employeess SET fn = 'sriram', WHERE id = 1");
//	ps3.executeUpdate();
//	break;
//case 4:
//	System.out.println("viewing the values of the table:");
//	PreparedStatement ps4=con.prepareStatement("select * from employeess Where Addby=Hr");
//	ps4.executeUpdate();
//}
//}
//else {
//	System.out.println("denied access");
//}
//}
//}
//public static void main(String args[]) throws Exception {
//	Task3 u=new Task3();
//	u.dileep();
//	
//}
//}
//
