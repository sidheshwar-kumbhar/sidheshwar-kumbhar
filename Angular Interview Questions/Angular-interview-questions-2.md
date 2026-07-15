<img src="https://rxjs-dev.firebaseapp.com/assets/images/logos/logo.png" alt="RxJs" width="200"/>


## RxJs Interview Questions. 

These are some common  RxJs interview questions. 


**What is RxJS ?**

It's an acronym for **Reactive Extensions of JavaScript.** and it's a JavaScript library for handling **Asynchronous data streams** and events.


**What is Stream ?**

Values of data over time.


**What is Reactive Programming?**

It's a programming paradigm that deals with asynchronous streams of data.


**What are the advantages of Reactive Programming?**

 - Easy to handle streams of data.
 - Has many useful operators that can save time: switchMap, concatMap.
 - Helps avoid callback hell.
 - Makes complex threading easy.
 - Cleaner & maintainable code.


**What do you understand by the term Non-Blocking in RxJS?**

It's an algorithm that does not allow threads competing for the same resource to be indefinitely postponed through mutual exclusion of the resource.


**What is Back-Pressure in Reactive Programming?**

It's the resistance(opposing force) on the desired data flow of an application. 


**What is an Obserable?**

It's an object that emits values over time.


**What is the difference between an observable and a Promise?**

Promise:

 - A promise has a **single callback** at the end of completion or failure.
 - A promise is not Lazy. It **cannot be cancelled**.

Observable:

 - An observable emits **multiple values** over time.
 - You may cancel an obeservable with an **Unsubscribe()** method.
 - An observable only executes once **subscribed to it**.
 - Provides efficient **operators**: map, reduce, foreach, filter, reduce, retry, retryWhen.


**What is the difference between Cold and Hot Observables ?**

 - Cold observables have their data produced inside the observable.
 - Hot observables have their data produced outside the observable. 

 - Cold Observables only emit data once subscribed to;
 - Hot Observables emit values even before the subscription is made. Used when sharing data among many subscribers.


**What are RxJS Operators ?**

- These are methods that can be applied to the observable in order to modify the data stream.


**What is Observers and Subscriptions ?**

- **Observers**: They are the listeners/ consumers of the data stream; Observers listen /subscribe to the data stream.

- **Subscribers**: - Objects returned when an observable is subscribed; Useful in canceling the subscription.


**What is Subject ?**

- It's a type of observable where data is multicasted to its observables.


**What are different types of Subject ?**

 - Behaviour Subject & Replay Subject.

- **Subject**: -Doesn't revive data prior to their subscription.

- **Behaviour Subject**: - Emits last value to all & new observers.

- **Replay Subject**: - All observers will revive data prior to their subscription; uses a buffer to hold values and re-emits values on new subscriptions.


**What are Schedulers:**

A scheduler controls the execution of when the subscription has to start and be notified.

**Types of schedulers**: queueScheduler, asapScheduler, asyncScheduler, animationFrameScheduler


**What is RxJS Map and What is Higher-Order Observable Mapping?**

- **RxJS Map**: It's a flattening operator used to transform current emitted data values to the desired data format.

![RxJs Map](https://rxjs-dev.firebaseapp.com/assets/images/marble-diagrams/map.png)

```
const http$ : Observable<Books[]> = this.http.get('/api/books');

http$
    .pipe(
        tap(() => console.log('HTTP request executed')),
        map(res => Object.values(res['payload']))
    )
    .subscribe(
        books => console.log("books", books)
    );
```

- **Higher-Order Mapping**: These are Rxjs operators used to map source observable values into other observables.


**When do we use the switchMap, mergeMap and concatMap?**

**i) What is RxJS ConcatMap**?

 - **Concat**: Joins multiple Observables together, by subscribing to them one at a time and merging their results into the output Observable.

- Used to combine multiple HTTP requests.

![Concat](https://rxjs-dev.firebaseapp.com/assets/images/marble-diagrams/concat.png)

- **ConcatMap**: Projects each source value to an Observable which is merged in the output Observable, in a serialized fashion waiting for each one to complete before merging the next.

![ConcatMap](https://rxjs-dev.firebaseapp.com/assets/images/marble-diagrams/concatMap.png)


**Why would you want to use ConcatMap?**

- Used to combine multiple HTTP requests; alleviating the need for nested subscribers.
- All HTTP requests are sent to the backend sequentially; Once the previous request has been completed. 

```

this.form.valueChanges
    .pipe(
        concatMap(formValue => this.http.put("/api/book/",formValue))
    )
    .subscribe(
        response =>  ... handle successful ...,
        err => ... handle error ...      
);

```


**ii) What is RxJS mergeMap?**

- **MergeMap**:Projects each source value to an Observable which is merged in the output Observable.
- Its operation is in parallel, unlike concatMap, it's not sequential in nature.
 

![MergeMap](https://rxjs-dev.firebaseapp.com/assets/images/marble-diagrams/mergeMap.png)


```
this.form.valueChanges
     .pipe(
         mergeMap(formValue => 
                     this.http.put("/api/book/", formValue))
     )
     .subscribe(
         res =>  ... handle successful response ...,
         err => ... handle error ...      
     );
```

**iii) What is RxJS switchMap?**

- **switchMap**: An operator that combines source values into an output observable that represents the most recent projected observable.

- In switching, unlike merging, we'll unsubscribe the previous Observable before subscribing to the new Observable if the new Observable begins to emit the values.


**Why would you want to use SwitchMap?**

 - When you want to get the most rescent updated values the second source anticipated to delay.

**UseCase:**
 
a) Update data from local cache or CDN before retrieving from backend.

