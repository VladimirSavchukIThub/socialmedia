package com.example.socialmedia;

import com.example.socialmedia.models.Products;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.socialmedia.dal.DataAccessLayer;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;


public class MainControllerTest {
	@Mock
	private DataAccessLayer dataAccessLayer;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetProductById() {
		Products products = new Products();
		products.setProductsId(1L);
		products.setProductName("Coca-cola");
		when(dataAccessLayer.getProduct(1L)).thenReturn(products);

	}
}