package com.epico_software.appepico.service.serviceImpl;

import com.epico_software.appepico.dto.CategoryDTO;
import com.epico_software.appepico.repository.CategoryRepository;
import com.epico_software.appepico.service.CategoryService;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ConversionService convert;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ConversionService convert) {
        this.categoryRepository = categoryRepository;
        this.convert = convert;
    }

    @Override
    public ResponseEntity<?> getCategories() {
        return null;
    }

    @Override
    public ResponseEntity<?> saveCategory(CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateCategory(CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteCategory(Long id) {
        return null;
    }
}
