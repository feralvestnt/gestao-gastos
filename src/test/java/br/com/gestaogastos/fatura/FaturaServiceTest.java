package br.com.gestaogastos.fatura;

import br.com.gestaogastos.cartao.model.Cartao;
import br.com.gestaogastos.cartao.model.Fatura;
import br.com.gestaogastos.cartao.model.FaturaLancamento;
import br.com.gestaogastos.cartao.service.FaturaService;
import br.com.gestaogastos.comum.CurrencyUtil;
import org.javamoney.moneta.Money;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.money.CurrencyUnit;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class FaturaServiceTest {

    @Autowired
    private FaturaService faturaService;

    private static CurrencyUnit CURRENCY_TYPE = CurrencyUtil.getCurrencyCode();

    @Test
    public void deveCalcularTotalFatura() {
        Money total = faturaService.calculaTotalFatura(getFaturaLancamentos());

        Assert.assertEquals(Money.of(595.94, CURRENCY_TYPE), total);
    }

    @Test
    public void deveCalcularSaldoLimiteCartao() {
        Money saldoLimite = faturaService.calculaSaldoLimiteFatura(getFaturaLancamentos());

        Assert.assertEquals(Money.of(7404.06,CURRENCY_TYPE), saldoLimite);
    }

    public static List<FaturaLancamento> getFaturaLancamentos() {

        return Arrays.asList(createFaturaLancamentoToCalc( Money.of(115.65, CURRENCY_TYPE)),
                            createFaturaLancamentoToCalc( Money.of(135.18, CURRENCY_TYPE)),
                            createFaturaLancamentoToCalc( Money.of(345.11, CURRENCY_TYPE))
        );
    }

    public static FaturaLancamento createFaturaLancamentoToCalc(Money valor) {
        FaturaLancamento faturaLancamento = new FaturaLancamento();
        faturaLancamento.setValor(valor);

        Cartao cartao = new Cartao();
        cartao.setId(100);
        cartao.setLimite(Money.of(8000, CURRENCY_TYPE));
        Fatura fatura = new Fatura();
        fatura.setCartao(cartao);

        faturaLancamento.setFatura(fatura);

        return faturaLancamento;
    }
}
