package jdbcmysql;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class New_Bank_Account_user {

	

		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			
			try (Scanner sc = new Scanner(System.in)) {
				System.out.println("Enter email: ");
				String email=sc.nextLine();
				System.out.println("Enter password: ");
				long passwrd=sc.nextLong();
				System.out.println("Enter Account number: ");
				long acc_no=sc.nextLong();
				System.out.println("Enter Account Balance: ");
				long balance=sc.nextLong();

				// TODO Auto-generated method stub
				//load the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				//establish connection
Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/miracle","root","M1racle@123");
//PreparedStatement ps=c.prepareStatement("insert into Bank_server values(?,?,?,?)");
//ps.setLong(1,acc_no);
//ps.setLong(2,passwrd);
//ps.setLong(3, balance);
//ps.setString(4, email);
//PreparedStatement ps=c.prepareStatement("delete from Bank_server");
PreparedStatement ps=c.prepareStatement("update Bank_server set Balance=9999 where Account_number=036910100044144");

ps.executeUpdate();
System.out.println("Done");
			}
		
		}
}