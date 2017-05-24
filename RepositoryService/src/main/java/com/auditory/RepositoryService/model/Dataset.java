package com.auditory.RepositoryService.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Dataset implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long datasetId;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany
	@JoinColumn(referencedColumnName = "audioId")
	private List<Audio> audios;
	
	public Dataset()
	{
		
	}
	
	public Dataset(String name)
	{
		this.name = name;
	}
	
	public long getDatasetId()
	{
		return datasetId;
	}
	
	public void setDatasetName(String name)
	{
		this.name = name;
	}
	
	public String getDatasetName()
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
	
	public List<Audio> getAllAudio()
	{
		return audios;
	}
}
