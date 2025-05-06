import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Movie } from '../../../models/movie.model';
import { MovieService } from '../../../services/movie.service';

@Component({
    selector: 'app-movie-form',
    templateUrl: './movie-form.component.html',
    styleUrls: ['./movie-form.component.scss']
})
export class MovieFormComponent implements OnInit {
    movieForm: FormGroup;
    isEditMode = false;
    movieId: number | null = null;
    loading = false;
    error = '';

    constructor(
        private fb: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private movieService: MovieService
    ) {
        this.movieForm = this.fb.group({
            titre: ['', [Validators.required]],
            description: ['', [Validators.required]],
            dateSortie: ['', [Validators.required]],
            langue: ['', [Validators.required]],
            estDisponible: [true],
            realisateur: ['', [Validators.required]],
            duree: [0, [Validators.required, Validators.min(1)]]
        });
    }

    ngOnInit(): void {
        const id = this.route.snapshot.paramMap.get('id');
        if (id) {
            this.isEditMode = true;
            this.movieId = +id;
            this.loadMovie(this.movieId);
        }
    }

    loadMovie(id: number): void {
        this.loading = true;
        // This would need to be implemented in your service
        // For now we'll simulate loading a movie
        setTimeout(() => {
            const mockMovie: Movie = {
                id: id,
                titre: 'Sample Movie',
                description: 'This is a sample movie description',
                dateSortie: new Date(),
                langue: 'English',
                estDisponible: true,
                realisateur: 'John Doe',
                duree: 120
            };

            this.movieForm.patchValue(mockMovie);
            this.loading = false;
        }, 500);
    }

    onSubmit(): void {
        if (this.movieForm.invalid) {
            return;
        }

        const movieData: Movie = this.movieForm.value;
        this.loading = true;

        if (this.isEditMode && this.movieId) {
            // Update existing movie - would need to be implemented
            this.router.navigate(['/movies']);
        } else {
            this.movieService.saveMovie(movieData).subscribe({
                next: () => {
                    this.router.navigate(['/movies']).then(r => {});
                },
                error: (err) => {
                    this.error = 'Failed to save movie. Please try again.';
                    this.loading = false;
                    console.error('Error saving movie:', err);
                }
            });
        }
    }
}