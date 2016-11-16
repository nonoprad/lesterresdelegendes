import {Component} from "@angular/core";
@Component({
    selector: 'movies',
    templateUrl: './movies.component.html'
})
export class Movies{
    titre:string = 'un titre de oufff';
    marvelsMovies:string[] = ['IronMan', 'Thor', 'Capitaine America', 'Green Lantern', 'Avengers'];
}