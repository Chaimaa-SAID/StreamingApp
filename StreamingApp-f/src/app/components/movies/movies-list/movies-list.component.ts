import { Component, OnInit } from '@angular/core';
import { Movie } from '../../../models/movie.model';
import { MovieService } from '../../../services/movie.service';

@Component({
    selector: 'app-movies-list',
    templateUrl: './movies-list.component.html',
    styleUrls: ['./movies-list.component.scss']
})
export class MoviesListComponent implements OnInit {
    movies: Movie[] = [];
    loading = false;
    error = '';

    constructor(private movieService: MovieService) { }

    ngOnInit(): void {
        this.loadMovies();
    }

    loadMovies(): void {
        this.loading = true;
        this.movieService.getAllMovies().subscribe({
            next: (data: Movie[]) => {
                this.movies = data;
                this.loading = false;
            },
            error: (err: any) => {
                this.error = 'Failed to load movies. Please try again.';
                this.loading = false;
                console.error('Error loading movies:', err);
            }
        });
    }
}