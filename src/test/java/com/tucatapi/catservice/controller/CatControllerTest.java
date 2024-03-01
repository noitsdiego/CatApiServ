package com.tucatapi.catservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.tucatapi.catservice.model.CatModel;
import com.tucatapi.catservice.service.CatService;

public class CatControllerTest {

    @Mock
    private CatService catService;

    @InjectMocks
    private CatController catController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetBreeds() {
        // Given
        CatModel catModel1 = new CatModel("1", "Siamese", "","");
        CatModel catModel2 = new CatModel("2", "Persian", "","");
        List<CatModel> catModels = Arrays.asList(catModel1, catModel2);

        when(catService.getBreeds()).thenReturn(catModels);

     
        ResponseEntity<List<CatModel>> response = catController.getBreeds();

   
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(catModels, response.getBody());
    }

    @Test
    public void testGetBreedById() {
    	CatModel catModel1 = new CatModel("1", "Persian", "","");
        
        when(catService.getBreedById("persian")).thenReturn(catModel1);

        ResponseEntity<CatModel> response = catController.getBreedById("persian");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(catModel1, response.getBody());
    }

    @Test
    public void searchBreeds() {
    	CatModel catModel1 = new CatModel("1", "Persian", "","");
    	List<CatModel> catModels = Arrays.asList(catModel1);
    	
    	when(catService.getBreeds()).thenReturn(catModels);

    	 ResponseEntity<List<CatModel>> response = catController.getBreeds();

         assertEquals(200, response.getStatusCodeValue());
         assertEquals(catModels, response.getBody());
    }

   
}