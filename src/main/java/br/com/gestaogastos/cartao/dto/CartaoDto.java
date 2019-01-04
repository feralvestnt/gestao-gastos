package br.com.gestaogastos.cartao.dto;

import br.com.gestaogastos.cartao.model.Banco;
import lombok.Data;

@Data
public class CartaoDto {

    private Integer id;
    private String nome;
    private Banco banco;

    public CartaoDto(Integer id, String nome, Integer bancoId, String bancoNome) {
        this.id = id;
        this.nome = nome;
        this.banco = new Banco(bancoId, bancoNome);
    }

    public CartaoDto(){}
}
