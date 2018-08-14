package br.com.gestaogastos.cartao.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGasto is a Querydsl query type for Gasto
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGasto extends EntityPathBase<Gasto> {

    private static final long serialVersionUID = 166502599L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGasto gasto = new QGasto("gasto");

    public final QCartao cartao;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath nome = createString("nome");

    public final NumberPath<java.math.BigDecimal> valor = createNumber("valor", java.math.BigDecimal.class);

    public QGasto(String variable) {
        this(Gasto.class, forVariable(variable), INITS);
    }

    public QGasto(Path<? extends Gasto> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGasto(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGasto(PathMetadata metadata, PathInits inits) {
        this(Gasto.class, metadata, inits);
    }

    public QGasto(Class<? extends Gasto> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cartao = inits.isInitialized("cartao") ? new QCartao(forProperty("cartao"), inits.get("cartao")) : null;
    }

}

