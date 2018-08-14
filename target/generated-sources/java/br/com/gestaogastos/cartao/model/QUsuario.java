package br.com.gestaogastos.cartao.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUsuario is a Querydsl query type for Usuario
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUsuario extends EntityPathBase<Usuario> {

    private static final long serialVersionUID = 1151969313L;

    public static final QUsuario usuario = new QUsuario("usuario");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath login = createString("login");

    public final StringPath senha = createString("senha");

    public final EnumPath<br.com.gestaogastos.cartao.enums.ETipoUsuario> tipoUsuario = createEnum("tipoUsuario", br.com.gestaogastos.cartao.enums.ETipoUsuario.class);

    public QUsuario(String variable) {
        super(Usuario.class, forVariable(variable));
    }

    public QUsuario(Path<? extends Usuario> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUsuario(PathMetadata metadata) {
        super(Usuario.class, metadata);
    }

}

