package git.com.lucascastro94.purchaseapi.controller;

import git.com.lucascastro94.Purchase;
import git.com.lucascastro94.purchaseapi.service.PurchaseProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/purchase")
@CrossOrigin(origins = "http://localhost:4200")
public class PurchaseProducerController {

    @Autowired
    private  PurchaseProducerService service;

    @PostMapping
    void producerPurchase(@RequestBody Purchase purchase)
    {
         service.produce(purchase);
    }
}
