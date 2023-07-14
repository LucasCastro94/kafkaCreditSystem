package git.com.lucascastro94.paymentconfirmapi.controller;

import git.com.lucascastro94.paymentconfirmapi.model.PaymentDTO;
import git.com.lucascastro94.paymentconfirmapi.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<PaymentDTO> listAll()
    {
        return paymentService.listAll();
    }

    @GetMapping("/{purchase_id}")
    public PaymentDTO findByPurchaseId(@PathVariable long purchase_id)
    {
        return paymentService.findByPurchaseId(purchase_id);
    }


}
