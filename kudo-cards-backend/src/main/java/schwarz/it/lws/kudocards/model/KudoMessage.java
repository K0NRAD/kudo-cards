package schwarz.it.lws.kudocards.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class KudoMessage {
    @Id
    @GeneratedValue
    private Long id;
    private String message;
    private String category;

}
