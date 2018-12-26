package br.com.gestaogastos.cartao.predicate;

import br.com.gestaogastos.cartao.model.QCartao;
import com.querydsl.core.BooleanBuilder;

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
            builder.and(QCartao.cartao.nome.like('%' + nome + '%'));
        }
        return this;
    }

    public CartaoPredicate comId(Integer id) {
        if (id != null) {
            builder.and(QCartao.cartao.id.eq(id));
        }
        return this;
    }

    public CartaoPredicate comBancoId(Integer bancoId) {
        if (bancoId != null) {
            builder.and(QCartao.cartao.banco.id.eq(bancoId));
        }
        return this;
    }
}
