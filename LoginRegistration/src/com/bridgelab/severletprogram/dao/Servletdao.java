package com.bridgelab.severletprogram.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;

import com.bridgelab.severletprogram.model.UserDetails;

public class Servletdao {
	UserDetails details = new UserDetails();

	public boolean dologin(UserDetails user)
			throws ServletException, IOException, SQLException, ClassNotFoundException {
		boolean test = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "1015");
			String Username = user.getUsername();
			String Password = user.getPassword();
			System.out.println("Username : " + Username + ", Password : " + Password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from userdetails");
			while (rs.next()) {
				if (Username.equals(rs.getString(1)) && Password.equals(rs.getString(2)))
				{
					System.out.println(rs.getString(1) + "" + rs.getString(2));
					test = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return test;
	}

	public int doregistratin(UserDetails users) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "1015");
		String sql = "insert into userdetails values(?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, users.getUsername());
		ps.setString(2, users.getPassword());
		ps.setString(3, users.getFirstname());
		ps.setString(4, users.getLastname());
		ps.setString(5, users.getEmail());
		ps.setString(6, users.getMobileno());
		int set = ps.executeUpdate();
		if (set > 0) {
			System.out.println("done ");
		}
		return set;

	}
}
