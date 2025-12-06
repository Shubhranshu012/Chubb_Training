package com.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.models.ERole;
import com.login.models.Role;

public interface RoleRepository extends JpaRepository<Role,Long>{
	Optional<Role> findByName(ERole name);
}
