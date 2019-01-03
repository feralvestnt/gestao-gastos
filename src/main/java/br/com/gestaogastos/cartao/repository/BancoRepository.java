package br.com.gestaogastos.cartao.repository;

import br.com.gestaogastos.cartao.model.Banco;
import org.springframework.data.repository.CrudRepository;

public interface BancoRepository extends CrudRepository<Banco, Integer>{
}
