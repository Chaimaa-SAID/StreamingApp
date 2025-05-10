import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { AuthService } from '../../../services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  loginForm: FormGroup;
  error: string | null = null;
  loading: boolean = false;

  constructor(private fb: FormBuilder, private authService: AuthService, private router: Router) {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.loginForm.valid) {
      this.loading = true;
      const { email, password } = this.loginForm.value;
      this.authService.login(email, password).subscribe({
        next: (response: any) => {
          this.loading = false;
          this.error = null;
  
          const token = response.token;
          localStorage.setItem('token', token);
  
          // Décoder le token pour extraire le rôle
          const payload = JSON.parse(atob(token.split('.')[1]));
          const role = payload.role || payload.authorities?.[0]?.authority;
  
          if (role === 'ADMIN') {
            this.router.navigate(['/admin']);
          } else if(role === 'USER'){
            this.router.navigate(['/home']);
          }else {
            this.router.navigate(['/login']);
          }
        },
        error: (err: any) => {
          console.error('Erreur de connexion', err);
          this.error = 'Erreur lors de la connexion. Vérifiez vos identifiants.';
          this.loading = false;
        }
      });
    } else {
      this.error = 'Veuillez remplir tous les champs correctement.';
      this.loading = false;
    }
  }
  
}