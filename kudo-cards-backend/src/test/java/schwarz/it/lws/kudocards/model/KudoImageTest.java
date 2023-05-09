package schwarz.it.lws.kudocards.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KudoImageTest {
    @Test
    void createKudoImage() {
        // given
        Long id = 2000L;
        String name = "hero.png";
        byte[] datas = new byte[100];

        // when
        KudoImage kudoImage = new KudoImage(id, name, datas);

        // then
        assertThat( kudoImage).isNotNull();
    }
}
