package com.epico_software.appepico.service.serviceImpl;
import com.epico_software.appepico.dto.ItemDTO;
import com.epico_software.appepico.dto.ItemDTOFind;
import com.epico_software.appepico.entity.Category;
import com.epico_software.appepico.entity.Item;
import com.epico_software.appepico.repository.CategoryRepository;
import com.epico_software.appepico.repository.ItemRepository;
import com.epico_software.appepico.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final ConversionService conversionService;


    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, CategoryRepository categoryRepository, ConversionService conversionService) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
        this.conversionService = conversionService;
    }


    @Override
    public ResponseEntity<?> getItems(Pageable pageable) {
        Page<Item> response = itemRepository.findAll(pageable);
        if(response.hasContent()){
            return ResponseEntity.ok(response
                    .map(item->conversionService.convert(item,ItemDTO.class)).toList());
        }else{
            return new ResponseEntity<>("not item in database",HttpStatus.OK);
            }
    }

    @Override
    public ResponseEntity<?> saveItem(ItemDTO itemDTO) {
        if(itemDTO != null){
            Item item = conversionService.convert(itemDTO,Item.class);
            Category category = categoryRepository.findById(itemDTO.getCategory_id()).orElse(null);
            item.setCategory(category);
            itemRepository.save(item);
            return new ResponseEntity<>("200",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("401 - not created", HttpStatus.BAD_REQUEST);

        }

    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        if(id != null){
            Item item = itemRepository.findById(id).orElse(null);
            ItemDTO itemDTO = conversionService.convert(item,ItemDTO.class);
            return new ResponseEntity<>(itemDTO,HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<?> updateItem(ItemDTOFind itemDTOFind) {
            Item item = itemRepository.findById(itemDTOFind.getId()).orElse(null);
                Category category = categoryRepository.findById(itemDTOFind.getCategory_id()).orElse(null);
            if(item.getId()!= null){
                item.setName(itemDTOFind.getName());
                item.setSku(itemDTOFind.getSku());
                item.setPicFilename(itemDTOFind.getPicFilename());
                item.setCostPrice(itemDTOFind.getCostPrice());
                item.setUnitPrice(itemDTOFind.getUnitPrice());
                item.setAvailable(itemDTOFind.getAvailable());
                item.setCategory(category);
                itemRepository.save(item);
                ItemDTO itemDTO = conversionService.convert(item,ItemDTO.class);
                return new ResponseEntity<>(itemDTO,HttpStatus.ACCEPTED);
            }else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
       }



    @Override
    public ResponseEntity<?> deleteItem(Long id) {
        if(id !=null){
            itemRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);

        }else{
            throw new RuntimeException();
        }


    }

    @Override
    public ResponseEntity<?> logicDeleteItem(Long id) {
        if(id != null){
            Item item = itemRepository.findById(id).orElse(null);
            item.setAvailable(!item.getAvailable());
            itemRepository.save(item);
            ItemDTO itemDTO = conversionService.convert(item,ItemDTO.class);
            return new ResponseEntity<>(itemDTO,HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Object[]> countItemsByCategory() {
        return itemRepository.countItemsByCategory();
    }



}
