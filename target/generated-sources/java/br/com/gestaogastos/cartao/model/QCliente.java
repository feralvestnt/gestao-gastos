package br.com.gestaogastos.cartao.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCliente is a Querydsl query type for Cliente
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCliente extends EntityPathBase<Cliente> {

    private static final long serialVersionUID = 2145401581L;

    public static final QCliente cliente = new QCliente("cliente");

    public final StringPath cpf = createString("cpf");

    public final DateTimePath<java.time.LocalDateTime> dataNascimento = createDateTime("dataNascimento", java.time.LocalDateTime.class);

    public final StringPath email = createString("email");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath nome = createString("nome");

    public QCliente(String variable) {
        super(Cliente.class, forVariable(variable));
    }

    public QCliente(Path<? extends Cliente> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCliente(PathMetadata metadata) {
        super(Cliente.class, metadata);
    }

}

