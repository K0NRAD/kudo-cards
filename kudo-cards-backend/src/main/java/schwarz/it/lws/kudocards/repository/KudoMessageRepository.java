package schwarz.it.lws.kudocards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import schwarz.it.lws.kudocards.model.KudoMessage;

public interface KudoMessageRepository extends JpaRepository<KudoMessage, Long> {
}
