package com.epico_software.appepico.converters;
import com.epico_software.appepico.dto.CategoryDTO;
import com.epico_software.appepico.entity.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryDTOToCategory implements Converter<CategoryDTO,Category> {

    @Override
    public Category convert(CategoryDTO source) {
        Category category = new Category();
        category.setCategoryName(source.getCategoryName());
        category.setCategoryDescription(source.getCategoryDescription());
        category.setCategoryPic(source.getCategoryPic());
        category.setItems(source.getItems());
        return category;
    }


}
