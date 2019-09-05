package com.bridgelab.loginregistration.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bridgelab.loginregistration.model.ForgetPassword;
import com.bridgelab.loginregistration.model.LoginDetail;
import com.bridgelab.loginregistration.model.RegistrationDetail;
import com.bridgelab.loginregistration.service.UserServiceImpl;

public class UserServiceDao {

	@Autowired
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int doregistration(RegistrationDetail detail) {
		String genetaredPassword=UserServiceImpl.getSecurePassword(detail.getPassword());
		String sql = "insert into users(username,password,email,address,mobileno) values ('" + detail.getUsername()
				+ "','" + genetaredPassword + "','" + detail.getEmail() + "','" + detail.getAddress() + "','"
				+ detail.getMobileno() + "')";
		int execute = template.update(sql);
		return execute;
	}

	public RegistrationDetail dologin(LoginDetail login) {
		String sql = "select * from users where email = '" + login.getEmail() + "'and password='" + login.getPassword()
				+ "'";
		List<RegistrationDetail> register = template.query(sql, new UserMapper());

		System.out.println(register);
		return register.size() > 0 ? register.get(0) : null;

	}

	class UserMapper implements RowMapper<RegistrationDetail> {
		@Override
		public RegistrationDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
			RegistrationDetail detail = new RegistrationDetail();
			detail.setUsername(rs.getString("username"));
			detail.setPassword(rs.getString("password"));
			detail.setEmail(rs.getString("email"));
			detail.setAddress(rs.getString("address"));
			detail.setMobileno(rs.getString("mobileno"));
			return detail;
		}
	}

	public int checkEmail(String email) {
		System.out.println("inside sendpassword" + email);
		String sql = "select * from users where email = '" + email + "'";
		List<ForgetPassword> forgetPas = template.query(sql, new UserMapper1());
		System.out.println("after query execution");
		System.out.println(forgetPas.size());
		if (forgetPas.size() > 0) {
			return 1;
		} else {
			return 0;
		}
	}
	class UserMapper1 implements RowMapper<ForgetPassword>
	{

		@Override
		public ForgetPassword mapRow(ResultSet rs, int rowNum) throws SQLException {
			ForgetPassword forget =new ForgetPassword();
			forget.setEmailid(rs.getString("email"));
			return forget;
		}
		
	}
	

	public void setpasswordtodatabase(String password, String email) {
		String sql = "update users set password=? where email =?";
		int n = template.update(sql, password, email);
	}

}
