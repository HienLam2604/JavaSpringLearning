package com.example.JavaSpringLearning.jwt.repository;

import com.example.JavaSpringLearning.jwt.models.ERole;
import com.example.JavaSpringLearning.jwt.models.RoleModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<RoleModel,String> {
    Optional<RoleModel> findByName(ERole name);
}
