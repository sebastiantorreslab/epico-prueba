package com.epico_software.appepico.service;

import com.epico_software.appepico.dto.ItemDTO;
import com.epico_software.appepico.dto.ItemDTOFind;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


public interface ItemService {

    ResponseEntity<?> getItems(Pageable pageable);
    ResponseEntity<?> saveItem(ItemDTO itemDTO);
    ResponseEntity<?> findById(Long id);
    ResponseEntity<?> updateItem(ItemDTOFind ItemDTOFind);
    ResponseEntity<?> deleteItem(Long id);
    ResponseEntity<?> logicDeleteItem(Long id);







}
