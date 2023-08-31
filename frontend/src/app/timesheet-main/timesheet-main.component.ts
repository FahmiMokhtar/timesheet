import { Component, ViewChild } from '@angular/core';
import { TimesheetEditComponent } from '../timesheet-edit/timesheet-edit.component';
import { Timesheet, TimesheetInfo ,TimesheetsService } from '../services/timesheets.service';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-timesheet-main',
  templateUrl: './timesheet-main.component.html',
  styleUrls: ['./timesheet-main.component.css']
})
export class TimesheetMainComponent  {

  @ViewChild(TimesheetEditComponent)
  dialog!: TimesheetEditComponent;

  searchString: string = '';
  timesheetInfos: any;
  timesheetEdit: Timesheet = {
    id: 0,
    project: '',
    task: '',
    datefrom: '',
    dateto: '',
    userid: 0,
    statusid: 0
  }

  selectedTimesheetId: number = 0;

  constructor(private service:TimesheetsService) {}
 
  showDialog() {
    
    this.dialog.dialogOpen();

  }

  searchByTask() {
    this.service.getSearchTimesheetByTask(this.searchString).subscribe(
      response => {this.timesheetInfos = response;
    });
  }

  searchById(){
    this.service.getTimesheet(this.selectedTimesheetId + "").subscribe(
      response => { this.timesheetEdit = response; 
      this.showDialog();
    })
  }

  deleteById() {
    this.service.deleteTimesheet(this.selectedTimesheetId + "").subscribe(
      (data: HttpResponse<any>) => {
       
        alert("Timesheet info deleted");
        this.executeSearch(1);
      },
      (err: HttpErrorResponse) => {
        alert("Error encountered");
        this.executeSearch(1);
      }
    )
  }

  executeEdit(id : number){
    this.selectedTimesheetId = id;
    this.searchById();
  }

  executeDelete(id : number){
    this.selectedTimesheetId = id;
    this.deleteById();
  }

  executeSearch(dosearch : number){
    this.selectedTimesheetId = 0;
    this.searchByTask();
  }

}
