package br.com.gestaogastos.cartao.usuario.model;

import br.com.gestaogastos.cartao.enums.ETipoUsuario;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@SequenceGenerator(name="USUARIO_ID_SEQ", sequenceName="USUARIO_ID_SEQ", allocationSize = 1)
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(generator = "USUARIO_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "TIPO_USUARIO")
    private ETipoUsuario tipoUsuario;
}
