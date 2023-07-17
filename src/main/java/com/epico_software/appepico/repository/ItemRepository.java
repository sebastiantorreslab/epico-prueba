package com.epico_software.appepico.repository;

import com.epico_software.appepico.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

//    @Query("select i from Items i where i.available = ?1")
//    Page<Item> listAvailableItems(boolean instIsActive, Pageable pageable);
//
//    @Query("select i from Items i where i.available = ?1")
//    Page<Item> listNotAvailableItems(boolean available, Pageable pageable);


}
