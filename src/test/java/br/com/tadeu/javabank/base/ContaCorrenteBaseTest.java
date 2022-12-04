package br.com.tadeu.javabank.base;

import br.com.tadeu.javabank.model.ContaCorrente;

public class ContaCorrenteBaseTest extends ContaBaseTest {
    public static final ContaCorrente CONTA_CORRENTE = ContaCorrente.builder().cliente(CLIENTE).banco(BANCO).build();
}
