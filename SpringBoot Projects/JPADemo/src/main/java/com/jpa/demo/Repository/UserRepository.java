package com.jpa.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}
