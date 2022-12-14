package com.example.processmanagement.boundary.client;

import com.example.processmanagement.application.error.SERApiException;
import com.example.processmanagement.boundary.client.error.ProcessNotFoundException;
import com.example.processmanagement.boundary.client.request.SERProcessSearchRequest;
import com.example.processmanagement.boundary.client.response.SERProcess;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Component
@RequiredArgsConstructor
@EnableConfigurationProperties(value = SERClientConfigurationProperties.class)
public class SERClient {

    private final SERClientConfigurationProperties configuration;
    private final ObjectMapper objectMapper;

    public List<SERProcess> searchByCriteria(SERProcessSearchRequest request) {
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(configuration.getApiUrl()))
                    .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(request)))
                    .build();
            HttpClient httpClient = HttpClient.newBuilder().build();
            var httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if (httpResponse.statusCode() >= 200 && httpResponse.statusCode() < 300) {
                return objectMapper.readValue(httpResponse.body(), new TypeReference<>() {
                });
            } else {
                throw new ProcessNotFoundException("No process found by given criteria: " + request);
            }
        } catch (IOException | InterruptedException exception) {
            throw new SERApiException("Couldn't call SER API", exception);
        }

    }
}

@ConfigurationProperties(prefix = "ser")
@Data
class SERClientConfigurationProperties {
    private String apiUrl;
}
