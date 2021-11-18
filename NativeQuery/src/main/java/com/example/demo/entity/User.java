package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity(name = "User")
@Table(name = "user_tb")
public class User {
	@Id
	@GeneratedValue
	private Long user_id;
	private String name;
}
