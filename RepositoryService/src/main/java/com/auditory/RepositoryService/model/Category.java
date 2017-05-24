package com.auditory.RepositoryService.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long categoryId;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<Audio> audios;
	
	public Category()
	{
		
	}
	
	public Category(String name)
	{
		this.name = name;
	}
	
	public long getCategoryId()
	{
		return categoryId;
	}
	
	public void setCategoryName(String name)
	{
		this.name = name;
	}
	
	public String getCategoryName()
	{
		return name;
	}
	
	public void addAudio(Audio audio)
	{
		this.audios.add(audio);
	}
	
	public void removeAudio(Audio audio)
	{
		this.audios.remove(audio);
	}
	
	public List<Audio> getAllAudios()
	{
		return audios;
	}
}
