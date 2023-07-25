package app.controller;

import base.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

  @RequestMapping("")
  public String irPaginaBienvenida() {
    System.out.println("Saludo:  " + Message.message());
    return "bienvenido";
  }

  @RequestMapping("/health")
  public ResponseEntity<?> health() {
    System.out.println("health");
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
