package com.login.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.model.Login;

@Repository

public interface LoginDao extends JpaRepository<Login, Long> {

	Optional<Login> findByEmail(String email);

}
