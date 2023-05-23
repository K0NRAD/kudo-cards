package schwarz.it.lws.kudocards.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import schwarz.it.lws.kudocards.model.KudoCard;
import schwarz.it.lws.kudocards.service.KudoCardService;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@WebMvcTest(controllers = {KudoCardController.class})
public class KudoCardControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    KudoCardService kudoCardService;

    @Test
    void getKudoCards() throws Exception {

        when(kudoCardService.readKudoCards()).thenReturn(
                Arrays.asList(
                        KudoCard.builder().build(),
                        KudoCard.builder().build(),
                        KudoCard.builder().build()
                )
        );

        mockMvc.perform(MockMvcRequestBuilders.get("/kudocards"))
                .andExpect(
                        MockMvcResultMatchers.status().isOk())
                .andExpect(
                        MockMvcResultMatchers.jsonPath("$.size()").value(3)
                );
        ;
    }
}
