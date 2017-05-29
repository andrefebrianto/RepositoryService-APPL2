package com.auditory.RepositoryService.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Album")
public class Album implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long albumId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Date releaseDate;
	
	@OneToMany(mappedBy = "album")
	@JsonIgnoreProperties("album")
	private List<Audio> audios;
	
	public Album()
	{
		
	}
	
	public Album(long albumId, String name, Date releaseDate)
	{
		this.albumId = albumId;
		this.name = name;
		this.releaseDate = releaseDate;
	}
	
	public void setAlbumId(long albumId)
	{
		this.albumId = albumId;
	}
	
	public long getAlbumId()
	{
		return albumId;
	}
	
	public void setAlbumName(String name)
	{
		this.name = name;
	}
	
	public String getAlbumName()
	{
		return name;
	}
	
	public void setReleaseDate(Date releaseDate)
	{
		this.releaseDate = releaseDate;
	}
	
	public Date getReleaseDate()
	{
		return releaseDate;
	}
	
	public void setAudios(List<Audio> audios)
	{
		this.audios = audios;
	}
	
	public List<Audio> getAudios()
	{
		return audios;
	}
	
	public void addAudio(Audio audio)
	{
		this.audios.add(audio);
	}
	
	public void removeAudio(Audio audio)
	{
		this.audios.remove(audio);
	}
}
