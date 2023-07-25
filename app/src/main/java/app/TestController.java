package app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class TestController {

  @RequestMapping("")
  public String irPaginaBienvenida() {
    System.out.println("bienvenido");
    return "bienvenido";
  }

  @RequestMapping("/health")
  public ResponseEntity<?> health() {
	  System.out.println("bienvenido");
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
