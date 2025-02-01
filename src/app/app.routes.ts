import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'transferencias',
    loadChildren: () =>
      import('./transferencias/transferencias.module').then(
        (m) => m.TransferenciasModule
      ),
  },
  { path: '', redirectTo: 'transferencias/listar', pathMatch: 'full' },
];
