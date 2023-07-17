package com.epico_software.appepico.converters;

import com.epico_software.appepico.dto.ItemDTO;
import com.epico_software.appepico.entity.Item;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ItemDTOToItemConverter implements Converter<ItemDTO,Item> {

    @Override
    public Item convert(ItemDTO source) {
        Item item = new Item();
        item.setName(source.getName());
        item.setCategory(source.getCategory());
        item.setSKU(source.getSku());
        item.setCostPrice(source.getCostPrice());
        item.setUnitPrice(source.getUnitPrice());
        item.setPicFilename(source.getPicFilename());
        item.setAvailable(source.getAvailable());
        return item;
    }
}
