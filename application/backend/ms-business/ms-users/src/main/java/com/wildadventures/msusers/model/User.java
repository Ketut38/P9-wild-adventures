package com.wildadventures.msusers.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name="user")
@Getter
@Setter
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;	
	
	
	@Column(name="first_name")
	@NotNull
	private String firstName;
	
	@Column(name="last_name")
	@NotNull
	private String lastName;

	@Column(name="username")
	@NotNull
	private String userName;

	@Column(name="gender")
	@NotNull
	private String gender;

	@Column(name="email")
	@NotNull
	private String email;

	@Column(name="password")
	@NotNull
	private String password;

	@Column(name="phone_number")
	@NotNull
	private String phoneNumber;

	@Column(name="date_created")
	@NotNull
	private Date dateCreated;
	
	@Column(name="date_updated")
	@NotNull
	private Date dateUpdated;

	@Column(name="firstName")
	@NotNull
	private String imageUrl;
	



}
