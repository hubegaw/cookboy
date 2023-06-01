import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {RegisterComponent} from "./components/register/register.component";
import {RecipeComponent} from "./components/recipe/recipe.component";
import {LoginComponent} from "./components/login/login.component";
import {CockpitComponent} from "./components/cockpit/cockpit.component";
import {ErrorComponent} from "./components/error/error.component";
import {AuthGuard} from "./services/auth-guard.component";
import {AddRecipeComponent} from "./components/add-recipe/add-recipe.component";

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full'},
  { path: 'register', component: RegisterComponent },
  { path: 'recipe', component: RecipeComponent, canActivate: [AuthGuard] },
  { path: 'login', component: LoginComponent },
  { path: 'add-recipe', component: AddRecipeComponent, canActivate: [AuthGuard]},
  { path: 'cockpit', component: CockpitComponent, canActivate: [AuthGuard] },
  { path: 'error', component: ErrorComponent },
  { path: '**', redirectTo: '/error'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
