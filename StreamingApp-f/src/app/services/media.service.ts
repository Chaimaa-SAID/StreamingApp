import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Media } from '../models/media.model';
import { ApiService } from './api.service';

@Injectable({
    providedIn: 'root'
})
export class MediaService {
    private endpoint = 'api/media';

    constructor(private apiService: ApiService) { }

    getAllMedia(): Observable<Media[]> {
        return this.apiService.get<Media[]>(this.endpoint);
    }

    saveMedia(media: Media): Observable<Media> {
        return this.apiService.post<Media>(this.endpoint, media);
    }
}
