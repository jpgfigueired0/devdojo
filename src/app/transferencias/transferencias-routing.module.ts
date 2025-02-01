import { Routes, RouterModule } from '@angular/router';
import { AgendarTransferenciaComponent } from './agendar-transferencia/agendar-transferencia.component';
import { ListarTransferenciasComponent } from './listar-transferencias/listar-transferencias.component';
import { NgModule } from '@angular/core';

const routes: Routes = [
  { path: 'listar', component: ListarTransferenciasComponent },
  { path: 'agendar', component: AgendarTransferenciaComponent },
  { path: '', redirectTo: 'agendar', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class TransferenciasRoutingModule {}
