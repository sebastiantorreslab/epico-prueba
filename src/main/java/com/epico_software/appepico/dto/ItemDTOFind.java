package com.epico_software.appepico.dto;

import com.epico_software.appepico.entity.Category;
import com.epico_software.appepico.entity.Item;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDTOFind {

    private Long id;
    private String name;
    private Long category_id;
    private BigDecimal costPrice;
    private BigDecimal unitPrice;
    private String picFilename;
    private String sku;
    private Boolean available;

}
