package com.sj.bookclub.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sj.bookclub.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{

	Optional<User> findByEmail(String email);
}
