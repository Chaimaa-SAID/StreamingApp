import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../models/category.model';
import { ApiService } from './api.service';

@Injectable({
    providedIn: 'root'
})
export class CategoryService {
    private endpoint = 'api/categories';

    constructor(private apiService: ApiService) { }

    getAllCategories(): Observable<Category[]> {
        return this.apiService.get<Category[]>(this.endpoint);
    }

    saveCategory(category: Category): Observable<Category> {
        return this.apiService.post<Category>(this.endpoint, category);
    }
}
