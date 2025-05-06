import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
    selector: 'app-theme-form',
    template: `
        <form [formGroup]="themeForm" (ngSubmit)="onSubmit()" class="theme-form">
            <div>
                <label for="themeName">Theme Name:</label>
                <input
                        id="themeName"
                        formControlName="themeName"
                        type="text"
                        placeholder="Enter theme name"
                />
                <div
                        *ngIf="
            themeForm.get('themeName')?.invalid &&
            themeForm.get('themeName')?.touched
          "
                        class="error"
                >
                    Theme name is required.
                </div>
            </div>

            <div>
                <label for="themeColor">Theme Color:</label>
                <input
                        id="themeColor"
                        formControlName="themeColor"
                        type="color"
                />
            </div>

            <button type="submit" [disabled]="themeForm.invalid">
                Submit
            </button>
        </form>
    `,
    styles: [
        `
      .theme-form {
        display: flex;
        flex-direction: column;
        max-width: 400px;
        margin: auto;
      }

      .theme-form div {
        margin-bottom: 10px;
      }

      .error {
        color: red;
        font-size: 0.8rem;
      }

      button {
        padding: 8px 16px;
      }
    `,
    ],
})
export class ThemeFormComponent implements OnInit {
    themeForm!: FormGroup;

    constructor(private fb: FormBuilder) {
    }

    ngOnInit(): void {
        this.themeForm = this.fb.group({
            themeName: ['', Validators.required],
            themeColor: ['#000000'], // Default black color
        });
    }

    onSubmit(): void {
        if (this.themeForm.valid) {
            console.log('Theme Form Submitted:', this.themeForm.value);
            // Perform additional actions like sending the data to an API
        }
    }
}