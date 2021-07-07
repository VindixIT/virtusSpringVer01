package com.java.virtusVer010.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.virtusVer010.model.Item;

public interface ItemRepository extends JpaRepository<Item,Long>{
    
}

