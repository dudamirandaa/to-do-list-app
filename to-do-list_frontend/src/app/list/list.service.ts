import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Task } from '../task'

@Injectable({providedIn: 'root'})
export class ListService {

  constructor(private http: HttpClient) {}

  list(): Observable<Task[]> {
    return this.http.get<Task[]>('api/to-do-list');
  }
}
