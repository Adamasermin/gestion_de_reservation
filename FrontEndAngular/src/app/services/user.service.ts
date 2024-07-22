import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private BASE_URL = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  register(admin:any): Observable<any> {
    return this.http.post(`${this.BASE_URL}admin/creer`, admin);
  }

  login(credentials: any): Observable<any> {
    return this.http.post(`${this.BASE_URL}/login/connexion` , credentials, { responseType: 'text' })
  }

  logout(): Observable<any> {
    return this.http.post(`${this.BASE_URL}/login/logout`, { responseType: 'text' });
  }

}