![SwitchMap](https://rxjs-dev.firebaseapp.com/assets/images/marble-diagrams/switchMap.png)


```
const searchText$: Observable<string> = 
    fromEvent<any>(this.input.nativeElement, "keyup")
    .pipe(
        map(event => event.target.value), // map to form input component value
        startWith(""),  // avoid spaces
        debounceTime(400),  // delay request by 400 ms to avoid sending multiple request while user still typing
        distinctUntilChanged() // prevent duplicate request on retype
    ); 

const lessons$: Observable<Lesson[]> = searchText$
    .pipe(
        switchMap(search => (){
            const params = new HttpParams().set("search", search);
            return this.http.get("/api/book/", {params});
        )        
    )
    .subscribe();

```


**iii) What is RxJS exhaustMap?**

- **exhaust**: Converts a higher-order Observable into a first-order Observable by dropping inner Observables while the previous inner Observable has not yet completed.

- It behaves like mergeAll. However, exhaust ignores every new inner Observable if the previous Observable has not yet completed. Once that one completes, it will accept and flatten the next inner Observable and repeat this process.

![Exhaust](https://rxjs-dev.firebaseapp.com/assets/images/marble-diagrams/exhaust.png)


- **ExhaustMap:** Projects each source value to an Observable which is merged in the output Observable only if the previous projected Observable has completed.

![ExhaustMap](https://rxjs-dev.firebaseapp.com/assets/images/marble-diagrams/exhaustMap.png)

```
const clicks = fromEvent(document, 'click');
const result = clicks.pipe(
  exhaustMap(ev => interval(1000).pipe(take(5)))
);
result.subscribe(x => console.log(x));
```


**When we use zip and combineLatest and withLatestFrom ?**

- **Zip**: Combines multiple Observables to create an Observable whose values are calculated from the values, in order, of each of its input Observables.

```
import { zip, of } from 'rxjs';
import { map } from 'rxjs/operators';
 
let age$ = of<number>(27, 25, 29);
let name$ = of<string>('Foo', 'Bar', 'Beer');
let isDev$ = of<boolean>(true, true, false);
 
zip(age$, name$, isDev$).pipe(
  map(([age, name, isDev]) => ({ age, name, isDev })),
)
.subscribe(x => console.log(x));
 
// outputs
// { age: 27, name: 'Foo', isDev: true }
// { age: 25, name: 'Bar', isDev: true }
// { age: 29, name: 'Beer', isDev: false }
```

 - **combineLatest**: Combines multiple Observables to create an Observable whose values are calculated from the latest values of each of its input Observables.

![CombineLatest](https://rxjs-dev.firebaseapp.com/assets/images/marble-diagrams/combineLatest.png)


```
import { combineLatest, of } from 'rxjs';
import { delay, starWith } from 'rxjs/operators';
 
const observables = [1, 5, 10].map(
  n => of(n).pipe(
    delay(n * 1000),   // emit 0 and then emit n after n seconds
    startWith(0),
  )
);
const combined = combineLatest(observables);
combined.subscribe(value => console.log(value));
// Logs
// [0, 0, 0] immediately
// [1, 0, 0] after 1s
// [1, 5, 0] after 5s
// [1, 5, 10] after 10s
```

- **withLatestFrom**:  Combines the source Observable with other Observables to create an Observable whose values are calculated from the latest values of each, only when the source emits.

![withLatesFrom](https://rxjs-dev.firebaseapp.com/assets/images/marble-diagrams/withLatestFrom.png)

```
import { fromEvent, interval } from 'rxjs';
import { withLatestFrom } from 'rxjs/operators';

const clicks = fromEvent(document, 'click');
const timer = interval(1000);
const result = clicks.pipe(withLatestFrom(timer));
result.subscribe(x => console.log(x));
```



<img src="https://redux.js.org/img/redux.svg" alt="Redux" width="200"/>




## Redux

**What is Redux?** 

Open-Source JavaScript library for managing application state. Used in frontend framework such as React, Angular & Rxjs


**What are the core principles of Redux?**

 -**Single source of Truth**: All application data is stored in a single object tree.
 - **State is read only**: The state is [immutable](https://en.wikipedia.org/wiki/Immutable_object).
 - **State can only be change with Pure Functions**: These pure functions are called **Reduces** and they specify how the object tree is should be updated.  


**Is there any similarity between Redux and RxJS?**

 - Redux uses reactive paradigm to mutate state of the store.
 - RxJs uses reactive paradigm  to accomplish asynchronous data processing.


**What is the difference between Reactive Programming and Imperative Programming?**

 - **Reactive programming** is a programming paradime where data is being **Pushed** to subscribed observers in an application. Where as:
 - **Imperative programming** is a programming paradime where data is being **Pulled** on request from an application.


**What is the difference between BehaviorSubject and Observable in RxJS?**

 - Observable is a consumer/listener while a BehaviourSubject is a synchronous data source that emits data to observers.
 - Observables are stateless while BehaviourSubject is stateful.
 - Observables create a copy of the data while BehaviourSubject emits data to observers.
 - Observables are unidirectional in nature while BehaviorSubject is bi-directional in nature.