import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-filter-card',
  templateUrl: './filter-card.component.html',
  styleUrls: ['./filter-card.component.scss']
})
export class FilterCardComponent implements OnInit {

  filterTaskForm!: FormGroup;

  // list: Task[] = [];

  @Input() set isFilterPressedEvent (value: boolean) {
    if(value && !this.isFilterPressed) {
      this.isFilterPressed = true;
      console.log("child got it that filter was pressed");
    }
  }

  isFilterPressed=false;

  constructor(private http: HttpClient, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.filterTaskForm = this.formBuilder.group({
      name: '',
      priority: '',
      dueDate: ''
    })
  }

  @Output() filterEvent = new EventEmitter();

  submit() {
    console.log(this.filterTaskForm);
    const filteredTasks: Observable<Task[]> = this.list();
    this.filterEvent.emit(filteredTasks);
  }

  list(): Observable<Task[]> {
    return this.http.get<Task[]>('api/to-do-list/?name=' + this.filterTaskForm.get('name')?.value + '&priority=' + this.filterTaskForm.get('priority')?.value + '&date=' + this.filterTaskForm.get('dueDate')?.value);
  }

  close() {
    this.isFilterPressed = false;
  }
}

