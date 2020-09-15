import {Injectable, EventEmitter} from '@angular/core';

@Injectable()
export class WildEventService {
  events : Map<string, EventEmitter<any>> = new Map<string, EventEmitter<any>>();

  constructor() { }

  public subscribe(topic:string, handler: Function) : any {
    let event : EventEmitter<any> = this.events.get(topic);

    if(event == null) {
      event = new EventEmitter<any>();
    }

    let subscriber = event.subscribe(handler);
    this.events.set(topic, event);

    return subscriber;
  }

  public unsubscribe(topic:string, handler: Function) {
    let event : EventEmitter<any> = this.events.get(topic);

    if(event != null) {
      if(event.observers && event.observers.length) {
        event.observers.forEach((subscriber: any) => {
          subscriber.unsubscribe();
        });
      }
      //event.unsubscribe();
    }
  }

  public publish(topic:string, ...params: any[]) {
    let event : EventEmitter<any> = this.events.get(topic);

    if(event != null) {
      event.emit(params);
    }
  }

}
