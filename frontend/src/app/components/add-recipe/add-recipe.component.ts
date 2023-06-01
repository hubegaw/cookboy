import { Component } from '@angular/core';
import {Recipe} from "../../api";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {MessageService} from "primeng/api";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-recipe',
  templateUrl: './add-recipe.component.html',
  styleUrls: ['./add-recipe.component.css']
})
export class AddRecipeComponent {
  recipeForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private messageService: MessageService,
    private router: Router
  ) {
    this.recipeForm = this.formBuilder.group({
      tags: [''],
      time: [''],
      portions: ['', Validators.min(0)],
      title: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(100)]],
      description: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(3000)]]
    });
  }
  onSubmit() {
    if (this.recipeForm.valid) {
      const recipeData = this.recipeForm.value;
      this.http.post<Recipe>('/api/v1/recipes', recipeData).subscribe(
        () => {
          this.messageService.add({ severity: 'success', summary: 'Recipe added successfully' });
          this.recipeForm.reset();
          this.router.navigate(['/cockpit']);

        },
        (error) => {
          this.messageService.add({ severity: 'error', summary: 'Error adding recipe', detail: error.message });
        }
      );
    }
  }
}
