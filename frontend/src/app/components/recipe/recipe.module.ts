import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import {RecipeComponent} from "./recipe.component";

@NgModule({
  declarations: [RecipeComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule
  ]
})
export class RecipeModule { }
