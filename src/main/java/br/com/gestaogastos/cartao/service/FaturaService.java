package br.com.gestaogastos.cartao.service;

import br.com.gestaogastos.cartao.model.Cartao;
import br.com.gestaogastos.cartao.model.FaturaLancamento;
import org.javamoney.moneta.Money;
import org.springframework.stereotype.Service;

import javax.money.MonetaryAmount;
import java.util.List;

@Service
public class FaturaService {

    public Money calculaTotalFatura(List<FaturaLancamento> faturaLancamentos) {

        Money total = Money.of(0, "BRL");

        for (FaturaLancamento fatura : faturaLancamentos) {
            total = total.add(Money.of(fatura.getValor().getNumber(), "BRL"));
        }

        return total;
    }

    public Money calculaSaldoLimiteFatura(List<FaturaLancamento> faturaLancamentos) {
        Cartao cartao = faturaLancamentos.get(0).getFatura().getCartao();

        Money total = calculaTotalFatura(faturaLancamentos);

        return cartao.getLimite().subtract(total);
    }
}
