package com.example.JavaSpringLearning.jwt.repository;

import com.example.JavaSpringLearning.jwt.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserModel, Long> {
    Optional<UserModel> findByUsername(String username);
    Boolean existsByUsername(String username);
}
