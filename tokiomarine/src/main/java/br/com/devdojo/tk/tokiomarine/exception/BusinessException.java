package br.com.devdojo.tk.tokiomarine.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final String codigoErro;

    /**
     * Construtor para BusinessException.
     *
     * @param mensagemErro Mensagem de erro detalhada.
     * @param codigoErro   Código do erro associado (ex.: "PERIODO_INVALIDO").
     */
    public BusinessException(String mensagemErro, String codigoErro) {
        super(mensagemErro);
        this.codigoErro = codigoErro;
    }
}