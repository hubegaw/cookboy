import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import {ErrorComponent} from "./error.component";

@NgModule({
  declarations: [ErrorComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule
  ]
})
export class ErrorModule { }
