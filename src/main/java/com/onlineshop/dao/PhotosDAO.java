package com.onlineshop.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.onlineshop.model.Photos;

@Repository
public interface PhotosDAO extends CrudRepository<Photos, Long>,PagingAndSortingRepository<Photos, Long>{

}
