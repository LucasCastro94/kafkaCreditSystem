package git.com.lucascastro94.purchaseapi.controller;

import git.com.lucascastro94.Purchase;
import git.com.lucascastro94.purchaseapi.service.PurchaseProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/purchase")
public class PurchaseProducerController {

    @Autowired
    private  PurchaseProducerService service;

    @PostMapping
    void producerPurchase(@RequestBody Purchase purchase)
    {
         service.produce(purchase);
    }
}
