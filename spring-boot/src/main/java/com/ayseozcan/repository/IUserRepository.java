package com.ayseozcan.repository;

import com.ayseozcan.repository.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends MongoRepository<User, String> {
    Optional<User> findOptionalByUsernameIgnoreCase(String username);

    Optional<User> findOptionalByUsernameIgnoreCaseAndPassword(String username, String password);
}
