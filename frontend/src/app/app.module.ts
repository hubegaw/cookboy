import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from "@angular/common/http";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterModule } from "./components/register/register.module";
import { LoginModule } from "./components/login/login.module";
import { ErrorModule } from "./components/error/error.module";
import { CockpitModule } from "./components/cockpit/cockpit.module";
import { RecipeModule } from "./components/recipe/recipe.module";
import { AddRecipeModule } from "./components/add-recipe/add-recipe.module";
import {HeaderModule} from "./components/header/header.module";
import {FooterModule} from "./components/footer/footer.module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    RegisterModule,
    LoginModule,
    ErrorModule,
    CockpitModule,
    RecipeModule,
    AddRecipeModule,
    HeaderModule,
    FooterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
