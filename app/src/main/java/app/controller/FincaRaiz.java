package app.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class FincaRaiz extends PlataformaInmobiliaria {

  @Override
  public String consultar() {
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
}
