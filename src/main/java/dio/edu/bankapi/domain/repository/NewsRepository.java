package dio.edu.bankapi.domain.repository;

import dio.edu.bankapi.domain.model.NewsItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<NewsItem, Long> {
}
