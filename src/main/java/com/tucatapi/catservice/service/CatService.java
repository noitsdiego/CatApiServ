package com.tucatapi.catservice.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.tucatapi.catservice.model.CatImgModel;
import com.tucatapi.catservice.model.CatModel;

@Service
public class CatService {

	private final RestTemplate restTemplate;

    @Value("${thecatapi.key}")
    private String apiKey;
    
	private static String URL = "https://api.thecatapi.com/v1/breeds";


    public CatService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<CatModel> getBreeds() {
        String url = URL+"?api_key=" + apiKey;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("x-api-key", apiKey);
        ResponseEntity<CatModel[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, CatModel[].class);        
        List<CatModel> breeds = Arrays.asList(responseEntity.getBody());

        for (CatModel breed : breeds) {
            breed.setImageUrl("not available :(");
        }

        return breeds;
        
        
    }

    public CatModel getBreedById(String breedId) {
        String url = URL+"/" + breedId + "?api_key=" + apiKey;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("x-api-key", apiKey);
        ResponseEntity<CatModel> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, CatModel.class);
        
        CatModel cm = responseEntity.getBody();
        String imageUrl = getImageUrlForBreed(cm.getId());
        cm.setImageUrl(imageUrl);
        
        return cm;
    }



    
    public List<CatModel> searchBreeds(String query) {
        String url = "https://api.thecatapi.com/v1/breeds/search";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("x-api-key", apiKey);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("q", query);

        ResponseEntity<CatModel[]> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, CatModel[].class);
        List<CatModel> breeds = Arrays.asList(responseEntity.getBody());

        // Obtener la URL de la imagen para cada raza de gato
        for (CatModel breed : breeds) {
            String imageUrl = getImageUrlForBreed(breed.getId());
            breed.setImageUrl(imageUrl);
        }

        return breeds;
    }

    String getImageUrlForBreed(String breedId) {
        String url = "https://api.thecatapi.com/v1/images/search";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("x-api-key", apiKey);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("breed_id", breedId);

        ResponseEntity<CatImgModel[]> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, CatImgModel[].class);
        CatImgModel[] images = responseEntity.getBody();

        if (images != null && images.length > 0) {
            return images[0].getUrl();
        } else {
            return null;
        }
    }
}