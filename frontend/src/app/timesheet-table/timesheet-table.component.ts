import { Component, EventEmitter, Input, Output } from '@angular/core';
import { TimesheetInfo } from '../services/timesheets.service';

@Component({
  selector: 'app-timesheet-table',
  templateUrl: './timesheet-table.component.html',
  styleUrls: ['./timesheet-table.component.css']
})
export class TimesheetTableComponent {

  @Input() timeshetResult: any;
  @Output() editClick = new EventEmitter<number>();
  @Output() deleteClick = new EventEmitter<number>();

  editRecord(timesheetInfo:any){
    if ( (timesheetInfo as TimesheetInfo).id !== undefined) {
      this.editClick.emit(timesheetInfo.id);
    }
  }

  deleteRecord(timesheetInfo:any){
    if ( (timesheetInfo as TimesheetInfo).id !== undefined) {
      
      const response = confirm("Delete this record?");
      if (response) {
        this.deleteClick.emit(timesheetInfo.id);
      }
    }
  }
}
