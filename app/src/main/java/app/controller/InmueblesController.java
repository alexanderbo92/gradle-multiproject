package app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/inmuebles")
public class InmueblesController {

  public String fincaRaiz() {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> request =
        new HttpEntity<>(
            "{\r\n    \"filter\": {\r\n        \"offer\": {\r\n            \"slug\": [\r\n                \"rent\"\r\n            ]\r\n        },\r\n        \"property_type\": {\r\n            \"slug\": [\r\n                \"apartment\"\r\n            ]\r\n        },\r\n        \"location_path\": \"bogota\",\r\n        \"price\": {\r\n            \"gte\": 1000000,\r\n            \"lte\": 2500000\r\n        }\r\n    },\r\n    \"fields\": {\r\n        \"exclude\": [],\r\n        \"facets\": [],\r\n        \"include\": [\r\n            \"area\",\r\n            \"baths.id\",\r\n            \"baths.name\",\r\n            \"baths.slug\",\r\n            \"client.client_type\",\r\n            \"client.company_name\",\r\n            \"client.first_name\",\r\n            \"client.fr_client_id\",\r\n            \"client.last_name\",\r\n            \"client.logo.full_size\",\r\n            \"garages.name\",\r\n            \"is_new\",\r\n            \"locations.cities.fr_place_id\",\r\n            \"locations.cities.name\",\r\n            \"locations.cities.slug\",\r\n            \"locations.countries.fr_place_id\",\r\n            \"locations.countries.name\",\r\n            \"locations.countries.slug\",\r\n            \"locations.groups.name\",\r\n            \"locations.groups.slug\",\r\n            \"locations.groups.subgroups.name\",\r\n            \"locations.groups.subgroups.slug\",\r\n            \"locations.neighbourhoods.fr_place_id\",\r\n            \"locations.neighbourhoods.name\",\r\n            \"locations.neighbourhoods.slug\",\r\n            \"locations.states.fr_place_id\",\r\n            \"locations.states.name\",\r\n            \"locations.states.slug\",\r\n            \"locations.location_point\",\r\n            \"max_area\",\r\n            \"max_price\",\r\n            \"media.photos.list.image.full_size\",\r\n            \"media.photos.list.is_main\",\r\n            \"media.videos.list.is_main\",\r\n            \"media.videos.list.video\",\r\n            \"media.logo.full_size\",\r\n            \"min_area\",\r\n            \"min_price\",\r\n            \"offer.name\",\r\n            \"price\",\r\n            \"products.configuration.tag_id\",\r\n            \"products.configuration.tag_name\",\r\n            \"products.label\",\r\n            \"products.name\",\r\n            \"products.slug\",\r\n            \"property_id\",\r\n            \"property_type.name\",\r\n            \"fr_property_id\",\r\n            \"fr_parent_property_id\",\r\n            \"rooms.id\",\r\n            \"rooms.name\",\r\n            \"rooms.slug\",\r\n            \"stratum.name\",\r\n            \"title\"\r\n        ],\r\n        \"limit\": 25,\r\n        \"offset\": 0,\r\n        \"ordering\": [],\r\n        \"platform\": 41,\r\n        \"with_algorithm\": false\r\n    }\r\n}",
            headers);
    Resp response =
        restTemplate.postForObject(
            "https://api.fincaraiz.com.co/document/api/1.0/listing/search", request, Resp.class);
    System.out.println("Respuesta finca raiz: " + response.getTook());
    return response.getTook();
  }

  public boolean cienCuadras() {
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
    return response.isSuccess();
  }

  public int metroCuadrado() {
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
    return response.getBody().getTotalHits();
  }

  @RequestMapping("/listar")
  public String listarInmuebles(Model model) {

    //		long inicio = System.currentTimeMillis();
    //		PlataformaInmobiliaria pa = new FincaRaiz();
    //		PlataformaInmobiliaria pb = new MetroCuadrado();
    //		PlataformaInmobiliaria pc = new CienCuadras();
    //
    //		CompletableFuture<String> future1
    //		  = CompletableFuture.supplyAsync(() -> pa.consultar() );
    //		CompletableFuture<String> future2
    //		  = CompletableFuture.supplyAsync(() -> pb.consultar() );
    //		CompletableFuture<String> future3
    //		  = CompletableFuture.supplyAsync(() -> pc.consultar() );
    //			CompletableFuture<Void> allOfFutures = CompletableFuture.allOf(future1, future2, future3);
    //
    //		String resultado = Stream.of(future1, future2, future3)
    //				  .map(CompletableFuture::join)
    //				  .collect(Collectors.joining(" "));
    //
    //		long fin = System.currentTimeMillis();
    //		long tiempo = fin - inicio;
    //		model.addAttribute("tiempototal", tiempo);
    //		System.out.println(tiempo +" milisegundos");
    //		System.out.println("resultado: "+resultado);
    //		model.addAttribute("unionresultados", resultado);

    // paralelo
    long inicio = System.currentTimeMillis();
    List<PlataformaInmobiliaria> lista = new ArrayList<>();
    PlataformaInmobiliaria pa = new FincaRaiz();
    PlataformaInmobiliaria pb = new MetroCuadrado();
    PlataformaInmobiliaria pc = new CienCuadras();
    lista.add(pa);
    lista.add(pb);
    lista.add(pc);

    List<CompletableFuture<String>> list = new ArrayList<>();
    String resultado = "";
    for (PlataformaInmobiliaria plataforma : lista) {
      CompletableFuture<String> future =
          CompletableFuture.supplyAsync(() -> plataforma.consultar());
      list.add(future);
    }
    for (CompletableFuture<String> completableFuture : list) {
      resultado += completableFuture.join() + " ";
    }
    System.out.println("resultado " + resultado);
    model.addAttribute("unionresultados", resultado);
    long fin = System.currentTimeMillis();
    long tiempo = fin - inicio;
    model.addAttribute("tiempototal", tiempo);
    System.out.println(tiempo + " milisegundos");

    // inicio secuencial
    //		long inicio = System.currentTimeMillis();
    //		/*
    //		model.addAttribute("fincaraiz", fincaRaiz());
    //		model.addAttribute("ciencuadras", cienCuadras());
    //		model.addAttribute("metrocuadrado", metroCuadrado());
    //		*/
    //		model.addAttribute("unionresultados",
    //				fincaRaiz()+" "+cienCuadras()+" "+metroCuadrado());
    //		long fin = System.currentTimeMillis();
    //        long tiempo = fin - inicio;
    //        model.addAttribute("tiempototal", tiempo);
    //        System.out.println(tiempo +" milisegundos");
    // fin secuencial

    return "inmuebles";
  }
}
