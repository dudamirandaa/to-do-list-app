import { HttpClient } from '@angular/common/http';
import { ElementSchemaRegistry } from '@angular/compiler';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Task } from '../task'

@Component({
  selector: 'app-edit-card',
  templateUrl: './edit-card.component.html',
  styleUrls: ['./edit-card.component.scss']
})
export class EditCardComponent implements OnInit {

  editTaskForm!: FormGroup;

  taskId!: number | undefined;

  constructor(private http: HttpClient, private formBuilder: FormBuilder) {
  }

  @Input() set isEditTaskPressedEvent (value: boolean) {
    if(value && !this.isEditTaskPressed) {
      this.isEditTaskPressed = true;
    }
  }

  isEditTaskPressed=false;

  @Input() set task (task: Task){
    if(task) {
      this.taskId = task.id;
      this.editTaskForm = this.taskForm(task.name, task.priority, task.dueDate);
    }
  }

  ngOnInit(): void {
    this.editTaskForm = this.taskForm();
  }

  taskForm(name='', priority='', dueDate='') {
  return this.formBuilder.group({
      name: name,
      priority: priority,
      dueDate: dueDate
    })
  }

  submit() {
    if (this.editTaskForm) {
      const editedTask: Task = this.editTask();
      this.http.put<Task>('api/to-do-list/' + this.taskId, editedTask).subscribe(() => {
        this.isEditTaskPressed=false;
        alert("Task edited successfully :)");
        window.location.reload();
      })
    }
  }

  private editTask(): Task {
    return {
      name: this.editTaskForm.get('name')?.value,
      priority: this.editTaskForm.get('priority')?.value,
      dueDate: this.editTaskForm.get('dueDate')?.value
    }
  }

  close() {
    this.isEditTaskPressed = false;
  }
}
