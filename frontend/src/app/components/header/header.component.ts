import {Component, OnInit} from '@angular/core';
import {MenuItem} from "primeng/api";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  // @ts-ignore
  items: MenuItem[];

  // @ts-ignore
  activeItem: MenuItem;

  ngOnInit() {
    this.items = [
      { label: 'Home', icon: 'pi pi-fw pi-home', routerLink: '/cockpit' },
      { label: 'Add recipe', icon: 'pi pi-fw pi-calendar', routerLink: '/add-recipe' },
      { label: 'Settings', icon: 'pi pi-fw pi-cog' },
      { label: 'Logout', icon: 'pi pi-fw pi-sign-out' }
    ];

    this.activeItem = this.items[0];
  }
}
