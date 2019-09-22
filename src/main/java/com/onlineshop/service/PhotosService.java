package com.onlineshop.service;

import java.util.List;
import java.util.Set;

import com.onlineshop.model.Photos;

public interface PhotosService {

	void addPhotos(Long colourId,Photos photos);
	Set<Photos> getPhotosByColourId(Long colourId);
	
}
