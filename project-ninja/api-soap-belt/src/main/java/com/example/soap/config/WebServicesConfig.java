package com.example.soap.config;

import com.example.soap.endpoint.BeltEndpoint;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.context.ApplicationContext;

    @EnableWs
    @Configuration
    public class WebServicesConfig extends WsConfigurerAdapter {

        @SuppressWarnings({"rawtypes", "unchecked"})
        @Bean
        public ServletRegistrationBean messageDispatcherServlet(ApplicationContext appContext) {
            MessageDispatcherServlet servlet = new MessageDispatcherServlet();
            servlet.setApplicationContext(appContext);
            servlet.setTransformWsdlLocations(true);
            return new ServletRegistrationBean(servlet, "/ws/*");
        }

        // localhost:8080/ws/movies.wsdl
        @Bean(name = "belt")
        public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
            DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
            wsdl11Definition.setPortTypeName("BeltPort");
            wsdl11Definition.setLocationUri("/ws/");
            wsdl11Definition.setTargetNamespace(BeltEndpoint.NAMESPACE_URI);
            wsdl11Definition.setSchema(schema);
            return wsdl11Definition;
        }

        @Bean
        public XsdSchema beltSchema() {
            return new SimpleXsdSchema(new ClassPathResource("belt.xsd"));
        }
    }
