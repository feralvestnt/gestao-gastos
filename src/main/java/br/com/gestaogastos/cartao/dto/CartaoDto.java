package br.com.gestaogastos.cartao.dto;

import lombok.Data;

@Data
public class CartaoDto {

    private Integer id;
    private String nome;
    private Integer bancoId;

    public CartaoDto(Integer id, String nome, Integer bancoId) {
        this.id = id;
        this.nome = nome;
        this.bancoId = bancoId;
    }

    public CartaoDto(){}
}
