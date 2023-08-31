import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms'

import { AppComponent } from './app.component';
import { TimesheetMainComponent } from './timesheet-main/timesheet-main.component';
import { TimesheetTableComponent } from './timesheet-table/timesheet-table.component';
import { TimesheetEditComponent } from './timesheet-edit/timesheet-edit.component';
import { TimesheetEditSelectUserComponent } from './timesheet-edit-select-user/timesheet-edit-select-user.component';
import { TimesheetEditSelectStatusComponent } from './timesheet-edit-select-status/timesheet-edit-select-status.component';

@NgModule({
  declarations: [
    AppComponent,
    TimesheetMainComponent,
    TimesheetTableComponent,
    TimesheetEditComponent,
    TimesheetEditSelectUserComponent,
    TimesheetEditSelectStatusComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
