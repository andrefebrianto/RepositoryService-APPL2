package com.auditory.RepositoryService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auditory.RepositoryService.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
	
}
