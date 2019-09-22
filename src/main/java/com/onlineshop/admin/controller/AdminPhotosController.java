package com.onlineshop.admin.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.onlineshop.model.Photos;
import com.onlineshop.service.PhotosService;

@Controller
@RequestMapping("/admin")
public class AdminPhotosController {

	@Autowired
	private PhotosService photosService;
	
	@RequestMapping("/addphototocolor/{colorId}")
	public String formPhotos(Model model,
			@PathVariable("colorId") Long colorId) {
		
		Photos photo = new Photos();
		
		model.addAttribute("photo", photo);
		model.addAttribute("colorId", colorId);
		return"FormAddPhotos";
	}
	
	@RequestMapping(value="/addPhoto/{colorId}",method = RequestMethod.POST)
	public String addPhotos(@ModelAttribute("photo") Photos photo,
			@PathVariable("colorId") Long colorId,
			@RequestParam CommonsMultipartFile[] fileUpload) {
		
		for(CommonsMultipartFile afile : fileUpload) {
			
			
			photo.setPhotoData(afile.getBytes());
					byte[] encodeBase64 = Base64.encodeBase64(photo.getPhotoData());
					String base64Encoded = null;
					
						try {
							base64Encoded = new String(encodeBase64, "UTF-8");
						} catch (UnsupportedEncodingException e) {
							
							e.printStackTrace();
						}
					
						photo.setPhotoDataString(base64Encoded);
					}
		photosService.addPhotos(colorId, photo);
		
		return("redirect:/admin/allproducts/1");
	}
	
	@RequestMapping("/colorsphotos/{colorid}")
	public String getAllPhotoColor(Model model,
			@PathVariable("colorid") Long colorid) {
		
		Set<Photos> photosList = photosService.getPhotosByColourId(colorid);
		
		model.addAttribute("photos", photosList);
		return"ColorsPhotos";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
