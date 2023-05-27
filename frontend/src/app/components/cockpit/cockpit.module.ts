import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import {CockpitComponent} from "./cockpit.component";
import {ToastModule} from "primeng/toast";

@NgModule({
  declarations: [CockpitComponent],
    imports: [
        CommonModule,
        ReactiveFormsModule,
        ToastModule
    ]
})
export class CockpitModule { }
