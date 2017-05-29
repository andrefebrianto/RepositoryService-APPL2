package com.auditory.RepositoryService.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ChangeLog")
public class ChangeLog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Timestamp changeTime;
	
	@Column(nullable = false)
	private String changeType;
	
	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "audioId")
	private Audio audio;
	
	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "managerId")
	private RepositoryManager manager;
	
	public ChangeLog()
	{
		
	}
	
	public ChangeLog(String changeType, Audio audio, RepositoryManager manager)
	{
		this.changeTime = new Timestamp(System.currentTimeMillis());
		this.changeType = changeType;
		this.audio = audio;
		this.manager = manager;
	}
	
	public Timestamp getChangeTime()
	{
		return changeTime;
	}
	
	public void setChangeType(String changeType)
	{
		this.changeType = changeType;
	}
	
	public String getChangeType()
	{
		return changeType;
	}
	
	public void setAudio(Audio audio)
	{
		this.audio = audio;
	}
	
	public Audio getAudio()
	{
		return audio;
	}
	
	public void setRepositoryManager(RepositoryManager manager)
	{
		this.manager = manager;
	}
	
	public RepositoryManager getRepositoryManager()
	{
		return manager;
	}
}
