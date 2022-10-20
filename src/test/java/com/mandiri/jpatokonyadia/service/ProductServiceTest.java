package com.mandiri.jpatokonyadia.service;

import com.mandiri.jpatokonyadia.dto.Author;
import com.mandiri.jpatokonyadia.entity.Product;
import com.mandiri.jpatokonyadia.entity.Store;
import com.mandiri.jpatokonyadia.repository.ProductRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class ProductServiceTest {

    @Autowired
    ProductService productService;
    @MockBean
    StoreService storeService;
    @MockBean
    ProductRepo productRepo;

    @Test
    void findAll() throws Exception{

    }
    @Test
    public void getById_shouldReturnProduct_whenCalledById() throws ParseException {
//        Author author = new Author("Albert", new SimpleDateFormat("yyyy-MM-dd").parse("1970-08-04"));
//        Author mockAuthor = Mockito.mock(Author.class);
//        Mockito.when(mockAuthor.getName()).thenReturn("Manurung");
//        System.out.println(author.getName());
//        System.out.println(mockAuthor.getName());

        Product productMock = new Product();
        Mockito.when(productRepo.findById("00001")).thenReturn(Optional.of(productMock));
        Product productResult = productService.getById("00001");
        assertNotNull(productResult);
    }

    @Test
    public void getById_should_callProductRepository_FindById() throws ParseException{
        Product productMock = new Product();
        Mockito.when(productRepo.findById("00001")).thenReturn(Optional.of(productMock));

//        yang Di Test
        Product product = productService.getById("00001");
//        Pembuktian
        Mockito.verify(productRepo, Mockito.times(2)).findById("00001");
    }

    @Test
    public void getId_shouldThrowResponses_When_findByIdReturnNull() throws ParseException {
        String id = "1241";
        assertThrows(ResponseStatusException.class, ()->{productService.getById(id);});
    }

    @Test
    public void createNew_Should_callStoreServiceGetByIdOnceUsingStoreId_When_invokedUsingProduct(){
        Product product = new Product();
        Store store = new Store();
        store.setId("00001");
        product.setStore(store);

//        Yang Di Test
        productService.createNew(product);
//        Pembuktian
        Mockito.verify(storeService, Mockito.times(1)).getById("00001");
    }


}