package demo.test1.demo_controller;

//import demo.test1.api.Product;
//import demo.test1.model.ProductDetails;
import demo.test1.model.Employee;
import demo.test1.model.Product;
import demo.test1.service.impl.ProductOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import demo.test1.model.add;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class Hello_worldController {

    @Autowired
    ProductOp product;
    Hello_worldController(){
//        product.load();
    }

    @GetMapping("/getProduct/{a}")
    public Product add_val(@PathVariable int a) {
        return product.disp_product(a);
    }

    @PostMapping("/addProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public Product add_val(@RequestBody Product a) {
        return product.add_product(a);
    }
//    @PostMapping("users")
//    @ResponseStatus(HttpStatus.CREATED)
//    public User[] registerUserCredential(@RequestBody User[] user) {
//        for(User u: user) {
//            System.out.println("User ID: " + u.getUserName());
//            System.out.println("User ID: " + u.getPassword());
//        }
//        return user;
//    }
//
//    @GetMapping("/greeting")
//    public ResponseEntity<String> greeting(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) String language) {
//        // code that uses the language variable
//        return new ResponseEntity<String>(greeting, HttpStatus.OK);
//    }
}

