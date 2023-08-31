import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TimesheetsService {
  private req = '/api/timesheet';

  constructor(private httpClient: HttpClient) { }

  getTimesheets(){
    return this.httpClient.get<Timesheet[]>(this.req);
  }

  getTimesheet(timesheetid: string){
    return this.httpClient.get<Timesheet>(this.req + "/" + timesheetid);
  }

  getSearchTimesheetByTask(keyword: string){
    return this.httpClient.get<TimesheetInfo>(this.req + "/searchtask?keyword=" + keyword);
  }

  addNewTimesheet(timesheet: Timesheet){
    return this.httpClient.post<HttpResponse<any>>(this.req, timesheet);
  }

  updateTimesheet(timesheet: Timesheet, timesheetid: number){
    return this.httpClient.put<HttpResponse<any>>(this.req + "/" + timesheetid, timesheet);
  }

  deleteTimesheet(timesheetid: string){
    return this.httpClient.delete<HttpResponse<any>>(this.req + "/" + timesheetid);
  }
}

export interface Timesheet {
  id: number;
  project: string;
  task: string;
  datefrom: string;
  dateto: string;
  userid: number;
  statusid: number;
}

export interface TimesheetInfo {
  id: number;
  project: string;
  task: string;
  from: string;
  to: string;
  assignto: string;
  status: string;
}
