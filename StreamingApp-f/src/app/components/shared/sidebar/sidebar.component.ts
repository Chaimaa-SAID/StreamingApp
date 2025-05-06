import { Component } from '@angular/core';

@Component({
    selector: 'app-sidebar',
    templateUrl: './sidebar.component.html',
    styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent {
    menuItems = [
        { label: 'Dashboard', icon: 'home', route: '/' },
        { label: 'Movies', icon: 'film', route: '/movies' },
        { label: 'Series', icon: 'tv', route: '/series' },
        { label: 'Categories', icon: 'list', route: '/categories' },
        { label: 'Themes', icon: 'palette', route: '/themes' },
        { label: 'Users', icon: 'users', route: '/users' }
    ];
}