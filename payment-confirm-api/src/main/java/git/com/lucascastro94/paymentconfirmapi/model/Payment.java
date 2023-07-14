package git.com.lucascastro94.paymentconfirmapi.model;

import git.com.lucascastro94.Purchase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private long id_compra;

    @Column
    private String creditCardNumber;


}
