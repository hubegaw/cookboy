import {Component, OnInit} from '@angular/core';
import { UntypedFormBuilder, FormGroup, Validators } from "@angular/forms";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  // @ts-ignore
  registerForm: FormGroup;
  constructor(
    private readonly fb: UntypedFormBuilder
  ) {}

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      email: ['', [Validators.required, Validators.email, Validators.maxLength(60)]],
      password: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(50)]],
      cpassword: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(50)]],
      name: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]]
    })
  }

  onSubmit(form: FormGroup) {
    if(this.registerForm.valid) {

    }
  }
}
