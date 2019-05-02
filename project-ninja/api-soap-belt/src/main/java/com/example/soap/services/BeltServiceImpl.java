package com.example.soap.services;

import com.example.soap.dao.BeltDAO;
import com.example.soap.dao.entity.BeltEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BeltServiceImpl implements BeltService {


    @Resource
    private BeltDAO beltDAO;


    @Override
    public List<BeltEntity> getBelts(){
        return beltDAO.getBelts();
    }

}
