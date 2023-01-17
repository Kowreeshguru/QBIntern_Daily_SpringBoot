package demo.test1.demo_controller;

import demo.test1.model.Product;
import demo.test1.model.Wholesaler;
import demo.test1.service.impl.ProductOp;
import demo.test1.service.impl.WholesalerOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class wholesaler_controller {
    @Autowired
    WholesalerOp wholesaler;
    wholesaler_controller(){
//        wholesaler.load();
    }

    @GetMapping("/getWholesaler/{a}")
    public Wholesaler add_val(@PathVariable int a) {
        return wholesaler.disp_wholesaler(a);
    }

    @PostMapping("/addWholesaler")
    @ResponseStatus(HttpStatus.CREATED)
    public Wholesaler add_val(@RequestBody Wholesaler a) {
        return wholesaler.add_wholesaler(a);
    }

    @PutMapping("/allocateWholesaler/{w_id}/{p_id}/{pdt_qty}")
    @ResponseStatus(HttpStatus.CREATED)
    public String allocate_wholesaler(@PathVariable int w_id,@PathVariable int p_id,@PathVariable int pdt_qty) {
        return wholesaler.allocate_wholesaler(w_id,p_id,pdt_qty);
    }
}
