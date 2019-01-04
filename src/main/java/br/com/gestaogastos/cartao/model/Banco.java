package br.com.gestaogastos.cartao.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@SequenceGenerator(name="BANCO_ID_SEQ", sequenceName="BANCO_ID_SEQ", allocationSize = 1)
@Table(name = "BANCO")
public class Banco {

    @Id
    @GeneratedValue(generator = "BANCO_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    public Banco() {}

    public Banco(Integer id) {
        this.id = id;
    }

    public Banco(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }


}
