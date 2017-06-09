package com.auditory.RepositoryService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auditory.RepositoryService.model.Audio;
import com.auditory.RepositoryService.model.Category;
import com.auditory.RepositoryService.repository.AudioRepository;
import com.auditory.RepositoryService.repository.CategoryRepository;

@CrossOrigin
@RestController
@RequestMapping(value = "/category")
public class CategoryController {
	@Autowired
	CategoryRepository catRepository;
	
	@Autowired
	AudioRepository audRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Category> findAllCategory()
	{
		List<Category> categories = null;
		try {
			categories = catRepository.findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return categories;
	}

	@RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
	public Category findCategoryByCategoryId(@PathVariable("categoryId") long categoryId)
	{
		Category category = null;
		try {
			category = catRepository.findOne(categoryId);
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return category;
	}

	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public Category createNewCategory(@RequestBody Category category)
	{
		try
		{
			catRepository.save(category);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return category;
	}
	
	@RequestMapping(value = "/{categoryId}", method = RequestMethod.DELETE)
	public void deleteCategory(@PathVariable long categoryId)
	{
		try {
			catRepository.delete(categoryId);
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}

	@RequestMapping(value = "/{categoryId}/{audioId}", method = RequestMethod.DELETE)
	public void removeAudioFromCategory(@PathVariable("categoryId") long categoryId, 
			@PathVariable("audioId") long audioId)
	{
		Audio audio = null;
		Category category = null;
		try {
			audio = audRepository.findOne(audioId);
			category = catRepository.findOne(categoryId);
			category.removeAudio(audio);
			catRepository.save(category);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
