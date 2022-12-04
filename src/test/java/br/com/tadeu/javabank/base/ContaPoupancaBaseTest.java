package br.com.tadeu.javabank.base;

import br.com.tadeu.javabank.model.ContaPoupanca;

public class ContaPoupancaBaseTest extends ContaBaseTest {
    public static final ContaPoupanca CONTA_POUPANCA = ContaPoupanca.builder().cliente(CLIENTE).banco(BANCO).build();
}
