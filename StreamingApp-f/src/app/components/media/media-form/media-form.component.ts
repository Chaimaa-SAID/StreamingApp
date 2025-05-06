import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';


@Component({
    selector: 'app-media-form',
    template: `
        <div class="media-form">
            <form (ngSubmit)="onSubmit()">
                <div>
                    <label for="title">Media Title</label>
                    <input id="title" formControlName="title" placeholder="Enter media title"/>
                    <div *ngIf="mediaForm.get('title')?.invalid && mediaForm.get('title')?.touched">
                        Title is required and must be at least 3 characters long.
                    </div>
                </div>

                <div>
                    <label for="description">Media Description</label>
                    <textarea id="description" formControlName="description"
                              placeholder="Enter media description"></textarea>
                </div>

                <div>
                    <label for="file">Upload Media</label>
                    <input id="file" type="file" (change)="onFileSelect($event)"/>
                    <div *ngIf="fileError">{{ fileError }}</div>
                </div>

                <button type="submit" [disabled]="mediaForm.invalid">Submit</button>
            </form>

            <div *ngIf="submitted">
                <h3>Form Submitted Successfully</h3>
                <p>Title: {{ formData?.title }}</p>
                <p>Description: {{ formData?.description }}</p>
                <p *ngIf="formData?.file">File: {{ formData?.file.name }}</p>
            </div>
        </div>
    `,
    styles: [
        `
            .media-form {
                max-width: 400px;
                margin: auto;
            }

            label {
                display: block;
                margin: 10px 0 5px;
            }

            input,
            textarea,
            button {
                display: block;
                width: 100%;
                margin-bottom: 15px;
            }

            textarea {
                resize: vertical;
            }

            button {
                margin-top: 10px;
            }
        `,
    ],
})
export class MediaFormComponent {
    mediaForm: FormGroup;
    submitted = false;
    formData: {
        title?: string;
        description?: string;
        file?: File;
    } | null = null;
    fileError: string | null = null;

    constructor(private fb: FormBuilder) {
        this.mediaForm = this.fb.group({
            title: ['', [Validators.required, Validators.minLength(3)]],
            description: [''],
        });
    }

    onFileSelect(event: Event): void {
        const input = event.target as HTMLInputElement;
        const file = input.files?.[0];

        if (file) {
            if (file.size > 5 * 1024 * 1024) {
                this.fileError = 'File size should not exceed 5MB.';
            } else {
                this.fileError = null;
                this.formData = {...this.formData, file};
            }
        }
    }

    onSubmit(): void {
        if (this.mediaForm.valid) {
            this.submitted = true;
            this.formData = {...this.mediaForm.value};
        }
    }

    protected readonly FormGroup = FormGroup;
}