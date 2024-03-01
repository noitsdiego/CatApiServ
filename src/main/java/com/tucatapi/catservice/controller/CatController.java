package com.tucatapi.catservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tucatapi.catservice.model.CatModel;
import com.tucatapi.catservice.service.CatService;

@RestController
@RequestMapping("/cats")
public class CatController {

	   @Autowired
		private CatService catService;


    @GetMapping("/breeds")
    public ResponseEntity<List<CatModel>> getBreeds() {
        
    	List<CatModel> catModel = catService.getBreeds();
        
        if (catModel != null) {
            return ResponseEntity.ok(catModel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/breeds/{breed_id}")
    public ResponseEntity<CatModel> getBreedById(@PathVariable("breed_id") String breedId) {
    	CatModel catModel = catService.getBreedById(breedId);
        
        if (catModel != null) {
            return ResponseEntity.ok(catModel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/breeds/search")
    public ResponseEntity<List<CatModel>> searchBreeds(@RequestParam("q") String query) {
        List<CatModel> breeds = catService.searchBreeds(query);
        return ResponseEntity.ok().body(breeds);
    }
    
    
}
