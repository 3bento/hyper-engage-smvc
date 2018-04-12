package com.kennycode.hyperengagesmvc.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kennycode.hyperengagesmvc.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByFirstName(String firstName);
	List<User> findByLastName(String lastName);
	List<User> findByEmail(String email);
}
