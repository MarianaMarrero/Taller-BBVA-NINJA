
package uy.com.bbva.services.template.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import uy.com.bbva.services.template.connection.ConnectionApiSoap;


@Configuration
public class BeltConfiguration {

    @Value("${url-api-soap-belts}")
    private String urlSoapBelt;

    @Value("${content-path-wsdl}")
    private String contentPathWsdlBelt;

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(contentPathWsdlBelt);
        return marshaller;
    }
    @Bean
    public ConnectionApiSoap connectionApiSoap(Jaxb2Marshaller marshaller) {
        ConnectionApiSoap client = new ConnectionApiSoap();
        client.setDefaultUri(urlSoapBelt);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
