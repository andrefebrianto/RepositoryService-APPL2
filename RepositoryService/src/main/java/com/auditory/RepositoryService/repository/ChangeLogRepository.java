package com.auditory.RepositoryService.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auditory.RepositoryService.model.Audio;
import com.auditory.RepositoryService.model.ChangeLog;
import com.auditory.RepositoryService.model.RepositoryManager;

public interface ChangeLogRepository extends JpaRepository<ChangeLog, Timestamp> {
	public List<ChangeLog> findByChangeType(String changeType);
	public List<ChangeLog> findByAudio(Audio audio);
	public List<ChangeLog> findByManager(RepositoryManager manager);
}
