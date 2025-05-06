import {Component, OnInit} from '@angular/core';

@Component({
    selector: 'app-themes-list',
    templateUrl: './themes-list.component.html',
    standalone: true,
    styleUrls: ['./themes-list.component.scss']
})
export class ThemesListComponent implements OnInit {
    themes: string[] = ['Light Theme', 'Dark Theme', 'Blue Theme', 'Green Theme'];

    constructor() {
    }

    ngOnInit(): void {
    }

    selectTheme(theme: string): void {
        console.log(`Theme selected: ${theme}`);
        // Add theme switching logic here
    }
}