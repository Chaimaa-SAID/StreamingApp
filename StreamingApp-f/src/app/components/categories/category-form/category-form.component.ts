import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from '../../../models/category.model';
import { CategoryService } from '../../../services/category.service';

@Component({
    selector: 'app-category-form',
    templateUrl: './category-form.component.html',
    styleUrls: ['./category-form.component.scss']
})
export class CategoryFormComponent implements OnInit {
    categoryForm: FormGroup;
    isEditMode = false;
    categoryId: number | null = null;
    loading = false;
    error = '';

    constructor(
        private fb: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private categoryService: CategoryService
    ) {
        this.categoryForm = this.fb.group({
            nom: ['', [Validators.required]]
        });
    }

    ngOnInit(): void {
        const id = this.route.snapshot.paramMap.get('id');
        if (id) {
            this.isEditMode = true;
            this.categoryId = +id;
            this.loadCategory(this.categoryId);
        }
    }

    loadCategory(id: number): void {
        this.loading = true;
        // This would need to be implemented in your service
        // For now we'll simulate loading a category
        setTimeout(() => {
            const mockCategory: Category = {
                id: id,
                nom: 'Sample Category'
            };

            this.categoryForm.patchValue(mockCategory);
            this.loading = false;
        }, 500);
    }

    onSubmit(): void {
        if (this.categoryForm.invalid) {
            return;
        }

        const categoryData: Category = this.categoryForm.value;
        this.loading = true;

        if (this.isEditMode && this.categoryId) {
            // Update existing category - would need to be implemented
            this.router.navigate(['/categories']).then(r => {});
        } else {
            this.categoryService.saveCategory(categoryData).subscribe({
                next: () => {
                    this.router.navigate(['/categories']).then(r => {});
                },
                error: (err: any) => {
                    this.error = 'Failed to save category. Please try again.';
                    this.loading = false;
                    console.error('Error saving category:', err);
                }
            });
        }
    }
}