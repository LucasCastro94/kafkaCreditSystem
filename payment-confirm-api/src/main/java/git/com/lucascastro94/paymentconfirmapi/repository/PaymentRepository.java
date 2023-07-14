package git.com.lucascastro94.paymentconfirmapi.repository;

import git.com.lucascastro94.Purchase;
import git.com.lucascastro94.paymentconfirmapi.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@EnableJpaRepositories
public interface PaymentRepository extends JpaRepository<Payment, Long> {
   Payment findByPurchaseId(long purchase_id);
}
