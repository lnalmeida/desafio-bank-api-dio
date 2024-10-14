package dio.edu.bankapi.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity(name = "tbl_accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 4, nullable = false)
    private String agency;
    @Column(precision = 14, scale = 2)
    private BigDecimal balance = BigDecimal.valueOf(0.00);
    @Column(precision = 14, scale = 2)
    private BigDecimal specialLimit = BigDecimal.valueOf(0.00);
}
