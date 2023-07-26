package app.controller;

import java.util.Arrays;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class CienCuadras extends PlataformaInmobiliaria {

  @Override
  public String consultar() {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    headers.add(
        "Authorization",
        "Basic MXRjbW03MzQyajY2NjFvNDRnZ2JvNGoxNnA6MTlnYW1hOXJxaXRodHE4OWZkN3NoYzl2Y2xtdXVtbWFoYmJnOTc1ZjJpNzB0dDFrc21saA==");
    headers.add("Content-Type", "application/x-www-form-urlencoded");

    MultiValueMap<String, String> bodyParamMap = new LinkedMultiValueMap<>();
    bodyParamMap.add("grant_type", "client_credentials");

    HttpEntity entity = new HttpEntity<>(bodyParamMap, headers);

    ResponseEntity<RespuestaToken> respuesta =
        restTemplate.postForEntity(
            "https://ciencuadras-prod-api-auth.auth.us-east-1.amazoncognito.com/oauth2/token",
            entity,
            RespuestaToken.class);

    RestTemplate restTemplate2 = new RestTemplate();
    HttpHeaders headers2 = new HttpHeaders();
    headers2.setContentType(MediaType.APPLICATION_JSON);
    headers2.add("Authorization", "Bearer " + respuesta.getBody().getAccess_token());
    headers2.add("Content-Type", "application/json");
    HttpEntity<String> request2 =
        new HttpEntity<>(
            "{\r\n    \"radio\": \"2km\",\r\n    \"size\": 10,\r\n    \"transactionType\": \"venta\",\r\n    \"fromNear\": 0,\r\n    \"from\": 0,\r\n    \"sizeNear\": 20,\r\n    \"project\": false,\r\n    \"offer\": 0,\r\n    \"salePrice\": [\r\n        0,\r\n        200000000\r\n    ],\r\n    \"generalSearch\": \"\",\r\n    \"department\": \"cundinamarca\",\r\n    \"city\": \"bogota\",\r\n    \"sortOrder\": \"desc\",\r\n    \"colombiansAbroad\": false,\r\n    \"expandSearch\": false,\r\n    \"realEstateType\": [\r\n        \"casa\"\r\n    ],\r\n    \"rooms\": [\r\n        \"3\"\r\n    ],\r\n    \"bathrooms\": [\r\n        \"2\"\r\n    ],\r\n    \"garages\": [\r\n        \"1\"\r\n    ],\r\n    \"stratum\": [\r\n        \"3\"\r\n    ]\r\n}",
            headers2);

    System.out.println("Respuesta Token cien cuadras: " + respuesta.getBody().getAccess_token());

    RespuestaCC response =
        restTemplate.postForObject(
            "https://api-backend.ciencuadras.com/prod/search-results/v1",
            request2,
            RespuestaCC.class);
    System.out.println("Respuesta cien cuadras: " + response.isSuccess());
    return response.isSuccess() + "";
  }
}
