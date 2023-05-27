import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import jwt_decode from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private apiUrl = 'http://localhost:8080/api/v1/recipes'; // Update with your API URL
  private token!: string | undefined;
  private userId: number = 0;

  constructor(private http: HttpClient) { }

  setToken(token: string | undefined) {
    this.token = token;
  }

  getToken() {
    return this.token;
  }

  isLoggedIn(): boolean {
    return this.token !== null;
  }

  getUserRecipes(userId: number): Observable<any> {
    const headers = this.getHeaders();
    return this.http.get<any>(`${this.apiUrl}/${userId}`, { headers });
  }

  getAllRecipes(): Observable<any> {
    const headers = this.getHeaders();
    return this.http.get<any>(`${this.apiUrl}`, { headers });
  }

  getRecipeById(userId: number, id: number): Observable<any> {
    const headers = this.getHeaders();
    return this.http.get<any>(`${this.apiUrl}/${id}`, { headers });
  }

  addRecipe(userId: number, recipe: any): Observable<any> {
    const headers = this.getHeaders();
    return this.http.post<any>(`${this.apiUrl}`, recipe, { headers });
  }

  deleteRecipe(userId: number, recipeId: number): Observable<any> {
    const headers = this.getHeaders();
    return this.http.delete<any>(`${this.apiUrl}/${recipeId}`, { headers });
  }

  getUserIdFromToken() {
    if (this.token) {
      try {
        const decodedToken: any = jwt_decode(this.token);
        this.userId = decodedToken.userId;
        return decodedToken.userId;
      } catch (error) {
        console.error('Failed to decode token:', error);
        return 0;
      }
    }
    return 0;
  };

  private getHeaders(): HttpHeaders {
    let headers = new HttpHeaders();
    if (this.token) {
      headers = headers.set('Authorization', `Bearer ${this.token}`);
    }
    return headers;
  }
}
