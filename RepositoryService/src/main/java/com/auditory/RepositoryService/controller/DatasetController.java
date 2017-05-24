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
import com.auditory.RepositoryService.model.Dataset;
import com.auditory.RepositoryService.repository.AudioRepository;
import com.auditory.RepositoryService.repository.DatasetRepository;

@RestController
@RequestMapping(value = "/dataset")
public class DatasetController {
	@Autowired
	DatasetRepository dataRepository;
	
	@Autowired
	AudioRepository audRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Dataset> findAllDataset()
	{
		List<Dataset> datasets = dataRepository.findAll();
		return datasets;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Dataset> findDatasetByName(@RequestParam("name") String datasetName)
	{
		List<Dataset> datasets = dataRepository.findByName(datasetName);
		return datasets;
	}
	
	@RequestMapping(value = "/{datasetId}", method = RequestMethod.GET)
	public Dataset findDatasetBy(@PathVariable("datasetId") long datasetId)
	{
		Dataset dataset = dataRepository.findOne(datasetId);
		return dataset;
	}
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public Dataset createNewDataset(@RequestBody Dataset dataset)
	{
		dataRepository.save(dataset);
		return dataset;
	}
	
	@RequestMapping(value = "/{datasetId}", method = RequestMethod.DELETE)
	public void deleteDatasetbyDatasetId(@PathVariable("datasetId") long datasetId)
	{
		dataRepository.delete(datasetId);
	}
	
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
	
	@RequestMapping(value = "/{datasetId}/{audioId}", method = RequestMethod.DELETE)
	public void removeAudioFromDataset(@PathVariable("datasetId") long datasetId,
			@PathVariable("audioId") long audioId)
	{
		
	}
}
