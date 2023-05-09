package schwarz.it.lws.kudocards.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import schwarz.it.lws.kudocards.model.KudoCard;
import schwarz.it.lws.kudocards.model.KudoImage;
import schwarz.it.lws.kudocards.model.KudoMessage;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class KudoCardRepositoryTest {

    @Autowired
    KudoCardRepository kudoCardRepository;

    @Test
    void createKudoCard() {
        // given
        KudoCard kudoCard = KudoCard.builder()
                .title("Gut gemacht")
                .kudoMessage(KudoMessage.builder().message("Klasse").category("category1").build())
                .kudoImage(KudoImage.builder().name("image1.png").build())
                .build();

        // when
        KudoCard savedKudoCard = kudoCardRepository.save(kudoCard);

        // then
        assertThat(savedKudoCard).isNotNull();
    }
}
