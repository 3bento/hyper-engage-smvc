package com.kennycode.hyperengagesmvc.irepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kennycode.hyperengagesmvc.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findFirstByUsername(String username);
	User findFirstByEmail(String email);
	List<User> findByFirstName(String firstName);
	List<User> findByLastName(String lastName);
	List<User> findByEmail(String email);
}
