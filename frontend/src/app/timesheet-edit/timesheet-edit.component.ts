import { Component, ElementRef, EventEmitter, Input, Output, ViewChild } from '@angular/core';

import { Timesheet, TimesheetsService } from '../services/timesheets.service';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-timesheet-edit',
  templateUrl: './timesheet-edit.component.html',
  styleUrls: ['./timesheet-edit.component.css']
})
export class TimesheetEditComponent {
  
  @Input() timesheet: Timesheet = {
    id: 0,
    project: '',
    task: '',
    datefrom: '',
    dateto: '',
    userid: 0,
    statusid: 0
  }

  @Output() dialogClosing = new EventEmitter<number>();
  
  @ViewChild('appDialog', { static: true }) dialog!: ElementRef<HTMLDialogElement>;

  constructor(private service:TimesheetsService) {}

  clearTimesheetData() {
    this.timesheet = {
      id: 0,
      project: '',
      task: '',
      datefrom: '',
      dateto: '',
      userid: 0,
      statusid: 0
    }
  }

  dialogOpen() {
    this.dialog.nativeElement.showModal();
  }

  dialogClose() {
    this.clearTimesheetData();
    this.dialogClosing.emit(1);
    this.dialog.nativeElement.close();
  }

  dialogSave() {
    if (this.timesheet.id==0) {
      this.service.addNewTimesheet(this.timesheet).subscribe(
        (data: HttpResponse<any>) => {
          if (data != null) {
              alert("Timesheet info succesfully added");
            this.dialogClose();
            console.log(`This contains body: ${data.body}`);
          } else {
            alert("Error encountered");
          }
        },
        (err: HttpErrorResponse) => {
          alert("Error encountered");
        },
      );
    }

    if (this.timesheet.id>0) {
      this.service.updateTimesheet(this.timesheet,this.timesheet.id).subscribe(
        (data: HttpResponse<any>) => {
          if (data != null) {
              alert("Timesheet info succesfully updated");
            this.dialogClose();
            console.log(`This contains body: ${data.body}`);
          } else {
            alert("Error encountered");
          }
        },
        (err: HttpErrorResponse) => {
          alert("Error encountered");
        },
      );
    }
  }

  updateUserId(userid : number){
    this.timesheet.userid = userid;
  }

  updateStatusId(statusid : number){
    this.timesheet.statusid = statusid;
  }

}