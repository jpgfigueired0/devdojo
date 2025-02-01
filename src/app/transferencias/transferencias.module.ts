import { NgModule } from '@angular/core';


import { TransferenciasRoutingModule } from './transferencias-routing.module';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AgendarTransferenciaComponent } from './agendar-transferencia/agendar-transferencia.component';
import { ListarTransferenciasComponent } from './listar-transferencias/listar-transferencias.component';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [
    AgendarTransferenciaComponent,
    ListarTransferenciasComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    TransferenciasRoutingModule,
  ],
  exports: [

  ],
})
export class TransferenciasModule {}
