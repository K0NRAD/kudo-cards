package schwarz.it.lws.kudocards.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "kudo_card", schema = "kudocarddb")
public class KudoCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "kudo_image_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_kudocard_kudoimage"))
    private KudoImage kudoImage;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "kudo_message_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_kudocard_kudomessage"))
    private KudoMessage kudoMessage;
}
