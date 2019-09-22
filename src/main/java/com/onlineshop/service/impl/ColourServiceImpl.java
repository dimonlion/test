package com.onlineshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.dao.ColourDAO;
import com.onlineshop.model.Colour;
import com.onlineshop.service.ColourService;

@Service
public class ColourServiceImpl implements ColourService{

	@Autowired
	private ColourDAO colourDAO;
	
	@Override
	@Transactional
	public Colour getColourById(Long colourId) {
		
		return colourDAO.findOne(colourId);
	}

}
