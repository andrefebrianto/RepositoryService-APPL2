package com.auditory.RepositoryService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auditory.RepositoryService.model.Tag;
import com.auditory.RepositoryService.repository.TagRepository;

@RestController
@RequestMapping(value = "/tag")
public class TagController {
	@Autowired
	TagRepository tagRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Tag> getTags()
	{
		List<Tag> tags = null;
		try {
			tags = tagRepository.findAll();		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tags;
	}
	
	@RequestMapping(value = "/{tagId}", method = RequestMethod.GET)
	public Tag findTagByTagId(@PathVariable("tagId") long tagId)
	{
		Tag tag = null;
		try {
			tag = tagRepository.findOne(tagId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tag;
	}
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public Tag createNewTag(@RequestBody Tag tag)
	{
		try {
			tagRepository.save(tag);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tag;
	}
	
	@RequestMapping(value = "/{tagId}", method = RequestMethod.DELETE)
	public void deleteTagByTagId(@PathVariable("tagId") long tagId)
	{
		try {
			tagRepository.delete(tagId);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
