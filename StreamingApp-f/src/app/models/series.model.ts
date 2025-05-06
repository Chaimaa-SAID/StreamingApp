import {Media} from "./media.model";

export interface Series extends Media {
    nom: string;
    nombreSaisons: number;
}
