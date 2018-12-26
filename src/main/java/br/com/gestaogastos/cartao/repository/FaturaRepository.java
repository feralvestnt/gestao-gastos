package br.com.gestaogastos.cartao.repository;

import br.com.gestaogastos.cartao.model.Fatura;
import org.springframework.data.repository.CrudRepository;

public interface FaturaRepository extends CrudRepository<Fatura, Integer>, FaturaRepositoryCustom {
}
