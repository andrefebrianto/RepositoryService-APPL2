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
	AlbumRepository albRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Album> getAllAlbum(@RequestParam(value = "name", required = false) String albumName)
	{
		List<Album> albums = null;
		try{
			if(albumName != null)
			{
				albums = albRepository.findByName(albumName);
			}
			else
			{
				albums = albRepository.findAll(); 
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return albums;
	}
	
	@RequestMapping(value = "/{albumId}", method = RequestMethod.GET)
	public Album findAlbumByAlbumId(@PathVariable("albumId") long albumId)
	{
		Album album = null;
		try{
			album = albRepository.findOne(albumId);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return album;
	}
/*
	@RequestMapping(method = RequestMethod.GET)
	public Album findAlbumByAlbumId(@RequestParam("albumId") char albumId[])
	{
		Album album = null;
		try{
			album = albRepository.findOne(albumId);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return album;
	}
*/
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public Album saveAlbum(@RequestBody Album album)
	{
		try{
			albRepository.save(album);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return album;
	}
	
	@RequestMapping(value = "/{albumId}", method = RequestMethod.DELETE)
	public void deleteAlbumByAlbumId(@PathVariable("albumId") long albumId)
	{
		try {
			albRepository.delete(albumId);
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}
}
