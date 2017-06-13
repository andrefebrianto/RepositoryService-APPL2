package com.auditory.RepositoryService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auditory.RepositoryService.model.Audio;
import com.auditory.RepositoryService.model.Dataset;
import com.auditory.RepositoryService.repository.AudioRepository;
import com.auditory.RepositoryService.repository.DatasetRepository;

@CrossOrigin
@RestController
@RequestMapping(value = "/dataset")
public class DatasetController {
	@Autowired
	DatasetRepository dataRepository;
	
	@Autowired
	AudioRepository audRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Dataset> findDataset(@RequestParam(value = "name", required = false) String datasetName)
	{
		List<Dataset> datasets = null;
		try {
			if(datasetName != null)
			{
				datasets = dataRepository.findByName(datasetName);
			}
			else
			{
				datasets = dataRepository.findAll();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return datasets;
	}
/*
	@RequestMapping(method = RequestMethod.GET)
	public List<Dataset> findDatasetByName(@RequestParam("name") String datasetName)
	{
		List<Dataset> datasets = dataRepository.findByName(datasetName);
		return datasets;
	}
*/
	@RequestMapping(value = "/{datasetId}", method = RequestMethod.GET)
	public Dataset findDatasetBy(@PathVariable("datasetId") long datasetId)
	{
		Dataset dataset = null;
		try {
			dataset = dataRepository.findOne(datasetId);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return dataset;
	}
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public Dataset createNewDataset(@RequestBody Dataset dataset)
	{		
		try {
			dataRepository.save(dataset);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
		return dataset;
	}
	
	@RequestMapping(value = "/{datasetId}", method = RequestMethod.DELETE)
	public void deleteDatasetbyDatasetId(@PathVariable("datasetId") long datasetId)
	{
		try {
			dataRepository.delete(datasetId);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}		
	}
/*
	@RequestMapping(value = "/{datasetId}/{audioId}", method = {RequestMethod.POST, RequestMethod.PUT})
	public Audio addAudioToDataset(@PathVariable("datasetId") long datasetId,
			@PathVariable("audioId") long audioId)
	{
		Audio audio = audRepository.findOne(audioId);
		Dataset dataset = dataRepository.findOne(datasetId);
		dataset.addAudio(audio);
		dataRepository.save(dataset);
		return audio;
	}
*/
	@RequestMapping(value = "/{datasetId}/{audioId}", method = RequestMethod.DELETE)
	public void removeAudioFromDataset(@PathVariable("datasetId") long datasetId,
			@PathVariable("audioId") long audioId)
	{
		try {
			Audio audio = audRepository.findOne(audioId);
			Dataset dataset = dataRepository.findOne(datasetId);
			dataset.removeAudio(audio);
			dataRepository.save(dataset);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}		
	}
}
