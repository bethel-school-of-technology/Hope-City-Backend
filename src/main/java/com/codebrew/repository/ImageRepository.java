package com.codebrew.repository;

import java.util.Optional;

import com.codebrew.models.ImageModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {
    Optional<ImageModel> findByName(String name);
    
}