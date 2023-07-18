package com.epico_software.appepico.converters;

import com.epico_software.appepico.dto.ItemDTO;
import com.epico_software.appepico.dto.ItemDTOFind;
import com.epico_software.appepico.entity.Item;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ItemDTOFindToItemConverter implements Converter<ItemDTOFind,Item> {

    @Override
    public Item convert(ItemDTOFind source) {
        Item item = new Item();
        item.setName(source.getName());
        item.setCategory(source.getCategory());;
        item.setSku(source.getSku());
        item.setPicFilename(source.getPicFilename());
        item.setCostPrice(source.getCostPrice());
        item.setUnitPrice(source.getUnitPrice());
        item.setAvailable(source.getAvailable());
        return item;
    }
}
