package uy.com.bbva.services.template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uy.com.bbva.services.commons.exceptions.ServiceException;
import uy.com.bbva.services.template.connection.ConnectionApiSoap;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class BeltServiceImpl implements BeltService {

    @Autowired
    private ConnectionApiSoap connectionApiSoap;


    @Override
    public Map<Long, String> getBelts() throws ServiceException {

        belt.wsdl.GetAllBeltsResponse response = null;
        response = connectionApiSoap.getBelts();

        final List<belt.wsdl.Belt> belts = response.getBelts();

        final Map<Long, String> treeMapBelts = new TreeMap<>();
        for (final belt.wsdl.Belt belt : belts) {
            treeMapBelts.put(belt.getPoints(), belt.getName());

        }

        return treeMapBelts;
    }
}
