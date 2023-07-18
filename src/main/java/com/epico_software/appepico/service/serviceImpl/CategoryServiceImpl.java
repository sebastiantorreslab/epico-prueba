package com.epico_software.appepico.service.serviceImpl;

import com.epico_software.appepico.dto.CategoryDTO;
import com.epico_software.appepico.dto.CategoryItemDTO;
import com.epico_software.appepico.entity.Category;
import com.epico_software.appepico.repository.CategoryRepository;
import com.epico_software.appepico.service.CategoryService;

import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ConversionService conversionService;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ConversionService conversionService) {
        this.categoryRepository = categoryRepository;
        this.conversionService = conversionService;
    }

    @Override
    public ResponseEntity<?> getCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for(Category category:categoryList){
            CategoryDTO categoryDTO = conversionService.convert(category,CategoryDTO.class);
            categoryDTOList.add(categoryDTO);
        }
        return new ResponseEntity<>(categoryDTOList,HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<?> saveCategory(CategoryDTO categoryDTO) {
        if(categoryDTO != null){
            Category category = conversionService.convert(categoryDTO,Category.class);
            categoryRepository.save(category);
            return new ResponseEntity<>("200", HttpStatus.OK);
        }else {
            throw new RuntimeException();
        }
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        if(id != null){
            Category category = categoryRepository.findById(id).orElse(null);
            CategoryDTO categoryDTO = conversionService.convert(category,CategoryDTO.class);
            return new ResponseEntity<>(categoryDTO,HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> updateCategory(CategoryItemDTO categoryItemDTO) {
        Category category = categoryRepository.findById(categoryItemDTO.getId()).orElse(null);
        if(category.getId()!= null){
            category.setCategoryName(categoryItemDTO.getCategoryName());
            category.setCategoryDescription(categoryItemDTO.getCategoryDescription());
            category.setCategoryPic(categoryItemDTO.getCategoryPic());
            category.setItems(categoryItemDTO.getItems());
            categoryRepository.save(category);
            CategoryDTO categoryDTO = conversionService.convert(category,CategoryDTO.class);
            return new ResponseEntity<>(categoryDTO,HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> deleteCategory(Long id) {
        if(id != null){
            categoryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
