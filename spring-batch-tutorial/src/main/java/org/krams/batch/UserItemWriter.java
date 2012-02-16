package org.krams.batch;

import java.util.List;

import org.krams.domain.User;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserItemWriter implements ItemWriter<User> {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static final String INSERT_QUERY = "insert into user(firstName, " +
			"lastName, " +
			"password, " +
			"username) " +
			"values(?,?,?,?);";
	
	@Override
	public void write(List<? extends User> users) throws Exception {
		for (User user : users) {
			jdbcTemplate.update(INSERT_QUERY, user.getFirstName(), user.getLastName(), user.getPassword(), user.getUsername());
		}
	}

}