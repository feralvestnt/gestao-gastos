package br.com.gestaogastos.cartao.repository;

import br.com.gestaogastos.cartao.model.Banco;
import br.com.gestaogastos.cartao.model.Cartao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles("test")
@Sql({"/cartao.sql"})
public class CartaoRepositoryTest {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Test
    public void deveSalvarERetornarPorId() throws Exception {

        Cartao cartao = new Cartao("Cartão CAIXA", new Banco(100));
        cartaoRepository.save(cartao);

        List<Cartao> cartoes = (List) cartaoRepository.findAll();

        Assert.assertEquals(6, cartoes.size());
    }

    @Test
    public void deveNaoEncontrar() throws Exception {

        Optional<Cartao> cartao = cartaoRepository.findById(1000);

        Assert.assertEquals(false, cartao.isPresent());
    }

}
