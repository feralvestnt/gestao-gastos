package br.com.gestaogastos.cartao.service;

import br.com.gestaogastos.cartao.model.Cartao;
import br.com.gestaogastos.cartao.model.FaturaLancamento;
import org.javamoney.moneta.Money;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaturaService {

    Logger log = LoggerFactory.getLogger(this.getClass());

    public Money calculaTotalFatura(List<FaturaLancamento> faturaLancamentos) {
        Money total = Money.of(0, "BRL");
        try {
            for (FaturaLancamento fatura : faturaLancamentos) {
                total = total.add(Money.of(fatura.getValor().getNumber(), "BRL"));
            }
        } catch (Exception e) {
            log.error("Erro calculaTotalFatura ", e);
        }
        return total;
    }

    public Money calculaSaldoLimiteFatura(List<FaturaLancamento> faturaLancamentos) {
        Money saldo = Money.of(0, "BRL");
        try {
            Cartao cartao = faturaLancamentos.get(0).getFatura().getCartao();

            Money total = calculaTotalFatura(faturaLancamentos);

            saldo = cartao.getLimite().subtract(total);
        } catch (Exception e) {
            log.error("Erro calculaSaldoLimiteFatura ", e);
        }
        return  saldo;
    }
}
