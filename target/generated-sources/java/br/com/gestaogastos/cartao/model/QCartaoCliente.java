package br.com.gestaogastos.cartao.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCartaoCliente is a Querydsl query type for CartaoCliente
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCartaoCliente extends EntityPathBase<CartaoCliente> {

    private static final long serialVersionUID = -1695113857L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCartaoCliente cartaoCliente = new QCartaoCliente("cartaoCliente");

    public final StringPath agencia = createString("agencia");

    public final QCartao cartao;

    public final QCliente cliente;

    public final StringPath codigoFinal = createString("codigoFinal");

    public final StringPath conta = createString("conta");

    public final StringPath dataValidade = createString("dataValidade");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath numero = createString("numero");

    public final StringPath numeroFinal = createString("numeroFinal");

    public final EnumPath<br.com.gestaogastos.cartao.enums.ETipoCartao> tipoCartao = createEnum("tipoCartao", br.com.gestaogastos.cartao.enums.ETipoCartao.class);

    public QCartaoCliente(String variable) {
        this(CartaoCliente.class, forVariable(variable), INITS);
    }

    public QCartaoCliente(Path<? extends CartaoCliente> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCartaoCliente(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCartaoCliente(PathMetadata metadata, PathInits inits) {
        this(CartaoCliente.class, metadata, inits);
    }

    public QCartaoCliente(Class<? extends CartaoCliente> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cartao = inits.isInitialized("cartao") ? new QCartao(forProperty("cartao"), inits.get("cartao")) : null;
        this.cliente = inits.isInitialized("cliente") ? new QCliente(forProperty("cliente")) : null;
    }

}

