package schwarz.it.lws.kudocards.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import schwarz.it.lws.kudocards.model.KudoCard;
import schwarz.it.lws.kudocards.repository.KudoCardRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KudoCardService {
    private final KudoCardRepository kudoCardRepository;

    public List<KudoCard> readKudoCards() {
        return kudoCardRepository.findAll();
    }

    public KudoCard readKudoCardById(Long id) {
        return kudoCardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("KudoCard with id %d not found.", id)));
    }

    public KudoCard createKudoCard(KudoCard kudoCard) {
        return kudoCardRepository.save(kudoCard);
    }

    public void deleteKudoCardById(Long id) {
        KudoCard kudoCard = kudoCardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("KudoCard with id %d not found.", id)));
        kudoCardRepository.delete(kudoCard);
    }

    public KudoCard updateKudoCard(KudoCard kudoCard) {
        Long id = kudoCard.getId();
        KudoCard currentKudoCard = kudoCardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("KudoCard with id %d not found.", id)));
        return kudoCardRepository.save(kudoCard);
    }
}
