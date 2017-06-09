package com.auditory.RepositoryService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auditory.RepositoryService.model.RepositoryManager;
import com.auditory.RepositoryService.repository.RepositoryManagerRepository;

@CrossOrigin
@RestController
@RequestMapping(value = "/manager")
public class RepositoryManagerController {
	@Autowired
	RepositoryManagerRepository rmRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<RepositoryManager> findManagers()
	{
		List<RepositoryManager> managers = null;
		try {
			managers = rmRepository.findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return managers;
	}
	
	@RequestMapping(value = "/{managerId}", method = RequestMethod.GET)
	public RepositoryManager findManagerByManagerId(@PathVariable("managerId") String managerId)
	{
		RepositoryManager manager = null;
		try {
			manager = rmRepository.findOne(managerId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return manager;
	}
	
	@RequestMapping(value = "/{managerId}", method = RequestMethod.DELETE)
	public void deleteManager(@PathVariable("managerId") String managerId)
	{
		try {
			rmRepository.delete(managerId);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public RepositoryManager createNewManager(@RequestBody RepositoryManager manager)
	{
		try {
			rmRepository.save(manager);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return manager;
	}
}
