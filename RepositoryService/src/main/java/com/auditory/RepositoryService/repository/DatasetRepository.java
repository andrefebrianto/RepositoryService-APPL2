package com.auditory.RepositoryService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auditory.RepositoryService.model.Dataset;

public interface DatasetRepository extends JpaRepository<Dataset, Long> {
	public List<Dataset> findByName(String name);
}
