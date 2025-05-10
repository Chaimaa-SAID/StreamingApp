import { Component } from '@angular/core';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.scss']
})
export class AdminDashboardComponent {
  stats = {
    totalUsers: 100,
    totalMovies: 25,
    totalCategories: 6,
    totalSubscriptions: 40
  };
}

