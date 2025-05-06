import { Component, OnInit } from '@angular/core';
import { Category } from '../../../models/category.model';
import { CategoryService } from '../../../services/category.service';

@Component({
    selector: 'app-categories-list',
    templateUrl: './categories-list.component.html',
    styleUrls: ['./categories-list.component.scss']
})
export class CategoriesListComponent implements OnInit {
    categories: Category[] = [];
    loading = false;
    error = '';

    constructor(private categoryService: CategoryService) { }

    ngOnInit(): void {
        this.loadCategories();
    }

    loadCategories(): void {
        this.loading = true;
        this.categoryService.getAllCategories().subscribe({
            next: (data: Category[]) => {
                this.categories = data;
                this.loading = false;
            },
            error: (err: any) => {
                this.error = 'Failed to load categories. Please try again.';
                this.loading = false;
                console.error('Error loading categories:', err);
            }
        });
    }
}
