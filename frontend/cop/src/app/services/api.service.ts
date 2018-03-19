import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
//import { DEFAULT_MESSAGE } from ''

@Injectable()
export class ApiService {

  domain:string = environment.domain;

  constructor(private http: HttpClient) {
  }

  get(path: string) {

      return this.http.get(this.domain + path);
  }

  post(path: string, body) {

    return this.http.post(this.domain + path,body);
  }

  put(path: string, body) {

    return this.http.put(this.domain + path,body);
  }

  delete(path: string) {

    return this.http.delete(this.domain + path);
  }

}