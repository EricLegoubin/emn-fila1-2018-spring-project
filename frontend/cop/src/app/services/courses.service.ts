import { Injectable } from '@angular/core';
import { ApiService } from './api.service';

@Injectable()
export class CoursesService {

  constructor(private apiService: ApiService) {
  }

  getCourses() {
      return this.apiService.get("/courses");
  }

  getCoursesById(id:string) {
    return this.apiService.get("/courses/" + id);
  }

}