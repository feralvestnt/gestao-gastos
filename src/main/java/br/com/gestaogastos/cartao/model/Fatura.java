package br.com.gestaogastos.cartao.model;

import lombok.Data;
import org.javamoney.moneta.Money;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@SequenceGenerator(name="FATURA_ID_SEQ", sequenceName="FATURA_ID_SEQ", allocationSize = 1)
@Table(name = "FATURA")
public class Fatura {

    @Id
    @GeneratedValue(generator = "FATURA_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "VALOR_TOTAL")
    private Money valorTotal;

    @Column(name = "DATA_INICIO")
    private LocalDate dataInicio;

    @Column(name = "DATA_FIM")
    private LocalDate dataFim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_CARTAO", nullable = false, foreignKey = @ForeignKey(name = "FK_CARTAO_FATURA"))
    private Cartao cartao;

    private BigDecimal calculaTotalLancamentos() {
        return null;
    }

    private BigDecimal calculaSaldoRestante() {
        return null;
    }
}
