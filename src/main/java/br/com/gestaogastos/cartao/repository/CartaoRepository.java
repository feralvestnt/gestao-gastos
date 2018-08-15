package br.com.gestaogastos.cartao.repository;

import br.com.gestaogastos.cartao.model.Banco;
import br.com.gestaogastos.cartao.model.Cartao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CartaoRepository extends CrudRepository<Cartao, Integer>, CartaoRepositoryCustom {

    @Query("update Cartao set nome = ?1, banco = ?2 where id = ?3")
    void updateCartao(String nome, Banco banco, Integer bancoId);
}
