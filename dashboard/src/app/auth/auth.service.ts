import { Injectable } from '@angular/core';
import { AuthData } from './auth-data.model';
import { User } from './user.model';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  authChange = new Subject<boolean>();
  private user: User;
  login() {
    this.user = new User();
    console.log(this.user);
    this.authChange.next(true);

  }

  logout() {
    this.user = null;
    this.authChange.next(false);

  }

  registerUser(authData: AuthData) {
    this.user = {
      username: authData.username,
      userId: Math.round(Math.random() * 10000).toString(),
      email: "",
      password: "",
      isVerified: false,
      country: "",
      field: "",
    };
    this.authChange.next(true);
  }

  getUser() {
    return { ...this.user };
  }

  isAuth() {
    return this.user != null;;
  }
  constructor() { }

}
