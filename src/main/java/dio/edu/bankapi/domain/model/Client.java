package dio.edu.bankapi.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity(name = "Tbl_clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(length = 100, nullable = false)
    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    private Account account;

    @OneToOne(fetch = FetchType.EAGER)
    private Card card;

    @OneToMany(fetch = FetchType.EAGER)
    private List<FeatureItem> features;

    @OneToMany(fetch = FetchType.EAGER)
    private List<NewsItem> news;

}
