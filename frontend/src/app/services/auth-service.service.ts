import {Injectable, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {MessageService} from "primeng/api";
import {FormGroup} from "@angular/forms";


interface AuthResponseData {
  kind: string;
  idToken: string;
  email: string;
  refreshToken: string;
  expiresIn: string;
  localId: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService implements OnInit{
  constructor(private http: HttpClient,
              private messageService: MessageService) { }

  ngOnInit() {
  }

  loginPost(loginForm: FormGroup) {
    this.http.post('http://localhost:8080/api/v1/auth/authenticate', loginForm.value)
      .subscribe(
      (responseData) => {
        console.log("sss");
      });
  }

  RegisterPost(registerForm: FormGroup) {
    this.http.post<AuthResponseData>('http://localhost:8080/api/v1/auth/register', registerForm.value).subscribe(
      (responseData) => {
        console.log("sss");
      });
  }
}
