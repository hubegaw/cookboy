import {Component, OnInit} from '@angular/core';
import { UntypedFormBuilder, FormGroup, Validators } from "@angular/forms";
import {AuthService} from "../../services/auth-service.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  // @ts-ignore
  loginForm: FormGroup;

  constructor(
    private readonly fb: UntypedFormBuilder,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    })
  }

  onSubmit(form: FormGroup) {
    if(this.loginForm.valid) {
      this.authService.loginPost(this.loginForm);
    }
  }

}
