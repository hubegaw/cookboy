import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FooterComponent } from "./footer.component";
import {PanelModule} from "primeng/panel";
import {SharedModule} from "primeng/api";

@NgModule({
  declarations: [FooterComponent],
  exports: [
    FooterComponent
  ],
    imports: [
        CommonModule,
        PanelModule,
        SharedModule
    ]
})
export class FooterModule { }
