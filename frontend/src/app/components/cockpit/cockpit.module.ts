import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import {CockpitComponent} from "./cockpit.component";

@NgModule({
  declarations: [CockpitComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule
  ]
})
export class CockpitModule { }
