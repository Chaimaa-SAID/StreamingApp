import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { AuthService } from '../../../services/auth.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  registerForm!: FormGroup;
  loading: boolean = false;
  error: string | null = null;

  constructor(private fb: FormBuilder, private authService: AuthService, private router: Router) {}

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      nom: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      confirmPassword: ['', [Validators.required, Validators.minLength(6)]],
      role: ['USER', Validators.required]
    });
  }

  onSubmit(): void {
    if (this.registerForm.valid) {
      this.loading = true;
      const { nom, email, password, confirmPassword, role } = this.registerForm.value;
      if (password !== confirmPassword) {
        this.error = 'Les mots de passe ne correspondent pas.';
        this.loading = false;
        return;
      }
      const userData = { nom, email, password, role };
      this.authService.register(userData).subscribe({
        next: (response: any) => {
          console.log('Inscription réussie', response);
          this.loading = false;
          this.error = null;
          this.router.navigate(['/login']);
        },
        error: (err: Error) => {
          this.error = err.message || 'Erreur lors de l\'inscription. Veuillez réessayer.';
          this.loading = false;
        }
      });
    } else {
      this.error = 'Veuillez remplir tous les champs correctement.';
      this.loading = false;
    }
  }
}