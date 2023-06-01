import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, Router, RouterStateSnapshot} from '@angular/router';
import {ApiService} from "./api-service.service";

@Injectable({
  providedIn: 'root'
})
export class AuthGuard {

  constructor(private router: Router,
              private apiService: ApiService) {}

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    const isLoggedIn = this.apiService.isLoggedIn();
    if (!isLoggedIn) {
      this.router.navigate(['/login']).then();
    }
    return isLoggedIn;
  }
}

