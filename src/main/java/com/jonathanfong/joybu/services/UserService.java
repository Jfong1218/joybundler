package com.jonathanfong.joybu.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.jonathanfong.joybu.models.LoginUser;
import com.jonathanfong.joybu.models.User;
import com.jonathanfong.joybu.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public User register(User newUser, BindingResult result) {
		//ToDo - Reject values or register if no errors:
		
		// Reject if email is taken (present in database)
		// 1. Find user in the DB by email
		Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
		// 2. if the email is present reject
		if (optionalUser.isPresent()) {
			result.rejectValue("email", "Unique", "The email is already registered");
		}
		
		// Reject if password does not match confirmation
		if (!newUser.getPassword().equals(newUser.getConfirm())){
			result.rejectValue("confirm", "Matches", "The Password and confirm passwod does not matche");
		}
			
		//Return null if result has errors
		if(result.hasErrors()) {
			return null;
		}
		
		//Hash and set password, save user to database
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser);
	}
	
	public User login(LoginUser newLogin, BindingResult result) {
		Optional<User> optionalUser = userRepo.findByEmail(newLogin.getEmail());
		// 2. if the email is NOT present reject
		if (!optionalUser.isPresent()) {
			result.rejectValue("email", "Unique", "The email is not registered");
			return null;
		}
		
		User user = optionalUser.get();
		
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Invalid Password!");
		}
		if (result.hasErrors()) {
			return null;
		}
		return user;
	}
}
