import { Component, OnInit } from '@angular/core';
import { CoursesService } from '../../services/courses.service';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {

  courses;
  delays;
  retard;

  constructor(private coursesServices: CoursesService) { }

  ngOnInit() {
    this.coursesServices.getCourses()
    .subscribe(data => {
      this.courses = data;
      this.calculatedDelay();
    });
  }

  calculatedDelay() {
    this.delays = new Array();
    this.courses.forEach(course => {
        this.retard = new Date(course.passages[course.passages.length - 1].theoricalDate - course.passages[course.passages.length - 1].calculatedDate).getTime();
        this.delays.push(this.retard / (1000*60));
    });
    
  }

}