import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Transferencia {
  contaOrigem: string;
  contaDestino: string;
  valor: number;
  dataTransferencia: string;
  taxa?: number;
}

@Injectable({
  providedIn: 'root',
})
export class TransferenciaService {
  private apiUrl = 'http://localhost:8080/api/transferencias';

  constructor(private http: HttpClient) {}

  // Agendar transferência
  agendarTransferencia(transferencia: Transferencia): Observable<Transferencia> {
    return this.http.post<Transferencia>(this.apiUrl, transferencia);
  }

  // Listar todas as transferências
  listarTransferencias(): Observable<Transferencia[]> {
    return this.http.get<Transferencia[]>(this.apiUrl);
  }

  // Listar transferências por data
  listarPorData(data: string): Observable<Transferencia[]> {
    return this.http.get<Transferencia[]>(`${this.apiUrl}/data?data=${data}`);
  }
}
