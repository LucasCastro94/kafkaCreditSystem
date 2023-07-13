package git.com.lucascastro94.paymentconfirmapi.repository;

import git.com.lucascastro94.paymentconfirmapi.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
