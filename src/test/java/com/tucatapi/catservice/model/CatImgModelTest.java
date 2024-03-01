package com.tucatapi.catservice.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CatImgModelTest {

	@Test
    public void testCatImageModel() {
		CatImgModel catImage = new CatImgModel();
        catImage.setId("1");
        catImage.setUrl("http://example.com/cat.jpg");
        catImage.setBreedId("1");

        assertThat(catImage.getId()).isEqualTo("1");
        assertThat(catImage.getUrl()).isEqualTo("http://example.com/cat.jpg");
        assertThat(catImage.getBreedId()).isEqualTo("1");
    }

}
