
import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.scss']
})
export class AdminDashboardComponent implements OnInit {
  stats: any = {};

  constructor(private authService: AuthService, private http: HttpClient) {}

  ngOnInit(): void {
    const token = this.authService.getToken();
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    this.http.get('http://localhost:8080/api/admin/dashboard', { headers })
      .subscribe(data => this.stats = data);
  }
}
