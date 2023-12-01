import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { BackendComponent } from './backend-content';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  form!: FormGroup;
  submitted = false;
  response:string = 'empty'
  title = 'angular-spring';
  constructor(private http: HttpClient){}

  ngOnInit():void{
  
  }
}
