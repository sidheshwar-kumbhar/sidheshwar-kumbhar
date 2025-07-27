import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SmkLoggerService {

  constructor() { }

  log(message:String): void{
    console.log(message);
  }
}
