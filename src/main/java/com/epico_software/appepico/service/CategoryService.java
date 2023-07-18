package com.epico_software.appepico.service;
import com.epico_software.appepico.dto.CategoryDTO;
import com.epico_software.appepico.dto.ItemDTO;
import com.epico_software.appepico.dto.ItemDTOFind;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface CategoryService {
    ResponseEntity<?> getCategories();
    ResponseEntity<?> saveCategory(CategoryDTO categoryDTO);
    ResponseEntity<?> findById(Long id);
    ResponseEntity<?> updateCategory(CategoryDTO categoryDTO);
    ResponseEntity<?> deleteCategory(Long id);

}
