package br.com.gestaogastos.cartao.controller;

import br.com.gestaogastos.cartao.dto.CartaoDto;
import br.com.gestaogastos.cartao.model.Cartao;
import br.com.gestaogastos.cartao.service.CartaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cartoes")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @PostMapping
    public void save(@RequestBody Cartao cartao) {
        cartaoService.save(cartao);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CartaoDto> getCartoes(CartaoDto cartaoDto) {
        List<CartaoDto> cartoes = cartaoService.getByFilter(cartaoDto);
        if (cartoes.size() == 0) {
            log.warn("Não foi possível encontrar cartões ao efetuar a busca.");
        }

        return cartoes;
    }

    @RequestMapping(value = "/{cartaoId}", method = RequestMethod.GET)
    public CartaoDto getById(@PathVariable Integer cartaoId) {
        return cartaoService.findById(cartaoId);
    }

}
