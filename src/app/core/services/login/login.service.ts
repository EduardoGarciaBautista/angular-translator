import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {LoginModel, LoginResponse} from '../../../models/Login.model';
import {URL_ROOT_SERVICE} from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  readonly LOGIN_SERVICE: string = 'loginUsuario';

  constructor(private http: HttpClient) {
  }

  logear(loginReques: LoginModel) {
    return this.http.post<LoginResponse>(URL_ROOT_SERVICE + this.LOGIN_SERVICE, loginReques);
  }
}
