import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Task } from './task'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  isNewTaskPressed = false;

  isFilterPressed = false;

  isEditTaskPressed = false;

  areTasksFiltered = false;

  task!: Task;

  list: Observable<Task[]> | undefined;

  constructor() {}

  newTaskPressed() {
    this.isNewTaskPressed = true;
  }

  filterPressed() {
    this.isFilterPressed = true;
  }

  editTaskPressed(task: Task) {
    this.isEditTaskPressed = true;
    this.task = task;
  }

  filterTasksPressed(list: Observable<Task[]> | undefined) {
    this.areTasksFiltered = true;
    this.list=list;
  }
}
