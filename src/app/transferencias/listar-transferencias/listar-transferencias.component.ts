import { Component, OnInit } from '@angular/core';
import { TransferenciaService, Transferencia } from '../../services/transferencia.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-listar-transferencias',
  standalone: false,
  templateUrl: './listar-transferencias.component.html',
})
export class ListarTransferenciasComponent implements OnInit {
  transferencias: Transferencia[] = [];

  constructor(
    private transferenciaService: TransferenciaService,
    private router: Router) {}

  ngOnInit(): void {
    this.transferenciaService.listarTransferencias().subscribe({
      next: (dados) => (this.transferencias = dados),
      error: (erro) => console.error('Erro ao listar transferências:', erro),
    });
  }

  agendarTransf(): void {
    this.router.navigate(['/transferencias/agendar']);
  }
}
