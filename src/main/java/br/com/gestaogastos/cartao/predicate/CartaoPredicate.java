package br.com.gestaogastos.cartao.predicate;

import com.querydsl.core.BooleanBuilder;

import static br.com.gestaogastos.cartao.model.QCartao.cartao;

public class CartaoPredicate {

    private BooleanBuilder builder;

    public CartaoPredicate() {
        this.builder = new BooleanBuilder();
    }

    public BooleanBuilder build() {
        return builder;
    }

    public CartaoPredicate comNome(String nome) {
        if (nome != null) {
            builder.and(cartao.nome.like('%' + nome + '%'));
        }
        return this;
    }

    public CartaoPredicate comId(Integer id) {
        if (id != null) {
            builder.and(cartao.id.eq(id));
        }
        return this;
    }

    public CartaoPredicate comBancoId(Integer bancoId) {
        if (bancoId != null) {
            builder.and(cartao.banco.id.eq(bancoId));
        }
        return this;
    }
}
