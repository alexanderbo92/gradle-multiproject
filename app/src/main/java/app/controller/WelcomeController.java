package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

  @RequestMapping("")
  public String irPaginaBienvenida(Model model) {
    return "bienvenido";
  }
}
