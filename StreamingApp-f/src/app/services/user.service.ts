import {ApiService} from "./api.service";
import {User} from "../models/user.model";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class UserService {
    private endpoint = 'api/users';

    constructor(private apiService: ApiService) { }

    getAllUsers(): Observable<User[]> {
        return this.apiService.get<User[]>(this.endpoint);
    }

    saveUser(user: User): Observable<User> {
        return this.apiService.post<User>(this.endpoint, user);
    }
}