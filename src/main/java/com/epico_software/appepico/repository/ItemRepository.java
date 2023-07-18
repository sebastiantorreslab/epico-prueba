package com.epico_software.appepico.repository;

import com.epico_software.appepico.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {


    @Query("SELECT c.categoryName AS categoryName, COUNT(i.id) AS itemsCount " +
            "FROM Item i JOIN i.category c " +
            "GROUP BY c.categoryName")
    List<Object[]> countItemsByCategory();


}
