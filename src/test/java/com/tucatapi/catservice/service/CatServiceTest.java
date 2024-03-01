package com.tucatapi.catservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.tucatapi.catservice.model.CatImgModel;
import com.tucatapi.catservice.model.CatModel;

public class CatServiceTest {

    private CatService catService;
    private RestTemplate restTemplate;

    @BeforeEach
    public void setup() {
        restTemplate = mock(RestTemplate.class);
        catService = new CatService(restTemplate);
    }

    @Test
    public void testGetBreeds() {
    	CatModel[] catModels = new CatModel[1];
    	catModels[0] = new CatModel();
    	catModels[0].setName("Test Breed");
    	ResponseEntity<CatModel[]> responseEntity = ResponseEntity.ok(catModels);
    	when(restTemplate.exchange("https://api.thecatapi.com/v1/breeds?api_key=testApiKey", HttpMethod.GET, null, CatModel[].class))
    	        .thenReturn(responseEntity);
    }


    @Test
    public void testGetBreedById() {
        CatModel catModel = new CatModel();
        catModel.setId("testId");
        ResponseEntity<CatModel> responseEntity = ResponseEntity.ok(catModel);
        when(restTemplate.exchange("https://api.thecatapi.com/v1/breeds/testId?api_key=testApiKey", HttpMethod.GET, null, CatModel.class))
                .thenReturn(responseEntity);

    }

    @Test
    public void testSearchBreeds() {
        CatModel[] catModels = new CatModel[1];
        catModels[0] = new CatModel();
        catModels[0].setName("Test Breed");
        ResponseEntity<CatModel[]> responseEntity = ResponseEntity.ok(catModels);
        when(restTemplate.exchange("https://api.thecatapi.com/v1/breeds/search?q=testQuery", HttpMethod.GET, null, CatModel[].class))
                .thenReturn(responseEntity);
    }


}