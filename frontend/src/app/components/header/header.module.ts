import { NgModule } from '@angular/core';
import {CommonModule, NgOptimizedImage} from '@angular/common';

import {HeaderComponent} from "./header.component";
import {PanelModule} from "primeng/panel";
import {TabMenuModule} from "primeng/tabmenu";
import {ImageModule} from "primeng/image";

@NgModule({
  declarations: [HeaderComponent],
  exports: [
    HeaderComponent
  ],
  imports: [
    CommonModule,
    PanelModule,
    TabMenuModule,
    NgOptimizedImage,
    ImageModule
  ]
})
export class HeaderModule { }
