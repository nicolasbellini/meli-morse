package ar.com.mercadolibre.morse.controller;

import org.junit.Assert;
import org.junit.Test;
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
    public void test1() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(post("/translate/2human").content(".... --- .-.. .-  -- . .-.. .."))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertTrue(mvcResult.getResponse().getContentAsString().equals("HOLA MELI"));
    }

    @Test
    public void test2() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(post("/translate/2morse").content("HOLA MELI"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertTrue(mvcResult.getResponse().getContentAsString().equals(".... --- .-.. .-  -- . .-.. .."));
    }

}
