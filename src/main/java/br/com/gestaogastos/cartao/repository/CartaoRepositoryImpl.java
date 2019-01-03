package br.com.gestaogastos.cartao.repository;

import br.com.gestaogastos.cartao.dto.CartaoDto;
import static br.com.gestaogastos.cartao.model.QBanco.banco;
import static br.com.gestaogastos.cartao.model.QCartao.cartao;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class CartaoRepositoryImpl implements CartaoRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    public List<CartaoDto> getAll(Predicate predicate) {
        return new JPAQueryFactory(entityManager)
                .select(Projections.constructor(CartaoDto.class, cartao.id, cartao.nome, cartao.banco.id))
                .from(cartao)
                .join(cartao.banco, banco)
                .where(predicate)
                .fetch();
    }
}
