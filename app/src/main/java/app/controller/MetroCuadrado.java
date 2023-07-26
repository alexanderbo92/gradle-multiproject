package app.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class MetroCuadrado extends PlataformaInmobiliaria {

  @Override
  public String consultar() {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    headers.add("x-api-key", "P1MfFHfQMOtL16Zpg36NcntJYCLFm8FqFfudnavl");
    HttpEntity request = new HttpEntity(headers);
    Map<String, String> params = new HashMap<String, String>();
    ResponseEntity<RespuestaMM> response =
        restTemplate.exchange(
            "https://www.metrocuadrado.com/rest-search/search?realEstateBusinessList=venta&city=bogota&neighborhood=Engativa&realEstateTypeList=casa&from=0&size=50",
            org.springframework.http.HttpMethod.GET,
            request,
            RespuestaMM.class,
            params);

    System.out.println("Respuesta metro cuadrado: " + response.getBody().getTotalHits());
    return response.getBody().getTotalHits() + "";
  }
}
