package com.example.processmanagement.boundary.client;

import com.example.processmanagement.application.error.SERApiException;
import com.example.processmanagement.boundary.client.error.ProcessNotFoundException;
import com.example.processmanagement.boundary.client.request.SERProcessCreateRequest;
import com.example.processmanagement.boundary.client.request.SERProcessSearchRequest;
import com.example.processmanagement.boundary.client.response.SERProcess;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
//            var uri = new URIBuilder(configuration.getApiUrl())
//                    .addParameter("KUNDENNR", request.contractId())
//                    .addParameter("CLIENT_ORG_ID", Optional.ofNullable(request.clientOrgId()).orElse("DE"))
//                    .addParameter("CLIENT_ID", request.clientId())
//                    .addParameter("SPARTE", request.branch())
//                    .addParameter("VOS_MOP_TYPE_NAME", request.gv1())
//                    .addParameter("VARIANTE1", request.gv2())
//                    .addParameter("LFDNR", request.currentNumber()).build();
            if (!request.contractId().equals("4509516")) {
                throw new URISyntaxException("Bad contractId", "bad parameter");
            }
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(configuration.getApiUrl()))
                    .GET()
                    .build();
            HttpClient httpClient = HttpClient.newBuilder().build();
            var httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if (httpResponse.statusCode() >= 200 && httpResponse.statusCode() < 300) {
                return objectMapper.readValue(httpResponse.body(), new TypeReference<>() {
                });
            } else {
                throw new ProcessNotFoundException("No process found by given criteria: " + request);
            }
        } catch (URISyntaxException exception) {
            throw new ProcessNotFoundException("No process found by given criteria: " + request);
        } catch (IOException | InterruptedException exception) {
            throw new SERApiException("SER API not available", exception);
        }
    }

    public SERProcess create(SERProcessCreateRequest request) {
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(configuration.getApiUrl()))
                    .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(request)))
                    .build();
            HttpClient httpClient = HttpClient.newBuilder().build();
            if (!request.contractId().equals("4509516")) {
                throw new URISyntaxException("Bad contractId", "bad parameter");
            }
            var httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if (httpResponse.statusCode() >= 200 && httpResponse.statusCode() < 300) {
                return objectMapper.readValue(httpResponse.body(), new TypeReference<>() {
                });
            } else {
                throw new ProcessNotFoundException("No process found by given criteria: " + request);
            }
        } catch (IOException | InterruptedException | URISyntaxException exception) {
            throw new SERApiException("SER API not available", exception);
        }
    }
}

@ConfigurationProperties(prefix = "ser")
@Data
class SERClientConfigurationProperties {
    private String apiUrl;
}
