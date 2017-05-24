package com.auditory.RepositoryService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auditory.RepositoryService.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	public Category findByName(String categoryName);
}
