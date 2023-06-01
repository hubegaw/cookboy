import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import {AddRecipeComponent} from "./add-recipe.component";
import {ChipsModule} from "primeng/chips";

@NgModule({
  declarations: [AddRecipeComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    ChipsModule
  ]
})
export class AddRecipeModule { }
