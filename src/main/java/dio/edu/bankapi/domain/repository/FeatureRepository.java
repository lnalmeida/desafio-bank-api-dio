package dio.edu.bankapi.repository;

import dio.edu.bankapi.domain.model.FeatureItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends JpaRepository<FeatureItem, Long> {
}
