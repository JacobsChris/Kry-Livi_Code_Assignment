package kry.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import kry.persistence.domain.WebService;

@Repository
public interface WebServiceRepo extends JpaRepository<WebService, Long> {
}
