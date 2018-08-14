package br.com.gestaogastos.cartao.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCartao is a Querydsl query type for Cartao
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCartao extends EntityPathBase<Cartao> {

    private static final long serialVersionUID = 752066555L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCartao cartao = new QCartao("cartao");

    public final QBanco banco;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath nome = createString("nome");

    public QCartao(String variable) {
        this(Cartao.class, forVariable(variable), INITS);
    }

    public QCartao(Path<? extends Cartao> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCartao(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCartao(PathMetadata metadata, PathInits inits) {
        this(Cartao.class, metadata, inits);
    }

    public QCartao(Class<? extends Cartao> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.banco = inits.isInitialized("banco") ? new QBanco(forProperty("banco")) : null;
    }

}

