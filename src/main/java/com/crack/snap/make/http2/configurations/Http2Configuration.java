package com.crack.snap.make.http2.configurations;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.http2.Http2Protocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.Ssl;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mohan Sharma
 */
@Configuration
@Slf4j
public class Http2Configuration {

    @Value("${ssl.keystore}")
    private String keystore;
    @Value("${ssl.keystore.password}")
    private String password;
    @Value("${ssl.keystore.type}")
    private String keyStoreType;
    @Value("${ssl.key.alias}")
    private String keyAlias;

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> tomcatCustomizer() {
        return factory -> {
            // Enable SSL
            Ssl ssl = new Ssl();
            ssl.setKeyStore(keystore);
            ssl.setKeyStorePassword(password);
            ssl.setKeyStoreType(keyStoreType);
            ssl.setKeyAlias(keyAlias);
            factory.setSsl(ssl);

            // Enable HTTP/2
            factory.addConnectorCustomizers(connector -> connector.addUpgradeProtocol(new Http2Protocol()));
        };
    }
}
