import {Component} from '@angular/core';
import {PrimeNGConfig} from "primeng/api";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';

  constructor(
    private primengConfig: PrimeNGConfig,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.primengConfig.ripple = true;
  }

  isLoginOrRegisterActive(): boolean {
    let currentRoute = this.router.url;
    currentRoute = currentRoute.substring(1);
    return currentRoute === 'login' || currentRoute === 'register' || currentRoute === 'error';
  }
}
