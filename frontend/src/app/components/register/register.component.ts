import {Component, OnInit} from '@angular/core';
import {FormGroup, UntypedFormBuilder, Validators} from "@angular/forms";
import {AuthService} from "../../api";
import {MessageService} from "primeng/api";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm!: FormGroup;
  constructor(
    private readonly fb: UntypedFormBuilder,
    private authService: AuthService,
    private messageService: MessageService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      email: ['', [Validators.required, Validators.pattern('^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$'), Validators.maxLength(60)]],
      password: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(50)]],
      cpassword: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(50)]],
      name: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]]
    })
  }

  onSubmit(form: FormGroup) {
    const authenticationRequest = {
      email: this.registerForm.get('email')?.value,
      password: this.registerForm.get('password')?.value,
      name: this.registerForm.get('name')?.value,
    };

    this.authService.apiV1AuthRegisterPOST(authenticationRequest)
      .subscribe(
        (response) => {
          this.router.navigate(['/login']).then(r => response);
        },
        (error) => {
          this.messageService.add({severity: "Error", summary: "Error", detail: "Error while registering!"})
          console.error('Registration failed', error);
        }
      );
  }
}
