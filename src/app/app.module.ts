import { NgModule } from '@angular/core';

import { BrowserModule } from '@angular/platform-browser';
import { TransferenciasModule } from './transferencias/transferencias.module';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';


@NgModule({
  declarations: [],
  imports: [
    BrowserModule,
    RouterModule.forRoot([]),
    TransferenciasModule,

  ],
  providers: [],
  bootstrap: [],
})
export class AppModule {}

