import { Component, Input, Output, OnInit, EventEmitter } from '@angular/core';
import { User, UsersService } from '../services/users.service';

@Component({
  selector: 'app-timesheet-edit-select-user',
  templateUrl: './timesheet-edit-select-user.component.html',
  styleUrls: ['./timesheet-edit-select-user.component.css']
})
export class TimesheetEditSelectUserComponent implements OnInit {
  
  @Input() userid = 0;
  @Output() useridChangeEvent = new EventEmitter<number>();
  
  users: User[] | any;

  constructor(private service:UsersService) {}

  ngOnInit(): void {
    this.service.getUsers()
        .subscribe(response => {
          this.users = response;
        });
  }

  updateUserId(value : any){
    this.useridChangeEvent.emit(value.target.value);
  }

}
