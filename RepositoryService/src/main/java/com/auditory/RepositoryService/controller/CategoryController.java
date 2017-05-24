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
import com.auditory.RepositoryService.model.Category;
import com.auditory.RepositoryService.repository.AudioRepository;
import com.auditory.RepositoryService.repository.CategoryRepository;

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
		List<Category> categories = catRepository.findAll();
		return categories;
	}
	
	@RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
	public Category findCategoryByCategoryId(@PathVariable("categoryId") long categoryId)
	{
		Category category = new Category();
		category = catRepository.findOne(categoryId);
		return category;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Category findCategoryByName(@RequestParam("name") String categoryName)
	{
		Category category = new Category();
		category = catRepository.findByName(categoryName);
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
		catRepository.delete(categoryId);
	}
	
	@RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
	public List<Audio> getAllAudio(@PathVariable long categoryId)
	{
		Category category = new Category();
		category = catRepository.findOne(categoryId);
		return category.getAllAudios();
	}
	
	@RequestMapping(value = "/{categoryId}/{audioId}", method = {RequestMethod.POST, RequestMethod.PUT})
	public Audio addAudioToCategory(@PathVariable("categoryId") long categoryId, 
			@PathVariable("audioId") long audioId)
	{
		Category category = catRepository.findOne(categoryId);
		Audio audio = audRepository.findOne(audioId);
		category.addAudio(audio);
		return audio;
	}
	
	@RequestMapping(value = "/{categoryId}/{audioId}", method = RequestMethod.DELETE)
	public void removeAudioFromCategory(@PathVariable("categoryId") long categoryId, 
			@PathVariable("audioId") long audioId)
	{
		Audio audio = audRepository.findOne(audioId);
		Category category = catRepository.findOne(categoryId);
		category.removeAudio(audio);
		catRepository.save(category);
	}
}
