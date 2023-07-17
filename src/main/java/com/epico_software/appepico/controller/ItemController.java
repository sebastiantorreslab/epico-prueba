package com.epico_software.appepico.controller;
import com.epico_software.appepico.dto.ItemDTO;
import com.epico_software.appepico.dto.ItemDTOFind;
import com.epico_software.appepico.service.ItemService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {
    public static final int DEFAULT_PAGE_SIZE = 10;
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @GetMapping("/get")
    public ResponseEntity<?> getItems(@PageableDefault(size = DEFAULT_PAGE_SIZE)
                                             Pageable pageable){
        return itemService.getItems(pageable);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        return itemService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveItem(@RequestBody ItemDTO itemDTO){
        return itemService.saveItem(itemDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateItem(@RequestBody ItemDTOFind itemDTOFind){
        return itemService.updateItem(itemDTOFind);
    }

    @PatchMapping("/setStatus/{id}")
    public ResponseEntity<?>  logicDeleteItem(@PathVariable("id") Long id){
        return itemService.logicDeleteItem(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable("id") Long id){
        return itemService.deleteItem(id);
    }



}
