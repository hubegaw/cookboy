import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import {AddRecipeComponent} from "./add-recipe.component";

@NgModule({
  declarations: [AddRecipeComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule
  ]
})
export class AddRecipeModule { }
