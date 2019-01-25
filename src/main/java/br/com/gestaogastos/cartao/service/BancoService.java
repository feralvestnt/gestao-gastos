package br.com.gestaogastos.cartao.service;

import br.com.gestaogastos.cartao.model.Banco;
import br.com.gestaogastos.cartao.repository.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BancoService {

    @Autowired
    private BancoRepository bancoRepository;

    public List<Banco> obterTodos() {
        List<Banco> bancoList = Arrays.asList(new Banco(1, "Santander"), new Banco(2, "Caixa")
                , new Banco(3, "Itaú"), new Banco(4, "Banco do Brasil"));

        bancoList.forEach(banco -> {
            bancoRepository.save(banco);
        });

        return (List) bancoRepository.findAll();
    }
}
