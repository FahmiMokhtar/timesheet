import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StatusService {
  private req = '/api/status';

  constructor(private httpClient: HttpClient) { }

  getUsers(){
    return this.httpClient.get<Status[]>(this.req);
  }

  getUser(statusid: string){
    return this.httpClient.get<Status>(this.req + "/" + statusid);
  }

}

export interface Status {
  id: number;
  description: string;
}
