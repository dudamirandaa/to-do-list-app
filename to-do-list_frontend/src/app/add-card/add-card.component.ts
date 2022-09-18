import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { HttpClient, HttpHandler } from '@angular/common/http';
import { Task } from '../task'

@Component({
  selector: 'app-add-card',
  templateUrl: './add-card.component.html',
  styleUrls: ['./add-card.component.scss']
})
export class AddCardComponent implements OnInit {

  newTaskForm!: FormGroup;

  constructor(private http: HttpClient, private formBuilder: FormBuilder) {
  }

  @Input() set isNewTaskPressedEvent (value: boolean) {
    if(value && !this.isNewTaskPressed) {
      this.isNewTaskPressed = true;
    }
  }

  isNewTaskPressed=false;

  ngOnInit(): void {
    this.newTaskForm = this.formBuilder.group({
      name: ["", Validators.required],
      priority: ["", Validators.required],
      dueDate: ["", Validators.required]
    })
  }

  submit() {
    if (this.newTaskForm.valid) {
      const newTask: Task = this.createNewTask();
      this.http.post<Task>('api/to-do-list', newTask).subscribe(() => {
        this.isNewTaskPressed=false;
        alert("New task added successfully :)");
        window.location.reload();
      })
    }
  }

  private createNewTask() {
    return {
      name: this.newTaskForm.get('name')?.value,
      priority: this.newTaskForm.get('priority')?.value,
      dueDate: this.newTaskForm.get('dueDate')?.value
    }
  }

  close() {
    this.isNewTaskPressed = false;
  }
}
