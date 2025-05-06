import {Component, OnInit} from '@angular/core';

@Component({
    selector: 'app-users-list',
    templateUrl: './users-list.component.html',
    standalone: true,
    styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {
    users: { id: number; name: string; email: string }[] = [];

    constructor() {
    }

    ngOnInit(): void {
        // Mock data
        this.users = [
            {id: 1, name: 'John Doe', email: 'john.doe@example.com'},
            {id: 2, name: 'Jane Smith', email: 'jane.smith@example.com'},
            {id: 3, name: 'Bob Johnson', email: 'bob.johnson@example.com'},
        ];
    }
}