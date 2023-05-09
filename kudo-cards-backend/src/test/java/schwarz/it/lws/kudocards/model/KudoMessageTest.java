package schwarz.it.lws.kudocards.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class KudoMessageTest {
    @Test
    void createKudoMessage() {
        Long id = 3000L;
        String message = "Message";
        String category = "category";

        KudoMessage kudoMessage = new KudoMessage(id, message, category);

        assertThat(kudoMessage).isNotNull();
    }
}
