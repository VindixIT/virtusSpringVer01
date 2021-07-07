package com.java.virtusVer010.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.virtusVer010.model.Ciclo;


@Repository
public interface CicloRepository extends JpaRepository<Ciclo,Long>{
    
}
