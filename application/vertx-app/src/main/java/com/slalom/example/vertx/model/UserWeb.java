package com.slalom.example.vertx.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.slalom.example.core.entity.User;
import io.vertx.core.json.JsonObject;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserWeb {
	private String id;
	private String email;
	private String password;
	private String lastName;
	private String firstName;

	public UserWeb() {
	}

	public UserWeb(final JsonObject jsonObject) {
		this.id = jsonObject.getString("id");
		this.email = jsonObject.getString("email");
		this.password = jsonObject.getString("password");
		this.lastName = jsonObject.getString("lastName");
		this.firstName = jsonObject.getString("firstName");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public User toUser() {
		return User.builder()
			.email(email)
			.password(password)
			.lastName(lastName)
			.firstName(firstName)
			.build();
	}

	public static UserWeb toUserWeb(final User user) {
		var userWeb = new UserWeb();
		userWeb.setId(user.getId());
		userWeb.setEmail(user.getEmail());
		// do not map password
		userWeb.setLastName(user.getLastName());
		userWeb.setFirstName(user.getFirstName());
		return userWeb;
	}
}
