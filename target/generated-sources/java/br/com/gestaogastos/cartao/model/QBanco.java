package br.com.gestaogastos.cartao.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBanco is a Querydsl query type for Banco
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBanco extends EntityPathBase<Banco> {

    private static final long serialVersionUID = 161879662L;

    public static final QBanco banco = new QBanco("banco");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath nome = createString("nome");

    public QBanco(String variable) {
        super(Banco.class, forVariable(variable));
    }

    public QBanco(Path<? extends Banco> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBanco(PathMetadata metadata) {
        super(Banco.class, metadata);
    }

}

