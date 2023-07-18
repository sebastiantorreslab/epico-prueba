package com.epico_software.appepico.dto;

import com.epico_software.appepico.entity.Category;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDTO implements Serializable {

    private  String name;
    private Long category_id;
    private BigDecimal costPrice;
    private BigDecimal unitPrice;
    private String picFilename;
    private String sku;
    private Boolean available;


}
