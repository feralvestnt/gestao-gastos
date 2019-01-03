package br.com.gestaogastos.cartao.service;

import br.com.gestaogastos.cartao.model.Banco;
import br.com.gestaogastos.cartao.repository.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BancoService {

    @Autowired
    private BancoRepository bancoRepository;

    public List<Banco> obterTodos() {
        return (List) bancoRepository.findAll();
    }
}
