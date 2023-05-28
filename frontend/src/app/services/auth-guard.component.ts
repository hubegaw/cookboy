import {inject, Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivateFn, Router, RouterStateSnapshot} from '@angular/router';
import {ApiService} from "./api-service.service";

@Injectable({
  providedIn: 'root'
})
class PermissionsService {

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

export const AuthGuard: CanActivateFn = (next: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean => {
  return inject(PermissionsService).canActivate(next, state);
}
