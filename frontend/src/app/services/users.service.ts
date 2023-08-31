import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  private req = '/api/users';

  constructor(private httpClient: HttpClient) { }

  getUsers(){
    return this.httpClient.get<User[]>(this.req);
  }

  getUser(userid: string){
    return this.httpClient.get<User>(this.req + "/" + userid);
  }
}

export interface User {
  id: number;
  name: string;
}
