package git.com.lucascastro94.paymentconfirmapi.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import git.com.lucascastro94.Purchase;
import git.com.lucascastro94.paymentconfirmapi.model.Payment;
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
        System.out.println(purchase.value().getNamePrinted());
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setPaymentDTO(purchase.value());
        ObjectMapper objectMapper = new ObjectMapper();
        Payment payment = objectMapper.convertValue(paymentDTO,Payment.class);
        int b = 2;
        paymentService.savePayment(payment);
    }

}

