import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Theme } from '../models/theme.model';
import { ApiService } from './api.service';

@Injectable({
    providedIn: 'root'
})
export class ThemeService {
    private endpoint = 'api/themes';

    constructor(private apiService: ApiService) { }

    getAllThemes(): Observable<Theme[]> {
        return this.apiService.get<Theme[]>(this.endpoint);
    }

    saveTheme(theme: Theme): Observable<Theme> {
        return this.apiService.post<Theme>(this.endpoint, theme);
    }
}