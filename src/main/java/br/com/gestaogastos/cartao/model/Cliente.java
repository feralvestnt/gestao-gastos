package br.com.gestaogastos.cartao.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@SequenceGenerator(name="CLIENTE_ID_SEQ", sequenceName="CLIENTE_ID_SEQ", allocationSize = 1)
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(generator = "CLIENTE_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CPF", unique = true)
    private String cpf;

    @Column(name = "EMAIL", unique = true)
    private String email;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDateTime dataNascimento;
}
