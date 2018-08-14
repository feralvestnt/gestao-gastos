package br.com.gestaogastos.cartao.model;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@SequenceGenerator(name="GASTO_ID_SEQ", sequenceName="GASTO_ID_SEQ", allocationSize = 1)
@Table(name = "GASTO")
public class Gasto {

    @Id
    @GeneratedValue(generator = "GASTO_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "VALOR")
    private BigDecimal valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CARTAO_FK", foreignKey = @ForeignKey(name = "FK_CARTAO_GASTO"))
    private Cartao cartao;


}
