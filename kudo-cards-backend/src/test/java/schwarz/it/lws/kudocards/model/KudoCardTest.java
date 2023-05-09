package schwarz.it.lws.kudocards.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class KudoCardTest {

    @Test
    void createKudoCard() {
        // given
        Long id = 1000L;
        String title = "Gut gemacht";
        KudoImage kudoImage = new KudoImage();
        KudoMessage kudoMessage = new KudoMessage();

        // when
        KudoCard kudoCard = new KudoCard(id, title, kudoImage, kudoMessage);

        // then
        assertThat(kudoCard).isNotNull();
    }
}
