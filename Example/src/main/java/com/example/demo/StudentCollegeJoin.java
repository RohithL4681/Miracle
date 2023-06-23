package com.example.demo;

import java.sql.*;

public class StudentCollegeJoin {
    public static void main(String[] args) {
        try {
           

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/miracle", "root","M1racle@123");

            // Step 2: Execute the join query
            String sql = "SELECT s.*, c.fullname FROM User s " +
                         "JOIN Profile c ON s.User_id = c.User_id";

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 3: Process the result
            while (resultSet.next()) {
                // Retrieve data from the joined result set
                int user_Id = resultSet.getInt("user_id");
                String UserName = resultSet.getString("UserName");
                String Password = resultSet.getString("Password");
                String Email = resultSet.getString("Email");

                String Role = resultSet.getString("Role");
                String fullname = resultSet.getString("fullname");

                // Process the retrieved data
                System.out.println("userid: " + user_Id);
                System.out.println("user Name: " +UserName  );
                System.out.println("password: " + Password);
                System.out.println("email: " +Email );
                System.out.println("role: " + Role );
                System.out.println("fullname: " + fullname);
                System.out.println("-----------------------------");
            }

            // Step 4: Close resources
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}