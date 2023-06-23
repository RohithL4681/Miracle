package jdbcmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
class Bank{
	long account,withdraw,password;
	long balance,deposit;
	long recipient_balance;
	int cnt=1;
	void atm() throws ArithmeticException, ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/miracle","root","M1racle@123");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter account number: ");
		long acc=sc.nextLong();
		sc.nextLine();
		System.out.println("Enter Password: ");
		long  pass=sc.nextLong();
		PreparedStatement ps=c.prepareStatement("select * from Bank_server where Account_number ='"+acc+"' and password ='"+pass+"'");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			account=rs.getLong(1);
			password=rs.getLong(2);
			balance=rs.getLong(3);
		}
		while(cnt<3) {
		if(account==acc  && password== pass) {
		System.out.println("       WELCOME       ");
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter your choice :");
		System.out.println("1.Deposit.");
		System.out.println("2.Withdraw.");
		System.out.println("3.Balance Enquiry.");
		System.out.println("4.Account transfer.");
		System.out.println("5.Exit.");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter deposit money ");
			deposit=sc.nextInt();
			if(deposit<500) {
				System.out.println("please enter above 500");
				throw new ArithmeticException("invalid input");
			}else {
				balance=balance+deposit;
				System.out.println("Account balance "+balance);
	PreparedStatement ps1=c.prepareStatement("update Bank_server set Balance=? where Account_number=?");
	ps1.setLong(1, balance);
	ps1.setLong(2, account);
    ps1.executeUpdate();
    System.out.println("Account balance "+balance);
    System.exit(0);
				break;
			}
		case 2:
			System.out.println("Enter  withdraw amount: ");
			withdraw=sc.nextInt();
			if(withdraw>balance) {
				System.out.println("Insufficient balance ");
				throw new ArithmeticException("invalid input1");
			}else {
				System.out.println("please collect your money ");
				balance=balance-withdraw;
				PreparedStatement ps1=c.prepareStatement("update Bank_server set Balance=? where Account_number=?");
				ps1.setLong(1, balance);
				ps1.setLong(2, account);
			    ps1.executeUpdate();
				System.out.println("Account balance "+balance);
				 System.exit(0);
			}
			break;
		case 3:
				System.out.println("Account balance "+balance);
				
			break;
		case 4:
			System.out.println("enter receiver Account number ");
			long recipient_account_number=sc.nextLong();
			PreparedStatement ps1=c.prepareStatement("select * from Bank_server where Account_number ='"+recipient_account_number+"'");
		    ps1.executeQuery();
		    ResultSet  rs1=ps1.executeQuery();
		    while(rs1.next()) {
			recipient_balance=rs1.getLong(3);	
		    }
		    System.out.println("Enter transfer amount: ");
		    long transfer_amount =sc.nextLong();
		    if(balance>transfer_amount) {
			balance=balance-transfer_amount;
			PreparedStatement ps2=c.prepareStatement("update Bank_server set Balance=? where Account_number="+account+" ");
			ps2.setLong(1, balance);
		    ps2.executeUpdate();
		    recipient_balance=recipient_balance+transfer_amount;
		    PreparedStatement ps3=c.prepareStatement("update Bank_server set Balance=? where Account_number=?");
			ps3.setLong(1, recipient_balance);
			ps3.setLong(2, recipient_account_number);
		    ps3.executeUpdate();
		    System.out.println(transfer_amount+" Debited from your account ");
		    System.out.println("Aval balance Rs:"+balance);
		    System.out.println();
		    System.exit(0);
		    }
		    else {
		    	System.out.println("Insufficient funds");
		    }
			break;
		case 5:
			System.out.println("Thanks for the visiting");
			System.exit(0);
		default:
			System.out.println("Please choose below options ");
			atm();
		}
		}
		else {
			cnt++;
			System.out.println("Incorrect credentials");
			atm();
		}
		}	
	
if(cnt==3) {
	System.exit(0);
}}
	
	
}	
public class Bank__operation {

	public static void main(String[] args) throws ArithmeticException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Bank b=new Bank();
		b.atm();

	}

}



















































































































//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//
//class Bank{
//	void atm() throws ArithmeticException, ClassNotFoundException, SQLException {
//		 Class.forName("com.mysql.cj.jdbc.Driver");
//	     System.out.println("hii");
//	     Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/miracle","root","M1racle@123");
//	     System.out.println("hii");
//	     
//		int dp,wd,bal=3000;
//		String s=" ";
//		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter your choice :");
//		System.out.println("1.Deposit.");
//		System.out.println("2.Withdraw.");
//		System.out.println("3.Balance Enquiry.");
//		System.out.println("4.Exit.");
//		int choice=sc.nextInt();
//		switch(choice) {
//		case 1:
//			System.out.println("Enter deposit money ");
//			dp=sc.nextInt();
//			if(dp<500) {
//				System.out.println("please enter above 500");
//				throw new ArithmeticException("invalid input");
//			}else {
//				bal=bal+dp;
//				System.out.println("Account balance "+bal);
//				break;
//			}
//		case 2:
//			System.out.println("Enter  money ");
//			wd=sc.nextInt();
//			if(wd>bal) {
//				System.out.println("Insufficient balance ");
//				throw new ArithmeticException("invalid input1");
//			}else {
//				System.out.println("please collect your money ");
//				bal=bal-wd;
//				System.out.println("Account balance "+bal);
//			}
//			break;
//		case 3:
//			String s1="4681";
//			Scanner sc1=new Scanner(System.in);
//			System.out.println("Enter pin ");
//			s=sc1.nextLine();
//			if(s.equals(s1)) {
//				System.out.println("Account balance "+bal);
//			}else {
//				System.out.println("Wrong pin");
//				throw new ArithmeticException("invalid input");
//			}
//			break;
//		case 4:
//			System.out.println("Thanks for the visiting");
//			System.exit(0);
//		default:
//			System.out.println("Please choose below options ");
//			atm();
//			
//		}
//		
//	}
//}
//public class Bank__operation {
//
//	public static void main(String[] args)  {
//		// TODO Auto-generated method stub
//		Bank b=new Bank();
//		b.atm();
//    
//	}
//
//	
//}
