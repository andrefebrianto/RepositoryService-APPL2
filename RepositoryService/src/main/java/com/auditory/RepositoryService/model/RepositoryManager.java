package com.auditory.RepositoryService.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class RepositoryManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String managerId;
	
	@Column(nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "changeTime")
	private List<ChangeLog> changelogs;
	
	public RepositoryManager()
	{
		
	}
	
	public RepositoryManager(String managerId, String password)
	{
		this.managerId = managerId;
		this.password = password;
	}
	
	public void setManagerId(String managerId)
	{
		this.managerId = managerId;
	}
	
	public String getManagerId()
	{
		return managerId;
	}
	
	public void setManagerPassword(String password)
	{
		this.password = password;
	}
	
	public String getManagerPassword()
	{
		return password;
	}
	
	public void addChangeLog(ChangeLog log)
	{
		this.changelogs.add(log);
	}
	
	public void removeChangeLog(ChangeLog log)
	{
		this.changelogs.remove(log);
	}
	
	public List<ChangeLog> getAllChangeLogs()
	{
		return changelogs;
	}
}
