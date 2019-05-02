package uy.com.bbva.apis.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uy.com.bbva.services.commons.exceptions.ServiceException;
import uy.com.bbva.services.commons.utils.LogUtils;
import uy.com.bbva.services.template.service.BeltService;

import java.util.Map;

@RestController
@RequestMapping("/belts")
public class BeltController {

    @Autowired
    private BeltService beltService;

    @Autowired
    private LogUtils logger;

    /***************************************************************************/
    /*********************  Ejemplo conexión al servicio SOAP   ****************/
    @GetMapping()
    public Map<Long, String> getBelts()
            throws ServiceException {

        logger.logDebug(this.getClass().getName(), "Call business service", "Internal message");

        return beltService.getBelts();
    }
}
