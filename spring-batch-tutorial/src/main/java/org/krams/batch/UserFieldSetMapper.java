package org.krams.batch;

import org.krams.domain.User;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

public class UserFieldSetMapper implements FieldSetMapper<User> {
	
	@Override
	public User mapFieldSet(FieldSet fs) {
		
		if(fs == null){
			return null;
		}
		
		User user = new User();
		user.setUsername(fs.readString("username"));
		user.setPassword(fs.readString("password"));
		user.setLastName(fs.readString("lastName"));
		user.setFirstName(fs.readString("firstName"));
		
		return user;
	}
	
}