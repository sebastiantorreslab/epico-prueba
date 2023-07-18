package com.epico_software.appepico.converters;
import com.epico_software.appepico.dto.CategoryDTO;
import com.epico_software.appepico.entity.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryDTOConverter implements Converter<Category, CategoryDTO> {

    @Override
    public CategoryDTO convert(Category source) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryName(source.getCategoryName());
        categoryDTO.setCategoryDescription(source.getCategoryDescription());
        categoryDTO.setCategoryPic(source.getCategoryPic());
        categoryDTO.setItems(source.getItems());
        return categoryDTO;
    }
}
