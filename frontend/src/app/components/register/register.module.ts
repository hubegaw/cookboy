import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import {RegisterComponent} from "./register.component";

import { InputTextModule } from 'primeng/inputtext';
import { PasswordModule } from 'primeng/password';
import { ButtonModule } from 'primeng/button';
import {RouterLink} from "@angular/router";
import {ToastModule} from "primeng/toast";

@NgModule({
  declarations: [RegisterComponent],
    imports: [
        CommonModule,
        ReactiveFormsModule,
        InputTextModule,
        PasswordModule,
        ButtonModule,
        RouterLink,
        ToastModule
    ]
})
export class RegisterModule { }
