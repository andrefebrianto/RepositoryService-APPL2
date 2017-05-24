package com.auditory.RepositoryService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auditory.RepositoryService.model.Audio;
import com.auditory.RepositoryService.model.Tag;
import com.auditory.RepositoryService.repository.AudioRepository;
import com.auditory.RepositoryService.repository.CategoryRepository;
import com.auditory.RepositoryService.repository.TagRepository;

@RestController
@RequestMapping(value = "/audio")
public class AudioController {
	@Autowired
	AudioRepository audRepository;
	
	@Autowired
	TagRepository tagRepository;
	
	@Autowired
	CategoryRepository catRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Audio> getAudios(@RequestParam(value = "title", required = false) String title)
	{
		List<Audio> audios;
		if (title != null)
		{
			audios = audRepository.findByAudioTitle(title);
		}
		else
		{
			audios = audRepository.findAll();	
		}
		return audios;
	}
	
	@RequestMapping(value = "/{audioId}", method = RequestMethod.GET)
	public Audio findAudioByAudioId(@PathVariable("audioId") long audioId)
	{
		Audio audio = new Audio();
		audio = audRepository.findOne(audioId);
		return audio;
	}
/*
	@RequestMapping(method = RequestMethod.GET)
	public List<Audio> findAudioByTitle(@RequestParam("title") String audioTitle)
	{
		List<Audio> audios = audRepository.findByAudioTitle(audioTitle);
		return audios;
	}
*/
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public Audio saveAudio(@RequestBody Audio audio)
	{
		audRepository.save(audio);
		return audio;
	}
	
	@RequestMapping(value = "/{audioId}", method = RequestMethod.DELETE)
	public void deleteAudioByAudioId(@PathVariable("audioId") long audioId)
	{
		audRepository.delete(audioId);
	}
/*
	@RequestMapping(value = "/{audioId}/{tagId}", method = {RequestMethod.POST, RequestMethod.PUT})
	public Tag addTagToAudio(@PathVariable("audioId") long audioId, @PathVariable("tagId") long tagId)
	{
		Audio audio = audRepository.findOne(audioId);
		Tag tag = tagRepository.findOne(tagId);
		audio.addTag(tag);
		return tag;
	}
*/
	@RequestMapping(value = "/{audioId}/{tagId}", method = RequestMethod.DELETE)
	public void removeTagFromAudio(@PathVariable("audioId") long audioId, @PathVariable("tagId") long tagId)
	{
		Audio audio = audRepository.findOne(audioId);
		Tag tag = tagRepository.findOne(tagId);
		audio.removeTag(tag);
		audRepository.save(audio);
	}
	
}
