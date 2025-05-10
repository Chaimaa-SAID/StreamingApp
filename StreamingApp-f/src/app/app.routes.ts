import { Routes } from '@angular/router';
import { LoginComponent } from './components/auth/login/login.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { AdminLayoutComponent } from './layout/admin-layout/admin-layout.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'home', component: HomeComponent },
  {
    path: 'admin',
    component: AdminLayoutComponent,
    children: [
      { path: '', component: AdminDashboardComponent }, // /admin
      // { path: 'users', component: UsersComponent },
      // { path: 'movies', component: MoviesComponent },
      // etc.
    ]
  },
  { path: '', redirectTo: '/login', pathMatch: 'full' }
];