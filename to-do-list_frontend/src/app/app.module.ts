import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListComponent } from './list/list.component';
import { NavComponent } from './nav/nav.component';
import { AddCardComponent } from './add-card/add-card.component';
import { FilterCardComponent } from './filter-card/filter-card.component';
import { SortCardComponent } from './sort-card/sort-card.component';
import { ListRowComponent } from './list/list-row/list-row.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EditCardComponent } from './edit-card/edit-card.component';

@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    NavComponent,
    AddCardComponent,
    FilterCardComponent,
    SortCardComponent,
    ListRowComponent,
    EditCardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
