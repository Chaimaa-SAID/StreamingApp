import {Media} from "./media.model";

export interface Movie extends Media {
    realisateur: string;
    duree: number;
}