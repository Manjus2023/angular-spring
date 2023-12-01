import { Component, OnInit, numberAttribute } from '@angular/core';
import { StudentService } from '../student.service';
import { Student } from '../student';
import { Observable, Subject } from "rxjs";
import { of } from 'rxjs';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  studentToUpdate: Student = new Student;

  constructor(private studentservice: StudentService) { }

  studentsArray: any[] = [];
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();
  students!: Observable<Student[]>;
  student: Student = new Student();
  deleteMessage = false;
  isupdated = false;

  ngOnInit() {
    this.isupdated = false;
    this.dtOptions = {
      pageLength: 6,
      stateSave: true,
      lengthMenu: [[6, 16, 20, -1], [6, 16, 20, "All"]],
      processing: true
    };
    this.students = this.studentservice.getStudentList();
    // this.studentservice.getStudentList().subscribe(data =>{
    // this.students = data ;
    // this.dtTrigger.next;
    // })

  }

  deleteStudent(id: number) {
    this.studentservice.deleteStudent(id)
      .subscribe(
        data => {
          console.log(data);
          this.deleteMessage = true;
          this.students = this.studentservice.getStudentList()
        },
        error => console.log(error));
  }
  updateStudent(student: Student) {
    this.studentToUpdate = student;
  }

  studentupdateform = new FormGroup({
    student_id: new FormControl(),
    student_name: new FormControl(),
    student_email: new FormControl(),
    student_branch: new FormControl()
  });

  updateStu(newStudent : Student) {
    // this.student = new Student();
    // this.student.student_id = newStudent.student_id;
    // this.student.student_name = newStudent.student_name;
    // this.student.student_email = newStudent.student_email;
    // this.student.student_branch = newStudent.student_branch;
    // console.log(this.StudentBranch?.value);
    this.studentservice.updateStudent(newStudent.student_id, newStudent).subscribe(
      data => {
        this.isupdated = true;
        this.students = this.studentservice.getStudentList();
        // this.studentservice.getStudentList().subscribe(data => {
        //   this.students = data
        // })
      },
      error => console.log(error));
  }
  get StudentName() {
    return this.studentupdateform.get('student_name');
  }

  get StudentEmail() {
    return this.studentupdateform.get('student_email');
  }

  get StudentBranch() {
    return this.studentupdateform.get('student_branch');
  }

  get StudentId() {
    return this.studentupdateform.get('student_id');
  }

  changeisUpdate() {
    this.isupdated = false;
  }
}
