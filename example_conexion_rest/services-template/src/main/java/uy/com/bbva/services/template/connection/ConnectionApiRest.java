package uy.com.bbva.services.template.connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import uy.com.bbva.services.commons.exceptions.ServiceException;
import uy.com.bbva.services.template.model.Training;
import java.util.List;

@Component
public class ConnectionApiRest {

    @Autowired
    private RestTemplateBuilder bbvaRestTemplateBuilder;

    @Value("${url-api-rest-training}")
    private String urlRestGetTraining;

    public List<Training> getAllTraining(final String requestId, final String channel, final String userId) throws ServiceException {

        RestTemplate restTemplate = bbvaRestTemplateBuilder.build();
        HttpHeaders headers = new HttpHeaders();
        headers.set("requestId", requestId);
        headers.set("channel", channel);
        headers.set("userId",userId);
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        try {
            ResponseEntity<List<Training>> trainingResponse = restTemplate.exchange(
                    urlRestGetTraining, HttpMethod.GET, entity,
                    new ParameterizedTypeReference<List<Training>>() {
                    });
            List<Training> trainings = trainingResponse.getBody();
            return trainings;

        } catch (ResourceAccessException exception) {
            throw new ServiceException("No se encuentra disponible el servidor ", "No se encuentra disponible el servidor ", exception);
        }
    }
}
