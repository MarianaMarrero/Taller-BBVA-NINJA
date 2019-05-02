package uy.com.bbva.apis.template.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import uy.com.bbva.services.commons.exceptions.BusinessException;
import uy.com.bbva.services.commons.exceptions.ServiceException;
import uy.com.bbva.services.commons.utils.LogUtils;

import java.io.IOException;

@RestController
@RequestMapping("/template")
public class DummyController {
    @Autowired
    private LogUtils logger;

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("hello")
    public String hello() throws ServiceException {
        String message = "<br><div style='text-align:center;'><h3>********** Bienvenido a " + this.applicationName + " **********</div><br><br>";
        return message;
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable(value = "name") String name) throws ServiceException {
        String message = "<br><div style='text-align:center;'><h3>********** Bienvenido a " + this.applicationName + " " + name + " **********</div><br><br>";
        return message;
    }

    @GetMapping("log/error")
    public ResponseEntity<JsonNode> logError(
            @RequestParam(name = "message", required = false) String message,
            @RequestParam(name = "internalMessage", required = false) String internalMessage) throws IOException {
        /***************************************************************************************
         COSAS MALAS: NO UTILIZAR NUNCA logger.logError.
         Usar throw new BusinessException(...) o throw new ServiceException(...)
         Este ejemplo es para comprender cómo se usa el logger dentro de las apis commons
         ***************************************************************************************/
        logger.logError(this.getClass().getName(),
                StringUtils.isEmpty(message)?"logError":message,
                StringUtils.isEmpty(internalMessage)?"logError":internalMessage);
        return new ResponseEntity<JsonNode>(HttpStatus.OK);
    }

    @GetMapping("log/debug")
    public ResponseEntity<JsonNode> logDebug(@RequestParam(name = "message", required = false) String message,
                                             @RequestParam(name = "internalMessage", required = false) String internalMessage) throws IOException {
        /***************************************************************************************
         COSAS MALAS: NO UTILIZAR NUNCA logger.logDebug.
         Usar throw new BusinessException(...) o throw new ServiceException(...)
         Este ejemplo es para comprender cómo se usa el logger dentro de las apis commons
         ***************************************************************************************/
        logger.logDebug(this.getClass().getName(),
                StringUtils.isEmpty(message)?"logDebug":message,
                StringUtils.isEmpty(internalMessage)?"logDebug":internalMessage);
        return new ResponseEntity<JsonNode>(HttpStatus.OK);
    }

    @GetMapping("log/business")
    public ResponseEntity<JsonNode> logBusiness(@RequestParam(name = "message", required = false) String message,
                                                @RequestParam(name = "internalMessage", required = false) String internalMessage,
                                                @RequestParam(name = "internalCode", required = false) String internalCode) throws IOException {
        /***************************************************************************************
         COSAS MALAS: NO UTILIZAR NUNCA logger.logBusiness.
         Usar throw new BusinessException(...) o throw new ServiceException(...)
         Este ejemplo es para comprender cómo se usa el logger dentro de las apis commons
         ***************************************************************************************/
        logger.logBusiness(this.getClass().getName(),
                StringUtils.isEmpty(message)?"logDebug":message,
                StringUtils.isEmpty(internalMessage)?"logDebug":internalMessage,
                StringUtils.isEmpty(internalCode)?"logDebug":internalCode);
        return new ResponseEntity<JsonNode>(HttpStatus.OK);
    }

    @GetMapping("log/loginError")
    public ResponseEntity<JsonNode> logLoginError(@RequestParam(name = "country", required = false) String country,
                                                  @RequestParam(name = "docType", required = false) String docType,
                                                  @RequestParam(name = "docNumber", required = false) String docNumber,
                                                  @RequestParam(name = "accountUsed", required = false) String accountUsed,
                                                  @RequestParam(name = "user", required = false) String user,
                                                  @RequestParam(name = "code", required = false) String code) throws IOException {
        /***************************************************************************************
         COSAS MALAS: NO UTILIZAR NUNCA logger.logLoginError.
         Usar throw new BusinessException(...) o throw new ServiceException(...)
         Este ejemplo es para comprender cómo se usa el logger dentro de las apis commons
         ***************************************************************************************/
        logger.logLoginError(this.getClass().getName(),
                StringUtils.isEmpty(country)?"logDebug":country,
                StringUtils.isEmpty(docType)?"logDebug":docType,
                StringUtils.isEmpty(docNumber)?"logDebug":docNumber,
                StringUtils.isEmpty(accountUsed)?"logDebug":accountUsed,
                StringUtils.isEmpty(user)?"logDebug":user,
                StringUtils.isEmpty(code)?"logDebug":code);
        return new ResponseEntity<JsonNode>(HttpStatus.OK);
    }

    @GetMapping("log/exception/service")
    public ResponseEntity<JsonNode> logExceptionError(
            @RequestParam(name = "message", required = false) String message,
            @RequestParam(name = "internalMessage", required = false) String internalMessage) throws Exception {
        try{
            throw new Exception("Ejemplo de uso de excepciones de tipo ServiceException en una API GET");
        } catch (Exception exception) {
            throw new ServiceException(StringUtils.isEmpty(message) ? "logError" : message,
                    StringUtils.isEmpty(internalMessage) ? "logError" : internalMessage, exception);
        }
    }

    @PostMapping("log/exception/service")
    public ResponseEntity<JsonNode> logExceptionPostError(@RequestParam(name = "message", required = false) String message,
                                                          @RequestParam(name = "internalMessage", required = false) String internalMessage,
                                                          @RequestParam(name = "internalCode", required = false) String internalCode,
                                                          @RequestBody String body) throws Exception {
        try{
            throw new Exception("Ejemplo de uso de excepciones de tipo ServiceException en una API POST");
        } catch (Exception exception) {
            throw new ServiceException(StringUtils.isEmpty(message) ? "logError" : message,
                    StringUtils.isEmpty(internalMessage) ? "logError" : internalMessage, exception);
        }
    }

    @GetMapping("log/exception/business")
    public ResponseEntity<JsonNode> logExceptionBusiness(@RequestParam(name = "message", required = false) String message,
                                                         @RequestParam(name = "internalMessage", required = false) String internalMessage,
                                                         @RequestParam(name = "internalCode", required = false) String internalCode) throws Exception {
        try{
            throw new Exception("Ejemplo de uso de excepciones de tipo BusinessException en una API GET");
        } catch (Exception exception) {
            throw new BusinessException(StringUtils.isEmpty(message)?"logError":message,
                    StringUtils.isEmpty(internalMessage)?"logError":internalMessage,
                    StringUtils.isEmpty(internalCode)?"logDebug":internalCode,
                    exception);
        }
    }
}
