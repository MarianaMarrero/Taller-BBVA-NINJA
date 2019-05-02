package com.example.soap.dao;

import com.example.soap.dao.entity.BeltEntity;
import com.example.soap.dao.repository.BeltRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class BeltDAOImpl implements BeltDAO {

    @Resource
    private BeltRepository beltRepository;


    @Override
    public List<BeltEntity> getBelts(){

        return beltRepository.findAll();
    }
}
