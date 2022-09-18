import { Task } from './../../task';
import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-row',
  templateUrl: './list-row.component.html',
  styleUrls: ['./list-row.component.scss']
})
export class ListRowComponent implements OnInit {

  constructor(private http: HttpClient, private router: Router) { }

  @Input() id?: number;

  @Input() name='';

  @Input() priority='';

  @Input() dueDate='';

  @Output() editTaskPressed = new EventEmitter();

  ngOnInit(): void {
  }

  editTask() {
    const task: Task = this.originalTask();
    this.editTaskPressed.emit(task);
  }

  deleteTask() {
    const task: Task = this.originalTask();
    this.http.delete<Task>('api/to-do-list/' + task.id).subscribe(() => {
      console.log(task.id);
      alert("Task deleted successfully :)");
      window.location.reload();
    })
  }

  originalTask(): Task {
    return {
      id: this.id,
      name: this.name,
      priority: this.priority,
      dueDate: this.dueDate
    }
  }
}
