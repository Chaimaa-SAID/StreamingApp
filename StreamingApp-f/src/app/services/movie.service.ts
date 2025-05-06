import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Movie } from '../models/movie.model';
import { ApiService } from './api.service';

@Injectable({
    providedIn: 'root'
})
export class MovieService {
    private endpoint = 'api/movies';

    constructor(private apiService: ApiService) { }

    getAllMovies(): Observable<Movie[]> {
        return this.apiService.get<Movie[]>(this.endpoint);
    }

    saveMovie(movie: Movie): Observable<Movie> {
        return this.apiService.post<Movie>(this.endpoint, movie);
    }
}
