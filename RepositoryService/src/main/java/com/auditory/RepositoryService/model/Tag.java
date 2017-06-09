package com.auditory.RepositoryService.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Tag")
public class Tag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long tagId;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToMany
	@JoinColumn(referencedColumnName = "audioId")
	@JsonIgnoreProperties("tags")
	private List<Audio> audios;	
	
	public Tag()
	{
		
	}
	
	public Tag(String name)
	{
		this.name = name;
	}
	
	public long getTagId()
	{
		return tagId;
	}
	
	public void setTagName(String name)
	{
		this.name = name;
	}
	
	public String getTagName()
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
	
	public List<Audio> getAudios()
	{
		return audios;
	}
	
	public void setAudios(List<Audio> audios)
	{
		this.audios = audios;
	}
}
