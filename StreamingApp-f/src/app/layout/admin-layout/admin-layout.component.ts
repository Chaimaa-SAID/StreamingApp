import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from '../../shared/header/header.component'; // Adjust path
import { SidebarComponent } from '../../shared/sidebar/sidebar.component'; // Adjust path
import { FooterComponent } from '../../shared/footer/footer.component'; // Adjust path
import { RouterOutlet } from '@angular/router';

import { SharedModule } from '../../shared/shared.module';

@Component({
  selector: 'app-admin-layout',
  standalone: true,
  imports: [CommonModule, RouterOutlet, SharedModule],
  templateUrl: './admin-layout.component.html',
  styleUrls: ['./admin-layout.component.scss'],
})
export class AdminLayoutComponent {}