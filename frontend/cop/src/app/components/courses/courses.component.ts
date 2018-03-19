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

  constructor(private coursesServices: CoursesService) { }

  ngOnInit() {
    this.courses = this.coursesServices.getCourses();
  }

}