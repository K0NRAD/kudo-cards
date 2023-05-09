package schwarz.it.lws.kudocards.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class KudoCard {
    @Id
    @GeneratedValue
    private Long id;
    private String title;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private KudoImage kudoImage;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private KudoMessage kudoMessage;
}
