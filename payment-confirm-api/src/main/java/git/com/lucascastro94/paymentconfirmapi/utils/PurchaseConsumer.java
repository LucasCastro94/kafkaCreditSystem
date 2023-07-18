package git.com.lucascastro94.paymentconfirmapi.utils;

import git.com.lucascastro94.Purchase;
import git.com.lucascastro94.paymentconfirmapi.model.PaymentDTO;
import git.com.lucascastro94.paymentconfirmapi.service.PaymentService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PurchaseConsumer {

    @Autowired
    private PaymentService paymentService;

    @KafkaListener(topics = "${topic.name.consumer}",groupId = "group-1")
    public void consumeCustomer(ConsumerRecord<String, Purchase> purchase){
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setPaymentDTO(purchase.value());
        paymentService.savePayment(paymentDTO);
    }

}

