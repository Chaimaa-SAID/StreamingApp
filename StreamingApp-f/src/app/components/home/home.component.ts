import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, RouterModule, FormsModule],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {
  searchQuery: string = ''; // Propriété explicitement définie comme string
  isAdmin: boolean = false;
  movies = [
    { id: 1, title: 'Film 1', genre: 'Action', isFavorite: false },
    { id: 2, title: 'Film 2', genre: 'Drame', isFavorite: false },
    { id: 3, title: 'Film 3', genre: 'Comédie', isFavorite: false }
  ];

  constructor(private authService: AuthService) {
    this.isAdmin = this.authService.getRole() === 'ADMIN';
  }

  searchMovies(): void {
    console.log('Recherche:', this.searchQuery);
    // Implémenter la recherche via une API
  }

  toggleFavorite(movie: any): void {
    movie.isFavorite = !movie.isFavorite;
    console.log('Favori togglé:', movie);
  }

  viewDetails(movie: any): void {
    console.log('Voir détails:', movie);
    // Rediriger vers une page de détails
  }

  playMovie(movie: any): void {
    console.log('Lecture:', movie);
    // Implémenter la lecture (streaming)
  }

  addMovie(): void {
    console.log('Ajouter un film');
    // Implémenter l'ajout de film (ADMIN)
  }

  editMovie(movie: any): void {
    console.log('Modifier:', movie);
    // Implémenter la modification (ADMIN)
  }

  deleteMovie(movie: any): void {
    console.log('Supprimer:', movie);
    // Implémenter la suppression (ADMIN)
  }

  manageUsers(): void {
    console.log('Gérer les utilisateurs');
    // Implémenter la gestion des utilisateurs (ADMIN)
  }
}