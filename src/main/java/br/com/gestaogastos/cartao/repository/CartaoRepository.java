package br.com.gestaogastos.cartao.repository;

import br.com.gestaogastos.cartao.model.Cartao;
import org.springframework.data.repository.CrudRepository;

public interface CartaoRepository extends CrudRepository<Cartao, Integer>, CartaoRepositoryCustom {


}
