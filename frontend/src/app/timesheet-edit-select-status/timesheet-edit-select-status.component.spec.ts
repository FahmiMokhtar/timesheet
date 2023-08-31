import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TimesheetEditSelectStatusComponent } from './timesheet-edit-select-status.component';

describe('TimesheetEditSelectStatusComponent', () => {
  let component: TimesheetEditSelectStatusComponent;
  let fixture: ComponentFixture<TimesheetEditSelectStatusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TimesheetEditSelectStatusComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TimesheetEditSelectStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
