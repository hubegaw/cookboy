import {Component, OnInit} from '@angular/core';
import {FormGroup, UntypedFormBuilder, Validators} from "@angular/forms";
import {AuthService} from "../../api";
import {ApiService} from "../../services/api-service.service";
import {Router} from "@angular/router";
import {MessageService} from "primeng/api";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm!: FormGroup;

  constructor(
    private readonly fb: UntypedFormBuilder,
    private authService: AuthService,
    private apiService: ApiService,
    private router: Router,
    private messageService: MessageService
  ) {}

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  onSubmit(form: FormGroup): void {
    if (this.loginForm.valid) {
      const authenticationRequest = {
        email: this.loginForm.get('email')?.value,
        password: this.loginForm.get('password')?.value
      };

      this.authService.apiV1AuthAuthenticatePOST(authenticationRequest)
        .subscribe(
          (responseData) => {
            const token = responseData.token;
            this.authService.setToken(token);
            this.router.navigate(['/cockpit']);
          },
          (error) => {
            this.messageService.add({severity: "Info", summary: "Info", detail: "Could not log in"})
          }
        );
    }
  }
}
