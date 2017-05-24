package com.auditory.RepositoryService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auditory.RepositoryService.repository.AlbumRepository;
import com.auditory.RepositoryService.model.*;

@RestController
@RequestMapping(value = "/album")
public class AlbumController {
	@Autowired
	AlbumRepository repository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Album> getAllAlbum()
	{
		return repository.findAll();
	}
	
	@RequestMapping(value = "/{albumId}", method = RequestMethod.GET)
	public Album findAlbumByAlbumId(@PathVariable("albumId") char albumId[])
	{
		Album album = new Album();
		album = repository.findOne(albumId);
		return album;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Album> findAlbumByName(@RequestParam("name") String name)
	{
		List<Album> albums = repository.findByName(name);
		return albums;
	}
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public Album saveAlbum(@RequestBody Album album)
	{
		try
		{
		repository.save(album);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return album;
	}
	
	@RequestMapping(value = "/{albumId}", method = RequestMethod.GET)
	public void deleteAlbumByAlbumId(@PathVariable("albumId") char albumId[])
	{
		repository.delete(albumId);
	}
}
