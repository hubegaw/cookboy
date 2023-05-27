import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {FormGroup} from '@angular/forms';
import {firstValueFrom} from 'rxjs';
import {map} from 'rxjs/operators';

export interface AuthenticationResponse {
  token: string;
  refreshToken: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) { }

  async loginPost(loginForm: FormGroup): Promise<AuthenticationResponse | null> {
    const response = await this.http.post<AuthenticationResponse | null>('http://localhost:8080/api/v1/auth/authenticate', loginForm.value, {
      observe: 'response'
    }).pipe(
      map(response => response.body || null)
    );
    return firstValueFrom(response);
  }

  async RegisterPost(registerForm: FormGroup):  Promise<AuthenticationResponse | null> {
    const response = await this.http.post<AuthenticationResponse | null>('http://localhost:8080/api/v1/auth/register', registerForm.value, {
      observe: 'response'
    }).pipe(
      map(response => response.body || null)
    );
    return firstValueFrom(response);
  }
}
