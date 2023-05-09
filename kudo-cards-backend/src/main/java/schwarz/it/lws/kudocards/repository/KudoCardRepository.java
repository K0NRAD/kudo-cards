package schwarz.it.lws.kudocards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import schwarz.it.lws.kudocards.model.KudoCard;

public interface KudoCardRepository extends JpaRepository<KudoCard, Long> {
}
