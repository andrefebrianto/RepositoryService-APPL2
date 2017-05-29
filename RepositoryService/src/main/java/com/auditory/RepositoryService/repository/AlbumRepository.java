package com.auditory.RepositoryService.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auditory.RepositoryService.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {
	public List<Album> findByName(String name);
	public List<Album> findByReleaseDate(Date releaseDate);
}
