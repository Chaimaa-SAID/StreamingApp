import 'zone.js/node';
import { renderApplication } from '@angular/platform-server';
import express from 'express';
import { dirname, join, resolve } from 'path';
import { readFileSync, existsSync } from 'fs';
import cors from 'cors';
import bootstrap from './main.server';

const server = express();
const serverDistFolder = dirname(__filename);
const browserDistFolder = resolve(serverDistFolder, '../dist/streaming-app-f/browser');
const indexHtmlPath = join(serverDistFolder, 'index.server.html');

// Vérifier si index.server.html existe
if (!existsSync(indexHtmlPath)) {
  console.error(`Erreur : index.server.html introuvable à ${indexHtmlPath}`);
  process.exit(1);
}

const indexHtml = readFileSync(indexHtmlPath, 'utf-8');

// Enable CORS for requests from the frontend
server.use(cors({
    origin: 'http://localhost:4200',
    methods: ['GET', 'POST', 'PUT', 'DELETE', 'OPTIONS'],
    credentials: true
}));

server.use(express.json()); // To parse JSON request bodies

// Define the /api/auth/register endpoint
server.post('/api/auth/register', (req, res) => {
    const { username, password } = req.body;
    if (!username || !password) {
        return res.status(400).json({ error: 'Username and password are required' });
    }
    // Mock registration logic (replace with your actual logic, e.g., saving to a database)
    console.log(`Registering user: ${username}`);
    res.json({ message: 'User registered successfully', user: { username } });
});

server.set('view engine', 'html');
server.set('views', browserDistFolder);

server.get('**', express.static(browserDistFolder, {
    maxAge: '1y',
    index: false,
}));

server.get('**', (req, res) => {
    const { protocol, originalUrl, headers } = req;
    const url = `${protocol}://${headers.host}${originalUrl}`;
  
    console.log(`Rendu SSR pour l'URL : ${url}`);

    renderApplication(bootstrap, {
        document: indexHtml,
        url,
    })
        .then((html) => {
            console.log('Rendu SSR réussi');
            res.send(html);
        })
        .catch((err) => {
            console.error('Erreur lors du rendu SSR :', err);
            res.status(500).send('Erreur serveur lors du rendu SSR');
        });
});

// Changed port to 8080 to match frontend expectation
server.listen(8080, () => {
    console.log('Serveur SSR démarré sur http://localhost:8080');
});