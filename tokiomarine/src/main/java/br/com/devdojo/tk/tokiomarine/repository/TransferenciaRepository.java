package br.com.devdojo.tk.tokiomarine.repository;

import br.com.devdojo.tk.tokiomarine.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    /**
     * Busca transferências agendadas para uma data específica.
     *
     * @param dataTransferencia Data de transferência a ser pesquisada.
     * @return Lista de transferências agendadas para a data especificada.
     */
    List<Transferencia> findByDataTransferencia(LocalDate dataTransferencia);

    /**
     * Busca transferências agendadas dentro de um intervalo de datas.
     *
     * @param inicio Data inicial do intervalo.
     * @param fim    Data final do intervalo.
     * @return Lista de transferências dentro do intervalo.
     */
    List<Transferencia> findByDataTransferenciaBetween(LocalDate inicio, LocalDate fim);
}
