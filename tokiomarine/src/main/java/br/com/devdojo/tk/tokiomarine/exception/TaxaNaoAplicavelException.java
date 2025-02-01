package br.com.devdojo.tk.tokiomarine.exception;

public class TaxaNaoAplicavelException extends RuntimeException {
    public TaxaNaoAplicavelException(String mensagem) {
        super(mensagem);
    }
}
