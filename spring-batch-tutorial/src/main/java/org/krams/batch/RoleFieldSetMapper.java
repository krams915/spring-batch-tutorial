package org.krams.batch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.krams.domain.Role;
import org.krams.domain.User;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class RoleFieldSetMapper implements FieldSetMapper<Role> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static final String SELECT_QUERY = "select id, " +
	"firstName, " +
	"lastName, " +
	"password, " +
	"username " +
	"from user where username = ?";
	
	@Override
	public Role mapFieldSet(FieldSet fs) {
		
		if(fs == null){
			return null;
		}
		
		Role role = new Role();
		
		Object[] params = new Object[1];
		params[0] = fs.readString("username");
		
		role.setUser(jdbcTemplate.queryForObject(SELECT_QUERY, params, new RowMapper<User>() {

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
		}));
		role.setRole(fs.readInt("role"));
		
		return role;
	}

}