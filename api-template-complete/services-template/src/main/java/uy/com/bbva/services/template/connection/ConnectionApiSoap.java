package uy.com.bbva.services.template.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.WebServiceIOException;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import belt.wsdl.GetAllBeltsRequest;
import belt.wsdl.GetAllBeltsResponse;
import uy.com.bbva.services.commons.exceptions.ServiceException;
import uy.com.bbva.services.commons.utils.LogUtils;

@Component
public class ConnectionApiSoap extends WebServiceGatewaySupport {

    @Autowired
    private LogUtils logger;

    public GetAllBeltsResponse getBelts() throws ServiceException {

        final Long startTime = System.currentTimeMillis();

        try {
            GetAllBeltsRequest request = new GetAllBeltsRequest();

            GetAllBeltsResponse response = (GetAllBeltsResponse) getWebServiceTemplate()
                    .marshalSendAndReceive(request);

            logger.logMonitoreo(this.getClass().getName(), getDefaultUri(),
                    System.currentTimeMillis() - startTime);
            return response;

        } catch (WebServiceIOException webServiceIOException) {

            throw new ServiceException("No se encuntra disponible el servicio", "Conexión rehusada",
                    webServiceIOException);
        }
    }

}
