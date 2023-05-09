package schwarz.it.lws.kudocards.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class KudoImage {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(length = 64000)
    private byte[] datas;
}
