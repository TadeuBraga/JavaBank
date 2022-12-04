package br.com.tadeu.javabank.base;

import br.com.tadeu.javabank.model.Banco;
import br.com.tadeu.javabank.model.Cliente;

public class ContaBaseTest {
    public static final String NOME_BANCO = "Banco Java";
    public static final String CODIGO = "JAVA";
    public static final Banco BANCO = Banco.builder().nome(NOME_BANCO).codigoInternacional(CODIGO).build();
    public static final String NOME = "Mario da Silva";
    public static final String NUMERO_SOCIAL = "34802203047";
    public static final Cliente CLIENTE = Cliente.builder().nome(NOME).numeroSocial(NUMERO_SOCIAL).build();

}
