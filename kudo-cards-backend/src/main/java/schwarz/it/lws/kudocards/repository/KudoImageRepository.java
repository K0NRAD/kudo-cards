package schwarz.it.lws.kudocards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import schwarz.it.lws.kudocards.model.KudoImage;

import java.util.List;

public interface KudoImageRepository extends JpaRepository<KudoImage, Long> {
    List<KudoImage> findByName(String name);
}
