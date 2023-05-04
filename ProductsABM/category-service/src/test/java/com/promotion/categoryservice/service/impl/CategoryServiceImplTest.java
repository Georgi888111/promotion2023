package com.promotion.categoryservice.service.impl;

import com.promotion.categoryservice.entity.Category;
import com.promotion.categoryservice.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceImplTest {

    @Mock
    CategoryRepository categoryRepository;

    @InjectMocks
    CategoryServiceImpl categoryService;

    Category category;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        category = new Category();
        category.setName("Fideos");
        category.setDescription("Pastas");

    }

    @Test
    void findAll() {
        when(categoryRepository.findAll()).thenReturn(Arrays.asList(category));
        assertNotNull(categoryService.findAll());
    }

    @Test
    void findById() {
        when(categoryRepository.findById(Mockito.any(UUID.class))).thenReturn(Optional.ofNullable(category));
        assertNotNull(categoryService.findById(Mockito.any(UUID.class)));
    }

    @Test
    void saveOne() {
        when(categoryRepository.save(category)).thenReturn(category);
        assertNotNull(categoryService.saveOne(category));
    }

    @Test
    void updateOne() {
        when(categoryRepository.findById(Mockito.any(UUID.class))).thenReturn(Optional.ofNullable(category));
        assertNotNull(categoryService.findById(Mockito.any(UUID.class)));
        when(categoryRepository.save(category)).thenReturn(category);
        assertNotNull(categoryService.saveOne(category));
    }

    @Test
    void deleteOne() {
        doNothing().when(categoryRepository).deleteById(any());
        assertTrue(categoryService.deleteOne(any()));
    }
}