package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
  List<Tag> findTagsByTutorialsId(Long tutorialId);
}