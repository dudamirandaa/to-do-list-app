import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {

  @Output() newTaskPressed = new EventEmitter();

  @Output() filterPressed = new EventEmitter();

  constructor() { }

  // displayAddCard() {

  //   let newButton = document.getElementById('new-task');
  //   let addCard = document.getElementById("add-card");
  //   newButton?.addEventListener('click', function() {
  //   });
  // }

  ngOnInit(): void {
  }

  newTask() {
    this.newTaskPressed.emit();
  }

  filter() {
    this.filterPressed.emit();
    console.log("filter was pressed");
  }
}
