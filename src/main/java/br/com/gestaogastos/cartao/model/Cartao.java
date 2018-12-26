package br.com.gestaogastos.cartao.model;

import lombok.Data;
import org.javamoney.moneta.Money;

import javax.persistence.*;

@Data
@Entity
@SequenceGenerator(name="CARTAO_ID_SEQ", sequenceName="CARTAO_ID_SEQ", allocationSize = 1)
@Table(name = "CARTAO")
public class Cartao {

    @Id
    @GeneratedValue(generator = "CARTAO_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "LIMITE")
    private Money limite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_BANCO", nullable = false, foreignKey = @ForeignKey(name = "FK_BANCO_CARTAO"))
    private Banco banco;

    public Cartao() {}

    public Cartao(String nome, Banco banco) {
        this.nome = nome;
        this.banco = banco;
    }

    public static Cartao withBanco(String nome, Banco banco) {
        return new Cartao(nome, banco);
    }
}
