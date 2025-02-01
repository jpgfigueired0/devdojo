import { Component } from '@angular/core';
import { TransferenciaService, Transferencia } from '../../services/transferencia.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-agendar-transferencia',
  standalone: false,
  templateUrl: './agendar-transferencia.component.html',
})
export class AgendarTransferenciaComponent {
  transferencia: Transferencia = {
    contaOrigem: '',
    contaDestino: '',
    valor: 0,
    dataTransferencia: '',
  };

  mensagem: string = '';

  constructor(
    private transferenciaService: TransferenciaService,
    private router: Router
  ) {}

  navegarParaListar(): void {
    this.router.navigate(['/transferencias/listar']);
  }

  agendar(): void {
    this.transferenciaService.agendarTransferencia(this.transferencia).subscribe({
      next: (res) => {
        this.mensagem = 'Transferência agendada com sucesso!';
        console.log('Resposta da API:', res);
      },
      error: (err) => {
        this.mensagem = 'Erro ao agendar transferência!';
        console.error('Erro da API:', err);
      },
    });
  }
}
