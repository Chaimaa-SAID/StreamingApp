import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api/auth';
  private tokenKey = 'auth_token';

  constructor(private http: HttpClient) {}

  login(email: string, password: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/login`, { email, password }).pipe(
      tap((response: any) => {
        if (response.token) {
          localStorage.setItem(this.tokenKey, response.token);
        }
      }),
      catchError(this.handleError)
    );
  }

  register(userData: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/register`, userData).pipe(
      tap((response: any) => {
        if (response.token) {
          localStorage.setItem(this.tokenKey, response.token);
        }
      }),
      catchError(this.handleError)
    );
  }

  isLoggedIn(): boolean {
    return !!this.getToken();
  }

  getToken(): string | null {
    return localStorage.getItem(this.tokenKey);
  }

  logout(): void {
    localStorage.removeItem(this.tokenKey);
  }

  decodeToken(token: string): any {
    try {
      const payload = token.split('.')[1];
      return JSON.parse(atob(payload));
    } catch (e) {
      console.error('Erreur de décodage du token', e);
      return null;
    }
  }

  getUserInfo(): any | null {
    const token = this.getToken();
    if (!token) return null;
    return this.decodeToken(token);
  }

  getRole(): string | null {
    const userInfo = this.getUserInfo();
    return userInfo?.role || null;
  }

  getUsername(): string | null {
    const userInfo = this.getUserInfo();
    return userInfo?.username || null;
  }

  getEmail(): string | null {
    const userInfo = this.getUserInfo();
    return userInfo?.email || null;
  }

  private handleError(error: HttpErrorResponse): Observable<never> {
    let errorMessage = 'Une erreur s\'est produite. Veuillez réessayer.';
    if (error.error instanceof ErrorEvent) {
      errorMessage = `Erreur: ${error.error.message}`;
    } else {
      errorMessage = `Erreur ${error.status}: ${error.error.message || error.message}`;
    }
    return throwError(() => new Error(errorMessage));
  }
}
