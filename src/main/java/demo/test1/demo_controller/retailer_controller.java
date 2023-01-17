package demo.test1.demo_controller;

import demo.test1.model.Retailer;
import demo.test1.model.Wholesaler;
import demo.test1.service.impl.RetailerOp;
import demo.test1.service.impl.WholesalerOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class retailer_controller {
    @Autowired
    RetailerOp retailer;
    retailer_controller(){
//        wholesaler.load();
    }

    @GetMapping("/getRetailer/{a}")
    public Retailer add_val(@PathVariable int a) {
        return retailer.disp_retailer(a);
    }

    @PostMapping("/addRetailer")
    @ResponseStatus(HttpStatus.CREATED)
    public Retailer add_val(@RequestBody Retailer a) {
        return retailer.add_retailer(a);
    }

    @PutMapping("/allocateRetailer/{r_id}/{w_id}/{p_id}/{pdt_qty}")
    @ResponseStatus(HttpStatus.CREATED)
    public String allocate_retailer(@PathVariable int r_id,@PathVariable int w_id,@PathVariable int p_id,@PathVariable int pdt_qty) {
        return retailer.allocate_retailer(r_id,w_id,p_id,pdt_qty);
    }
}
