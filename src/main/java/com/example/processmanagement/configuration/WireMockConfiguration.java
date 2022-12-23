package com.example.processmanagement.configuration;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.common.ClasspathFileSource;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.standalone.JsonFileMappingsSource;
import com.github.tomakehurst.wiremock.standalone.MappingsSource;
import com.github.tomakehurst.wiremock.stubbing.StubImport;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import org.apache.http.impl.conn.Wire;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wiremock.com.github.jknack.handlebars.internal.Files;

import java.io.IOException;
import java.nio.charset.Charset;

import static java.util.Collections.singletonList;
import static org.springframework.cloud.contract.wiremock.WireMockSpring.options;

@Configuration
public class WireMockConfiguration {

    @Value("${ser.apiStubs}")
    private String apiStubs;

    @Bean
    public void wireMockOptions() throws IOException {
        var resource = new JsonFileMappingsSource(new ClasspathFileSource("mappings"));
        WireMockServer server = new WireMockServer(options().port(8081).mappingSource(resource));
        server.start();
    }
}
