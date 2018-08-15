package br.com.gestaogastos.cartao.controller;

import br.com.gestaogastos.cartao.model.Banco;
import br.com.gestaogastos.cartao.model.Cartao;
import br.com.gestaogastos.cartao.repository.CartaoRepository;
import br.com.gestaogastos.cartao.util.JacksonConverter;
import br.com.gestaogastos.cartao.util.Request;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@WebAppConfiguration
@ActiveProfiles("test")
@Sql({"/cartoes.sql"})
public class CartoesControllerTest {

    @Autowired
    private JacksonConverter jacksonConverter;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private CartaoRepository repository;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void deveRetornarTodos() throws Exception {
        mockMvc.perform(get("/cartoes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(Request.getContentType()))
                .andExpect(jsonPath("$", hasSize(5)))
                .andExpect(jsonPath("$[0].id", is(100)))
                .andExpect(jsonPath("$[0].nome", is("CAIXA CREDITO")))
                .andExpect(jsonPath("$[1].id", is(101)))
                .andExpect(jsonPath("$[1].nome", is("SANTANDER DEBITO")))
                .andExpect(jsonPath("$[2].id", is(102)))
                .andExpect(jsonPath("$[2].nome", is("BRADESCO POUPANÇA")))
                .andExpect(jsonPath("$[3].id", is(103)))
                .andExpect(jsonPath("$[3].nome", is("ITAÚ CREDITO")))
                .andExpect(jsonPath("$[4].id", is(104)))
                .andExpect(jsonPath("$[4].nome", is("BANCO DO BRASIL DEBITO")));
    }

    @Test
    public void deveRetornarPorId() throws Exception {
        mockMvc.perform(get("/cartoes/102")
                .contentType(Request.getContentType()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(Request.getContentType()))
                .andExpect(jsonPath("$.id", is(102)))
                .andExpect(jsonPath("$.nome", is("BRADESCO POUPANÇA")));
    }

    @Test
    public void deveNaoRetornarPorId() throws Exception {
        mockMvc.perform(get("/cartoes/190")
                .contentType(Request.getContentType()))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Cartão não encontrado")));
    }

    @Test
    public void deveRetornarFiltroPorId() throws Exception {
        mockMvc.perform(get("/cartoes?id=100")
                .contentType(Request.getContentType()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(Request.getContentType()))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(100)))
                .andExpect(jsonPath("$[0].nome", is("CAIXA CREDITO")));
    }

    @Test
    public void deveRetornarFiltroPorNome() throws Exception {
        mockMvc.perform(get("/cartoes?nome=CAIXA CREDITO")
                .contentType(Request.getContentType()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(Request.getContentType()))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(100)))
                .andExpect(jsonPath("$[0].nome", is("CAIXA CREDITO")));
    }

    @Test
    public void deveRetornarFiltroPorIdENome() throws Exception {
        mockMvc.perform(get("/cartoes?id=100&nome=CAIXA CREDITO")
                .contentType(Request.getContentType()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(Request.getContentType()))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(100)))
                .andExpect(jsonPath("$[0].nome", is("CAIXA CREDITO")));
    }

    @Test
    public void deveNaoRetornarFiltroPorIdENome() throws Exception {
        mockMvc.perform(get("/cartoes?id=101&nome=CAIXA CREDITO")
                .contentType(Request.getContentType()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(Request.getContentType()))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void deveRetornarFiltroPorNomeEBancoId() throws Exception {
        mockMvc.perform(get("/cartoes?nome=CAIXA CREDITO&bancoId=100")
                .contentType(Request.getContentType()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(Request.getContentType()))
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void deveNaoRetornarFiltroPorNomeEBancoId() throws Exception {
        mockMvc.perform(get("/cartoes?nome=CAIXA CREDITO&bancoId=101")
                .contentType(Request.getContentType()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(Request.getContentType()))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void deveSalvar() throws Exception {
        Cartao cartao = Cartao.withBanco("CAIXA DEBITO", new Banco(100));
        mockMvc.perform(post("/cartoes")
                .content(jacksonConverter.toJson(cartao))
                .contentType(Request.getContentType()))
                .andExpect(status().isOk());

        List<Cartao> cartoes = (List<Cartao>) repository.findAll();

        assertEquals(6, cartoes.size());
    }

}
