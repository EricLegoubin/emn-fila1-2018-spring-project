import { Component, OnInit } from '@angular/core';
import { CoursesService } from '../../services/courses.service';
import { Observable } from 'rxjs/Observable';
import { ParamMap, Router, ActivatedRoute } from '@angular/router';
import 'rxjs/add/operator/switchMap';
import { Chart } from 'chart.js';
import * as $ from 'jquery';

@Component({
  selector: 'app-courses',
  templateUrl: './course-view.component.html',
  styleUrls: ['./course-view.component.css']
})
export class CourseViewComponent implements OnInit {

  course;
  id;
  ctx;

  chart = []; // This will hold our chart info
  PosNames = new Array();
  TimeTh = new Array();
  TimeCalc = new Array();
  TimeOp = new Array();


  constructor(private coursesServices: CoursesService,private router: Router, private route: ActivatedRoute) { 
    
  }

  ngOnInit() {

    this.route.params.subscribe( params => this.id  = params.id);

    this.coursesServices.getCoursesById(this.id)
    .subscribe(data => {
      this.course = data;
      this.initChart();
    });

    

  }

  initChart() {

    this.course.passages.forEach(element => {
      this.PosNames.push(element.poi.nom);
      this.TimeTh.push(new Date(element.theoricalDate));
      this.TimeCalc.push(new Date(element.calculatedDate));
      this.TimeOp.push(new Date(element.operatorDate));
    });

    this.chart = new Chart('canvas', {
      type: 'line',
      data: {
        labels: this.PosNames,
        datasets: [
          { 
            data: this.TimeTh,
            borderColor: "#3cba9f",
            fill: false
          },
          { 
            data: this.TimeCalc,
            borderColor: "#ffcc00",
            fill: false
          },
          { 
            data: this.TimeOp,
            borderColor: "#ff0000",
            fill: false
          }
        ]
      },
      options: {
        legend: {
          display: false
        },
        scales: {
          xAxes: [{
            display: true
          }],
          yAxes: [{
            display: true
          }],
        }
      }
    });
 
  }

  document = $("#canvas").click( 
    function(evt){
        var activePoints = this.chart.getSegmentsAtEvent(evt);           
        console.log("CLICK");
    }
);  



}