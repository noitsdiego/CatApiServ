package com.tucatapi.catservice.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

class CatModelTest {

	@Test
    public void testCatImageModel() {
		CatModel catImage = new CatModel();
        catImage.setId("1");
        catImage.setName("persian");
        catImage.setDescription("pretty");
        catImage.setImageUrl("www");

        assertThat(catImage.getId()).isEqualTo("1");
        assertThat(catImage.getName()).isEqualTo("persian");
        assertThat(catImage.getDescription()).isEqualTo("pretty");
        assertThat(catImage.getImageUrl()).isEqualTo("www");
    }

	
}
