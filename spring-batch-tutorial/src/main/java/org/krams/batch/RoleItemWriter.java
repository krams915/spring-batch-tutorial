package org.krams.batch;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.krams.domain.Role;
import org.krams.domain.User;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class RoleItemWriter implements ItemWriter<Role> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static final String SELECT_QUERY = "select id," +
			"firstName, " +
			"lastName, " +
			"password, " +
			"username " +
			"from user where username = ?";

	public static final String INSERT_QUERY = "insert into role(role, " +
			"user_id) " +
			"values(?,?);";

	@Override
	public void write(List<? extends Role> roles) {

		for (Role role : roles) {

			Object[] params = new Object[1];
			params[0] = role.getUser().getUsername();
			User user = jdbcTemplate.queryForObject(SELECT_QUERY, params, new RowMapper<User>() {

				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User user  = new User();
					user.setId(rs.getLong("id"));
					user.setFirstName(rs.getString("firstName"));
					user.setLastName(rs.getString("lastName"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					
					return user;
				}
			});
			jdbcTemplate.update(INSERT_QUERY, role.getRole(), user.getId());
		}

	}

}