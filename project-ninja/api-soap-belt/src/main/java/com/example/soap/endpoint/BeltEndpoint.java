package com.example.soap.endpoint;

import com.example.soap.dao.entity.BeltEntity;
import com.example.soap.services.BeltService;
import com.soap.belts.Belt;
import com.soap.belts.GetAllBeltsRequest;
import com.soap.belts.GetAllBeltsResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;


    @Endpoint
    public class BeltEndpoint {

        public static final String NAMESPACE_URI = "http://soap.com/belts";

        private BeltService beltService;

        public BeltEndpoint() {

        }

        @Autowired
        public BeltEndpoint(BeltService beltService) {
            this.beltService = beltService;
        }

        @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllBeltsRequest")
        @ResponsePayload
        public GetAllBeltsResponse getAllBelts(@RequestPayload GetAllBeltsRequest request) {
            GetAllBeltsResponse response = new GetAllBeltsResponse();
            List<Belt> movieTypeList = new ArrayList<>();
            List<BeltEntity> beltEntityList = beltService.getBelts();
            for (BeltEntity entity : beltEntityList) {
                Belt belt = new Belt();
                BeanUtils.copyProperties(entity, belt);
                movieTypeList.add(belt);
            }
            response.getBelts().addAll(movieTypeList);

            return response;

        }
}
