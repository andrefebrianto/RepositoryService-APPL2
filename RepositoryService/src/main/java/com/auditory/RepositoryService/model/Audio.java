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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Audio")
public class Audio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long audioId;
	
	@Column(nullable = false)
	private String audioTitle;
	
	@Column(nullable = false)
	private int length;
	
	@Column(nullable = false)
	private String filePath;
	
	@ManyToMany(mappedBy = "audios")
	private List<Tag> tags;
	
	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "categoryId")
	private Category category;
	
	public Audio()
	{
		
	}
	
	public Audio(String audioTitle, int length, String filePath)
	{
		this.audioTitle = audioTitle;
		this.length = length;
		this.filePath = filePath;
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
	
	public List<Tag> getAllTags()
	{
		return tags;
	}
	
	public void setCategory(Category category)
	{
		this.category = category;
	}
	
	public Category getCategory()
	{
		return category;
	}
}