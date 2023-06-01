import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import {CockpitComponent} from "./cockpit.component";
import {ToastModule} from "primeng/toast";
import {TableModule} from "primeng/table";
import {CardModule} from "primeng/card";
import {ButtonModule} from "primeng/button";
import {RippleModule} from "primeng/ripple";

@NgModule({
  declarations: [CockpitComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    ToastModule,
    TableModule,
    CardModule,
    ButtonModule,
    RippleModule
  ]
})
export class CockpitModule { }
