import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';
import { provideRouter } from '@angular/router';
import { routes } from './app/app.routes'; // Adjust path if needed
import { importProvidersFrom } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'; // Example for HTTP services
import { BrowserModule } from '@angular/platform-browser';

bootstrapApplication(AppComponent, {
  providers: [
    provideRouter(routes),
    importProvidersFrom(BrowserModule, HttpClientModule), // Add other modules as needed
  ],
}).catch((err) => console.error(err));