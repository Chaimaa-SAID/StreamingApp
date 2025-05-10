import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { routes } from './app.routes'; 

@NgModule({
  declarations: [
    AppComponent 
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes) // Utilisation correcte de tes routes
  ],
  bootstrap: [AppComponent] // Ne laisse pas vide
})
export class AppModule {}