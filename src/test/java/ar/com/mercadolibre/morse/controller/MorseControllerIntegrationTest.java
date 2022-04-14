package ar.com.mercadolibre.morse.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MorseControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Endpoint should return 200 and return a translated morse code to human")
    public void testTranslate2HumanEndpoint() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(post("/translate/2human").param("morse",".... --- .-.. .-  -- . .-.. .."))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertTrue(mvcResult.getResponse().getContentAsString().equals("HOLA MELI"));
    }

    @Test
    @DisplayName("Endpoint should return 200 and return a translated human to morse code")
    public void testTranslate2MorseEndPoint() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(post("/translate/2morse").param("text","HOLA MELI"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertTrue(mvcResult.getResponse().getContentAsString().equals(".... --- .-.. .-  -- . .-.. .."));
    }

}
