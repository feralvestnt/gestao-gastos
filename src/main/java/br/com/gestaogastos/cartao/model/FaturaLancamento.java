package br.com.gestaogastos.cartao.model;

import lombok.Data;
import org.javamoney.moneta.Money;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@SequenceGenerator(name="FATURA_LANCAMENTO_ID_SEQ", sequenceName="FATURA_LANCAMENTO_ID_SEQ", allocationSize = 1)
@Table(name = "FATURA_LANCAMENTO")
public class FaturaLancamento {

    @Id
    @GeneratedValue(generator = "FATURA_LANCAMENTO_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "DATA_LANCAMENTO")
    private LocalDateTime dataLancamento;

    @Column(name = "VALOR")
    private Money valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_FATURA", nullable = false, foreignKey = @ForeignKey(name = "FK_FATURA_FATURA_LANCAMENTO"))
    private Fatura fatura;
}
