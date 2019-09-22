package com.onlineshop.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.onlineshop.model.Colour;



@Repository
public interface ColourDAO extends CrudRepository<Colour, Long> , PagingAndSortingRepository<Colour, Long>{

}
