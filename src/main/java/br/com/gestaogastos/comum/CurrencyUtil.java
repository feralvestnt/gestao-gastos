package br.com.gestaogastos.comum;

import javax.money.CurrencyUnit;
import javax.money.Monetary;

public class CurrencyUtil {

    public static CurrencyUnit getCurrencyCode() {
        return Monetary.getCurrency("BRL");
    }
}
