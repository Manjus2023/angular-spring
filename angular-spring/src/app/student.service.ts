import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Student } from './student';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private baseUrl = 'http://localhost:8080/api/';
  constructor(
    private http: HttpClient
  ) { }
  getStudentList(): Observable<any> {
    return this.http.get<Student[]>(this.baseUrl + 'students-list');
  }
  createStudent(student: object):Observable<object>{
    const jsonStudent = JSON.stringify(student);
    console.log(jsonStudent + 'from create student in student service')
    return this.http.post<object>(this.baseUrl + 'save-student', student);
  }
  deleteStudent(id: number): Observable<any> {
    return this.http.delete(this.baseUrl + 'delete-student/' + id, { responseType: 'text' });
  }
  getStudent(id: number): Observable<Student> {
    return this.http.get<Student>(this.baseUrl + 'student/' + id);
  }
  updateStudent(id: number, value: any): Observable<Object> {
    return this.http.put(this.baseUrl + 'update-student/' + id , value);
  }

}

