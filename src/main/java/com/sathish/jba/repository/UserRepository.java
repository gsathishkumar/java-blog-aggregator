package com.sathish.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sathish.jba.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
