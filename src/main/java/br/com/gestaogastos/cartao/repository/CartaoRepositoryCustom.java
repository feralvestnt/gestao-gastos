package br.com.gestaogastos.cartao.repository;

import br.com.gestaogastos.cartao.dto.CartaoDto;
import com.querydsl.core.types.Predicate;

import java.util.List;


public interface CartaoRepositoryCustom {

    List<CartaoDto> getAll(Predicate predicate);
}
