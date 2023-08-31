import { Component, Input, Output, EventEmitter, OnInit } from '@angular/core';
import { Status, StatusService } from '../services/status.service';

@Component({
  selector: 'app-timesheet-edit-select-status',
  templateUrl: './timesheet-edit-select-status.component.html',
  styleUrls: ['./timesheet-edit-select-status.component.css']
})
export class TimesheetEditSelectStatusComponent implements OnInit  {

  @Input() statusid = 0;
  @Output() statusidChangeEvent = new EventEmitter<number>();

  statuses: any;

  constructor(private service:StatusService) {}

  ngOnInit(): void {
   this.populate();
  }

  populate() {
    this.service.getUsers()
    .subscribe(response => {
      this.statuses = response;
    });
  }

  updateStatusId(value : any){
    this.statusidChangeEvent.emit(value.target.value);
  }

}
