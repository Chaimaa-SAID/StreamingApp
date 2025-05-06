import {Season} from "./season.model";

export interface Episode {
    id?: number;
    titre: string;
    numero: number;
    duree: number;
    urlStreaming: string;
    season?: Season;
}