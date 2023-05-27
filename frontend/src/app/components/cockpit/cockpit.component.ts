import { Component, OnInit } from '@angular/core';
import {ApiService, AuthService} from "../../api";
import { RecipeDTO } from "src/app/api/model/recipeDTO"
import { first } from "rxjs/operators";
import { MessageService } from "primeng/api";

@Component({
  selector: 'app-cockpit',
  templateUrl: './cockpit.component.html',
  styleUrls: ['./cockpit.component.css']
})
export class CockpitComponent implements OnInit {
  recipes: RecipeDTO[] = [];
  private userId!: number;

  constructor(private apiService: ApiService, private messageService: MessageService, private authService: AuthService) {}

  ngOnInit(): void {
    this.userId = this.authService.getUserId();
    this.fetchRecipes();
  }

  fetchRecipes(): void {
    this.apiService.apiV1RecipesUserUserIdGET(this.userId, 'response')
      .pipe(first())
      .subscribe(
        (response) => {
          if (response.ok) {
            this.recipes = response.body || [];
          } else {
            this.messageService.add({ severity: 'error', summary: 'Error', detail: 'Could not fetch data.' });
          }
        },
        (error) => {
          this.messageService.add({ severity: 'error', summary: 'Error', detail: `Could not fetch data. Error: ${error.message}` });
        }
      );
  }
}
