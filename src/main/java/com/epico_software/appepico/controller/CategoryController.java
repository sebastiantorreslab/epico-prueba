package com.epico_software.appepico.controller;
import com.epico_software.appepico.dto.CategoryDTO;
import com.epico_software.appepico.dto.CategoryItemDTO;
import com.epico_software.appepico.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getCategories(){
        return categoryService.getCategories();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        return categoryService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryService.saveCategory(categoryDTO);
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateCategory(@RequestBody CategoryItemDTO categoryItemDTO){
        return categoryService.updateCategory(categoryItemDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Long id){
        return categoryService.deleteCategory(id);
    }


}
