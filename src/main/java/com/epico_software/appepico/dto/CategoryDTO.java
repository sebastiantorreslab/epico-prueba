package com.epico_software.appepico.dto;
import com.epico_software.appepico.entity.Item;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryDTO implements Serializable {

    private String categoryName;
    private String categoryDescription;
    private String categoryPic;
    private List<Item> items;


}
