package com.auditory.RepositoryService.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Album")
public class Album implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private char albumId[] = new char[5];
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Date releaseDate;
	
	public Album()
	{
		
	}
	
	public Album(char albumId[], String name, Date releaseDate)
	{
		this.albumId = albumId;
		this.name = name;
		this.releaseDate = releaseDate;
	}
	
	public void setAlbumId(char albumId[])
	{
		this.albumId = albumId;
	}
	
	public char[] getAlbumId()
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
}
