package com.example.soap.dao.repository;

import com.example.soap.dao.entity.BeltEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeltRepository extends JpaRepository<BeltEntity,Long > {




}
