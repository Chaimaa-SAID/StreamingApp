import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

// Importation directe des composants standalone
import { HeaderComponent } from './header/header.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { FooterComponent } from './footer/footer.component';

@NgModule({
  imports: [
    CommonModule,
    HeaderComponent, 
    SidebarComponent, 
    FooterComponent 
  ],
  exports: [
    HeaderComponent,
    SidebarComponent,
    FooterComponent
  ]
})
export class SharedModule {}