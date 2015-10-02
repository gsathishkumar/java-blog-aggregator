package com.sathish.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sathish.jba.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String roleName);

}
