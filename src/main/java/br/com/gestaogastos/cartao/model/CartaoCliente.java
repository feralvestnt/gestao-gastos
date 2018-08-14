package br.com.gestaogastos.cartao.model;

import br.com.gestaogastos.cartao.enums.ETipoCartao;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@SequenceGenerator(name="CARTAO_CLIENTE_ID_SEQ", sequenceName="CARTAO_CLIENTE_ID_SEQ", allocationSize = 1)
@Table(name = "CARTAO_CLIENTE")
public class CartaoCliente {

    @Id
    @GeneratedValue(generator = "CARTAO_CLIENTE_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CARTAO_FK", foreignKey = @ForeignKey(name = "FK_CARTAO_CLIENTE"))
    private Cartao cartao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENTE_FK", foreignKey = @ForeignKey(name = "FK_CLIENTE_CARTAO"))
    private Cliente cliente;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "NUMERO_FINAL")
    private String numeroFinal;

    @Column(name = "CODIGO_CVC")
    private String codigoFinal;

    @Column(name = "CONTA")
    private String conta;

    @Column(name = "AGENCIA")
    private String agencia;

    @Column(name = "DATA_VALIDADE")
    private String dataValidade;

    @Column(name = "TIPO")
    private ETipoCartao tipoCartao;

}
