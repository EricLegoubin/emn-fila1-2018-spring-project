import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { ApiService } from './services/api.service';
import { CoursesComponent } from './components/courses/courses.component';
import { CoursesService } from './services/courses.service';
import { CourseViewComponent } from './components/course-view/course-view.component';
import { HttpClientModule } from '@angular/common/http';


const appRoutes: Routes = [
  { path: 'courses', component: CoursesComponent },
  { path: 'course/:id',      component: CourseViewComponent },
  { path: '',
    redirectTo: '/courses',
    pathMatch: 'full'
  },
  { path: '**', component: CoursesComponent } // TODO a 404 page
];

@NgModule({
  declarations: [
    AppComponent,
    CoursesComponent,
    CourseViewComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    HttpClientModule
  ],
  providers: [
    ApiService,
    CoursesService
  ],
  bootstrap: [AppComponent]
})

export class AppModule { }





