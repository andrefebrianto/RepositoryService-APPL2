package com.auditory.RepositoryService.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Audio")
public class Audio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long audioId;
	
	@Column(nullable = false)
	private String audioTitle;
	
	@Column(nullable = false)
	private int length;
	
	@Column(nullable = false)
	private String filePath;
	
	@ManyToMany(mappedBy = "audios")
	@JsonIgnoreProperties("audios")
	private List<Tag> tags;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "categoryId")
	@JsonIgnoreProperties("audios")
	private Category category;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "albumId")
	@JsonIgnoreProperties("audios")
	private Album album;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "datasetId")
	@JsonIgnoreProperties("audios")
	private Dataset dataset;
	
	public Audio()
	{
		
	}
	
	public Audio(String audioTitle, int length, String filePath, List<Tag> tags, Category category, Album album)
	{
		this.audioTitle = audioTitle;
		this.length = length;
		this.filePath = filePath;
		this.tags = tags;
		this.category = category;
		this.album = album;
	}
	
	public long getAudioId()
	{
		return audioId;
	}
	
	public void setAudioTitle(String audioTitle)
	{
		this.audioTitle = audioTitle;
	}
	
	public String getAudioTitle()
	{
		return audioTitle;
	}
	
	
	public void setLength(int length)
	{
		this.length = length;
	}
	
	public int getLength()
	{
		return length;
	}
	
	public void setFilePath(String filePath)
	{
		this.filePath = filePath;
	}
	
	public String getFilePath()
	{
		return filePath;
	}
	
	public void addTag(Tag tag)
	{
		this.tags.add(tag);
	}
	
	public void removeTag(Tag tag)
	{
		this.tags.remove(tag);
	}
	
	public List<Tag> getTags()
	{
		return tags;
	}
	
	public void setTags(List<Tag> tags)
	{
		this.tags = tags;
	}
	
	public void setCategory(Category category)
	{
		this.category = category;
	}
	
	public Category getCategory()
	{
		return category;
	}
	
	public void setAlbum(Album album)
	{
		this.album = album;
	}
	
	public Album getAlbum()
	{
		return album;
	}
}