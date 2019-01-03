package br.com.gestaogastos.cartao.controller;

import br.com.gestaogastos.cartao.model.Banco;
import br.com.gestaogastos.cartao.service.BancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/bancos")
public class BancoController {

    @Autowired
    private BancoService bancoService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Banco> getBancos() {
        return bancoService.obterTodos();
    }
}
