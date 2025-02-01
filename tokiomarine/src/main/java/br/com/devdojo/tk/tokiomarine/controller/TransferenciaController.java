package br.com.devdojo.tk.tokiomarine.controller;

import br.com.devdojo.tk.tokiomarine.dto.request.TransferenciaRequest;
import br.com.devdojo.tk.tokiomarine.dto.response.TransferenciaResponse;
import br.com.devdojo.tk.tokiomarine.service.TransferenciaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/transferencias")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService){
        this.transferenciaService = transferenciaService;
    }

    /**
     * Endpoint para agendar uma transferência.
     *
     * @param request Objeto contendo os dados da transferência.
     * @return Detalhes da transferência agendada.
     */
    @PostMapping
    public ResponseEntity<TransferenciaResponse> criarTransferencia(
            @Valid @RequestBody TransferenciaRequest request) {
        TransferenciaResponse response = transferenciaService.agendarTransferencia(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Endpoint para listar todas as transferências.
     *
     * @return Lista de transferências cadastradas.
     */
    @GetMapping
    public ResponseEntity<List<TransferenciaResponse>> listarTodasTransferencias() {
        List<TransferenciaResponse> transferencias = transferenciaService.listarTodasTransferencias();
        return ResponseEntity.ok(transferencias);
    }

    /**
     * Endpoint para listar transferências por data de transferência.
     *
     * @param dataTransferencia Data para filtrar transferências.
     * @return Lista de transferências agendadas para a data fornecida.
     */
    @GetMapping("/data")
    public ResponseEntity<List<TransferenciaResponse>> listarPorData(
            @RequestParam("data") LocalDate dataTransferencia) {
        List<TransferenciaResponse> transferencias = transferenciaService.listarPorData(dataTransferencia);
        return ResponseEntity.ok(transferencias);
    }
}
