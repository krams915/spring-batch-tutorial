package org.krams.batch;

import org.krams.domain.User;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

public class MultiUserFieldSetMapper implements FieldSetMapper<User> {
	
	@Override
	public User mapFieldSet(FieldSet fs) {
		
		if(fs == null){
			return null;
		}
		
		User user = new User();
		user.setUsername(removePrefix(fs.readString("username")));
		user.setPassword(fs.readString("password"));
		user.setLastName(fs.readString("lastName"));
		user.setFirstName(fs.readString("firstName"));
		
		return user;
	}
	
	private String removePrefix(String token) {
		String[] tokens = token.split(";");
		if (tokens.length == 2) {
			return tokens[1];
		}
		return token;
	}
}