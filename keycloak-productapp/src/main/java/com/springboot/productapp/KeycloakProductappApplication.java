package com.springboot.productapp;

import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class KeycloakProductappApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeycloakProductappApplication.class, args);
	}

}

@Controller
class ProductController {

//   @Autowired ProductService productService;

   @GetMapping(path = "/products")
   public String getProducts(Model model){
      model.addAttribute("products", Arrays.asList("iPad","iPhone","iPod"));
      return "products";
   }

   @GetMapping(path = "/logout")
   public String logout(HttpServletRequest request) throws ServletException {
      request.logout();
      return "/";
   }
   
//   @RestController
//   public class IndexController implements ErrorController{
//
//       private static final String PATH = "/error";
//
////       @RequestMapping(value = PATH)
////       public String error() {
////           return "Error Handling";
////       }
//       
//       @RequestMapping(value = PATH)
//       public void error(HttpServletResponse response) throws IOException {
//            response.sendRedirect("/products");   //provide your error page url or home url
//       }
//
//       public String getErrorPath() {
//           return PATH;
//       }
//   }
}