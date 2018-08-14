package br.com.gestaogastos.cartao.controller;

import br.com.gestaogastos.cartao.dto.CartaoDto;
import br.com.gestaogastos.cartao.model.Cartao;
import br.com.gestaogastos.cartao.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @PostMapping
    public void save(@RequestBody Cartao cartao) {
        cartaoService.save(cartao);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CartaoDto> getCartoes(CartaoDto cartaoDto) {
        return cartaoService.getByFilter(cartaoDto);
    }

    @RequestMapping(value = "/{cartaoId}", method = RequestMethod.GET)
    public CartaoDto getById(@PathVariable Integer cartaoId) {
        return cartaoService.findById(cartaoId);
    }

}
