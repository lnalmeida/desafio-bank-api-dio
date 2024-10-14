package dio.edu.bankapi.domain.model;

import dio.edu.bankapi.domain.model.abstraction.BaseItemClasse;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tbl_news")
public class NewsItem extends BaseItemClasse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
