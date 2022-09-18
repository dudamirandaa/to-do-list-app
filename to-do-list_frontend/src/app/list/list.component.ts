import { ListService } from './list.service';
import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import { Task } from '../task'
import { Observable } from 'rxjs';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  list: Task[] = [];

  @Input() set filteredList(value: Observable<Task[]> | undefined) {
   if(value){
      value.subscribe(list => this.list = list);
      console.log("chegou na lista")
    }
  }

  @Output() editTaskPressed = new EventEmitter();

  @Output() id?: number;

  constructor(private listService: ListService) {
  }

  ngOnInit(): void {
    this.listService.list().subscribe(list => this.list = list);
  }

  editTaskPressedTransfer(task: Task) {
    this.editTaskPressed.emit(task);
  }

  // editTaskPressed() {
  //   this.isEditTaskPressed = true;
  // }
}
