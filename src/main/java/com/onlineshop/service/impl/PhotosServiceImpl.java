package com.onlineshop.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.dao.ColourDAO;
import com.onlineshop.dao.PhotosDAO;
import com.onlineshop.model.Colour;
import com.onlineshop.model.Photos;
import com.onlineshop.service.PhotosService;

@Service
public class PhotosServiceImpl implements PhotosService{

	@Autowired
	private ColourDAO colourDAO;
	
	@Autowired
	private PhotosDAO photosDAO;
	
	@Override
	@Transactional
	public void addPhotos(Long colourId, Photos photos) {
		photosDAO.save(photos);
		Colour existColour = colourDAO.findOne(colourId);
		existColour.getColourPhotos().add(photos);
		colourDAO.save(existColour);
		
	}

	@Override
	@Transactional
	public Set<Photos> getPhotosByColourId(Long colourId) {
		Colour existColour = colourDAO.findOne(colourId);
		Set<Photos> listPh = existColour.getColourPhotos();
		return listPh;
	}

}
