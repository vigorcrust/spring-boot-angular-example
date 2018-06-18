package de.adesso.dmartens.example.services;

import de.adesso.dmartens.example.entities.User;
import de.adesso.dmartens.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User save(User user) {
	    return userRepository.saveAndFlush(user);
	}

	public User update(User user) {
	    return userRepository.save(user);
	}

	public User find(String userName) {
	    return userRepository.findOneByUsername(userName);
	}

	public User find(Long id) {
	    return userRepository.findOne(id);
	}
}