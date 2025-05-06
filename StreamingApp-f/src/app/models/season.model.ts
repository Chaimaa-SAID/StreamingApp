import {Series} from "./series.model";

export interface Season {
    id?: number;
    number: number;
    releaseDate: Date;
    series?: Series;
}