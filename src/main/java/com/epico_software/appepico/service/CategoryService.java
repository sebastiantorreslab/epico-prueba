package com.epico_software.appepico.service;
import com.epico_software.appepico.dto.CategoryDTO;
import com.epico_software.appepico.dto.CategoryItemDTO;
import org.springframework.http.ResponseEntity;

public interface CategoryService {
    ResponseEntity<?> getCategories();
    ResponseEntity<?> saveCategory(CategoryDTO categoryDTO);
    ResponseEntity<?> findById(Long id);
    ResponseEntity<?> updateCategory(CategoryItemDTO categoryItemDTO);
    ResponseEntity<?> deleteCategory(Long id);

}
