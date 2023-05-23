package schwarz.it.lws.kudocards.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import schwarz.it.lws.kudocards.model.KudoCard;
import schwarz.it.lws.kudocards.model.KudoImage;
import schwarz.it.lws.kudocards.model.KudoMessage;
import schwarz.it.lws.kudocards.repository.KudoCardRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class KudoCardServiceTest {

    @Autowired
    KudoCardService kudoCardService;

    @MockBean
    KudoCardRepository kudoCardRepository;

    @Test
    void readKudoCards() {
        // given
        when(kudoCardRepository.findAll()).thenReturn(
                Arrays.asList(
                        KudoCard.builder().build(),
                        KudoCard.builder().build(),
                        KudoCard.builder().build()
                )
        );

        // when
        List<KudoCard> kudoCards = kudoCardService.readKudoCards();

        //then
        assertThat(kudoCards.size()).isEqualTo(3);

    }

    @Test
    void readKudoCardById() {
        // given
        Long id = 1000L;

        when(kudoCardRepository.findById(id)).thenReturn(
                Optional.of(KudoCard.builder().title("Hello").build())
        );

        // when
        KudoCard kudoCard = kudoCardService.readKudoCardById(id);

        //then
        assertThat(kudoCard.getTitle()).isEqualTo("Hello");
    }

    @Test
    void createKudoCard() {
        // given
        KudoCard kudoCard = KudoCard.builder()
                .title("Hello World")
                .kudoImage(KudoImage.builder().build())
                .kudoMessage(KudoMessage.builder().build())
                .build();

        when(kudoCardRepository.save(kudoCard)).thenReturn(
                mockSave(kudoCard)
        );

        // when
        KudoCard createdKudoCard = kudoCardService.createKudoCard(kudoCard);

        // then
        assertThat(createdKudoCard.getId()).isGreaterThan(0);
    }

    @Test
    void deleteKudoCardById() {
        // given
        Long id = 1000L;

        when(kudoCardRepository.findById(id)).thenReturn(
            Optional.of(KudoCard.builder().id(1000L).build())
        );

        doNothing().when(kudoCardRepository).delete(any());

        // when
        kudoCardService.deleteKudoCardById(id);

        // then
        verify(kudoCardRepository, times(1)).delete(any());
    }

    @Test
    void updateKudoCard() {
        // given
        KudoCard kudoCard = KudoCard.builder()
                .id(1000L)
                .title("Hello World")
                .kudoMessage(KudoMessage.builder().build())
                .kudoImage(KudoImage.builder().build())
                .build();

        when(kudoCardRepository.findById(1000L)).thenReturn(
            Optional.of(kudoCard)
        );

        when(kudoCardRepository.save(kudoCard)).thenReturn(
                kudoCard
        );

        // when
        KudoCard updatedKudoCard = kudoCardService.updateKudoCard(kudoCard);

        // then
        assertThat(updatedKudoCard).isEqualTo(kudoCard);
    }

    private KudoCard mockSave(KudoCard kudoCard) {
        kudoCard.setId(1000L);
        return kudoCard;
    }
}
