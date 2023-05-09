package schwarz.it.lws.kudocards.repository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import schwarz.it.lws.kudocards.model.KudoMessage;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class KudoMessageRepositoryTest {
    @Autowired
    KudoMessageRepository kudoMessageRepository;

    @Test
    void createKudoMessage() {
        KudoMessage kudoMessage = KudoMessage.builder()
                .message("message")
                .category("category")
                .build();

        KudoMessage savedKudoMessage = kudoMessageRepository.save(kudoMessage);

        assertThat(savedKudoMessage.getId()).isGreaterThan(0);
    }
}
