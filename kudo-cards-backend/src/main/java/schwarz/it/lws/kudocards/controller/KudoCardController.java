package schwarz.it.lws.kudocards.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import schwarz.it.lws.kudocards.model.KudoCard;
import schwarz.it.lws.kudocards.service.KudoCardService;

import java.util.List;

@RestController
@RequestMapping("/kudocards")
@RequiredArgsConstructor
public class KudoCardController {
    private final KudoCardService kudoCardService;

    @GetMapping
    public ResponseEntity<List<KudoCard>> getKudoCards() {
        return ResponseEntity.ok(kudoCardService.readKudoCards());
    }
}
