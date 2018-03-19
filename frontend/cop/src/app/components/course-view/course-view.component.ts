import { Component, OnInit } from '@angular/core';
import { CoursesService } from '../../services/courses.service';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-courses',
  templateUrl: './course-view.component.html',
  styleUrls: ['./course-view.component.css']
})
export class CourseViewComponent implements OnInit {

  courses;

  constructor(private coursesServices: CoursesService) { }

  ngOnInit() {
    
  }

}