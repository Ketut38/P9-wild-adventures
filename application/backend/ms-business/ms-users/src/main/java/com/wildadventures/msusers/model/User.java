package com.wildadventures.msusers.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import javax.validation.constraints.NotNull;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class User {
	
	
	@Getter @Setter private String id;	
	
	private String firstName;
	

	private String lastName;


	@Getter @Setter private String userName;
	
	@Getter @Setter Map<String, Object> customAttributes = new HashMap<String, Object>();


	private String gender;


	private String email;

	private String password;


	private String phoneNumber;

	
	private Date dateCreated;
	
	
	private Date dateUpdated;


	private String imageUrl;
	



}
