import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TimesheetEditSelectUserComponent } from './timesheet-edit-select-user.component';

describe('TimesheetEditSelectUserComponent', () => {
  let component: TimesheetEditSelectUserComponent;
  let fixture: ComponentFixture<TimesheetEditSelectUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TimesheetEditSelectUserComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TimesheetEditSelectUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
