package com.java.virtusVer010.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.virtusVer010.model.Ciclo;
import com.java.virtusVer010.model.ComponentePilar;

@Repository
public interface ComponentePilarRepository extends JpaRepository<ComponentePilar,Long>{
    
}

