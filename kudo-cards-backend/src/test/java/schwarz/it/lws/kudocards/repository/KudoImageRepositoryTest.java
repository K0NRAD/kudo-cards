package schwarz.it.lws.kudocards.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import schwarz.it.lws.kudocards.model.KudoImage;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class KudoImageRepositoryTest {

    @Autowired
    KudoImageRepository kudoImageRepository;

    @AfterEach
    void tearDown() {
        kudoImageRepository.deleteAll();
    }

    @Test
    void createKudoImage() {
        // given
        KudoImage kudoImage = KudoImage.builder()
                .name("hero.png")
                .datas(new byte[1000])
                .build();

        // when
        KudoImage savedKudoImage = kudoImageRepository.save(kudoImage);

        // then
        assertThat(savedKudoImage.getId()).isGreaterThan(0);
    }

    @Test
    void findAllKudoImages() {
        // given
        List<KudoImage> kudoImages = Arrays.asList(
                KudoImage.builder().name("image1.png").datas(new byte[100]).build(),
                KudoImage.builder().name("image2.png").datas(new byte[100]).build(),
                KudoImage.builder().name("image3.png").datas(new byte[100]).build(),
                KudoImage.builder().name("image4.png").datas(new byte[100]).build(),
                KudoImage.builder().name("image5.png").datas(new byte[100]).build()
        );
        kudoImageRepository.saveAll(kudoImages);

        // when
        List<KudoImage> savedKudoImages = kudoImageRepository.findAll();

        assertThat(savedKudoImages.size()).isEqualTo(5);
        assertThat(savedKudoImages.get(3).getName()).isEqualTo("image4.png");
        assertThat(savedKudoImages.get(3).getId()).isGreaterThan(0);
    }

    @Test
    void findKudoImageByName() {
        // given
        kudoImageRepository.saveAll(
                Arrays.asList(
                        KudoImage.builder().name("image1.png").datas(new byte[100]).build(),
                        KudoImage.builder().name("image2.png").datas(new byte[100]).build(),
                        KudoImage.builder().name("image3.png").datas(new byte[100]).build(),
                        KudoImage.builder().name("image4.png").datas(new byte[100]).build(),
                        KudoImage.builder().name("image5.png").datas(new byte[100]).build()
                )
        );
        String name = "image3.png";

        // when
        List<KudoImage> kudoImages = kudoImageRepository.findByName(name);

        // Then
        assertThat(kudoImages.size()).isEqualTo(1);
    }
}
