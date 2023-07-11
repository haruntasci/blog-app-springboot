package com.haruntasci.springbootangularcrud.repository;

import com.haruntasci.springbootangularcrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
