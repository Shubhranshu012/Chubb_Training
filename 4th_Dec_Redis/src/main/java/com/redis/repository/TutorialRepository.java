package com.redis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.redis.model.Tutorial;

import java.util.List;

@Repository
public interface TutorialRepository extends MongoRepository<Tutorial, String> {

    List<Tutorial> findByPublished(boolean published);

    List<Tutorial> findByTitleContaining(String title);
}