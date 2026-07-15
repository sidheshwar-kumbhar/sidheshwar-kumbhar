## Angular Interview Questions


- https://www.geeksforgeeks.org/angular-js/rxjs-operations-in-angular/
- https://www.geeksforgeeks.org/angular-js/angular-interview-questions-and-answers/
- https://www.interviewbit.com/angular-interview-questions/
- https://www.turing.com/interview-questions/angular
- https://www.youtube.com/watch?v=OSWMBT8YsiY
- https://www.devacetech.com/insights/angular-interview-questions-and-answers
- https://www.simplilearn.com/tutorials/angular-tutorial/angular-interview-questions
- https://www.wecreateproblems.com/interview-questions/angular-interview-questions
- https://zerotomastery.io/blog/angular-interview-questions-and-answers/
- https://www.greatfrontend.com/blog/angular-experienced-interview-questions
- https://www.angularspace.com/senior-angular-interview-questions/
- https://medium.com/@manpreetkaur6311062/senior-level-angular-interview-questions-scenario-based-2026-bf3399add93b
- https://blog.brecht.io/angular-interview-questions-for-seniors/


**1. What is the significance of View and Encapsulation in Angular?**

In Angular, the View represents the user interface (UI) of an application. It consists of HTML templates that are rendered to display data and interact with users. Encapsulation is the process of encapsulating the styles and behavior of a component to prevent them from affecting other parts of the application.

Example:
```
// app.component.ts
import { Component, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  encapsulation: ViewEncapsulation.None // Disable encapsulation
})
export class AppComponent {
  // Component logic goes here
}
```

**2. How do Pipes work in Angular?**

In Angular, Pipes are used to transform data before displaying it in the UI. Angular provides built-in pipes for common transformations like date formatting, currency conversion, and uppercase/lowercase conversions.

Example:

```
<!-- app.component.html -->
<p>{{ today | date:'shortDate' }}</p>
```

**3. What is the purpose of a Pure Pipe in Angular?**

A Pure Pipe in Angular is a pipe that is stateless and only re-evaluates when its input value changes. This improves performance by preventing unnecessary recalculations.

Example:

```
// custom-pipe.pipe.ts
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'customPipe',
  pure: true
})
export class CustomPipe implements PipeTransform {
  transform(value: any): any {
    // Transformation logic
    return transformedValue;
  }
}
```

**4. What are the different ways to call a REST API in Angular?**

Angular provides several methods for calling REST APIs, including the HttpClient module, the Http module (deprecated in newer Angular versions), and third-party libraries like Axios.

Example using HttpClient:

```
// data.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  constructor(private http: HttpClient) {}

  getData() {
    return this.http.get('https://api.example.com/data');
  }
}
```

**5. How does Lazy Loading work in Angular?**

Lazy Loading in Angular allows you to load modules asynchronously when they are needed, improving the initial loading time of the application.

Example:

```
// app-routing.module.ts
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: 'lazy', loadChildren: () => import('./lazy/lazy.module').then(m => m.LazyModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
```

**6. What is Change Detection in Angular?**

Change Detection is a core mechanism in Angular that ensures the application’s UI reflects the current state of data. Angular automatically detects changes to data in the component and its child components, and updates the view accordingly.

Example:

```
// app.component.ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  counter: number = 0;

  incrementCounter() {
    this.counter++;
  }
}
<!-- app.component.html -->
<p>Counter: {{ counter }}</p>
<button (click)="incrementCounter()">Increment</button>
```

**7. Can you explain the concept of Angular Directives?**

Angular Directives are markers on a DOM element that tell Angular to do something with that element or its children. They are a way to extend HTML to create reusable components or add behavior to existing elements.

Example:

```
<!-- app.component.html -->
<div appHighlight>Highlighted Text</div>
// highlight.directive.ts
import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appHighlight]'
})
export class HighlightDirective {
  constructor(private el: ElementRef) {
    el.nativeElement.style.backgroundColor = 'yellow';
  }
}
```

**8. How do ngIf and constructors work in Angular?**

ngIf is a structural directive in Angular that conditionally includes or excludes a portion of the DOM based on the expression provided to it. Constructors in Angular are special methods used for initializing class instances.

Example:

```
<!-- app.component.html -->
<div *ngIf="isLoggedIn">
  <p>Welcome, User!</p>
</div>
// app.component.ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  isLoggedIn: boolean = false;

  constructor() {
    // Initialization logic
    this.isLoggedIn = true; // Simulating user login
  }
}
```

**9. What is the purpose of the ng-pristine directive in Angular?**

The ng-pristine directive in Angular is used to check if a form field has been interacted with or modified by the user. It indicates whether the field is in its initial state (pristine) or has been touched/modified (dirty).

Example:

```
<!-- app.component.html -->
<input type="text" ngModel name="username" #username="ngModel" required>
<div *ngIf="username.pristine">
  Please enter a username.
</div>
```

**10. What is the role of the ng-content directive in Angular?**

The ng-content directive in Angular is used for Content Projection. It allows you to pass content into a component from its parent component, enabling the creation of flexible and reusable components.

Example:

```
<!-- parent.component.html -->
<app-child>
  <h1>Child Component Content</h1>
</app-child>
<!-- child.component.html -->
<div>
  <ng-content></ng-content>
</div>
```

**11. What is the significance of the OnPush change detection strategy in Angular?**

The OnPush change detection strategy in Angular is a performance optimization technique that tells Angular to only run change detection on a component when its inputs change. It's particularly useful when dealing with immutable data or pure components to reduce unnecessary checks and improve application performance.

Example:

```
// app.component.ts
import { Component, ChangeDetectionStrategy } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush // Set OnPush strategy
})
export class AppComponent {
  // Component logic goes here
}
```

**12. Which testing framework have you used in Angular development?**

In Angular development, popular testing frameworks include Jasmine and Karma. Jasmine is a behavior-driven development framework for testing JavaScript code, and Karma is a test runner that launches browsers and executes tests.

Example (Jasmine):

```
// example.spec.ts
import { Calculator } from './calculator';

describe('Calculator', () => {
  let calculator: Calculator;

  beforeEach(() => {
    calculator = new Calculator();
  });

  it('should add two numbers', () => {
    expect(calculator.add(1, 2)).toEqual(3);
  });
});
```

**13. What is a Standalone component?**

A Standalone component in Angular is a component that doesn’t depend on other Angular modules or services. It can be easily reused and tested independently, making it a valuable building block for Angular applications.

Example:

```
// standalone.component.ts
import { Component } from '@angular/core';

@Component({
  selector: 'app-standalone',
  template: '<p>This is a standalone component</p>'
})
export class StandaloneComponent {
  // Component logic goes here
}
```

**14. How do template-driven forms work in Angular?**

Template-driven forms in Angular use directives like ngModel to create a two-way data binding between form controls in the template and properties in the component class. They are easier to set up and understand but may not be suitable for complex forms.

Example:

```
<!-- app.component.html -->
<form #form="ngForm" (ngSubmit)="onSubmit(form.value)">
  <input type="text" name="username" ngModel required>
  <button type="submit">Submit</button>
</form>
```

**15. How do reactive forms work in Angular?**

Reactive forms in Angular use a model-driven approach, where form controls are created programmatically in the component class. They offer more flexibility and control over form validation and submission, making them suitable for complex forms.

Example:

```
// app.component.ts
import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  form: FormGroup;

  constructor(private fb: FormBuilder) {
    this.form = this.fb.group({
      username: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.form.valid) {
      // Form submission logic
    }
  }
}
<!-- app.component.html -->
<form [formGroup]="form" (ngSubmit)="onSubmit()">
  <input type="text" formControlName="username">
  <button type="submit">Submit</button>
</form>
```

**16. Could you explain the role of decorators in Angular?**

Decorators are a key feature in Angular that allow you to enhance and modify classes and their members. In Angular, decorators are used to mark classes as Angular components, directives, services, or modules. They provide metadata that Angular uses to understand how to process and compile the class.

Example:

```
// Component decorator
import { Component } from '@angular/core';

@Component({
  selector: 'app-example',
  templateUrl: './example.component.html',
  styleUrls: ['./example.component.css']
})
export class ExampleComponent {
  // Component logic goes here
}
```

**17. What are some commonly used operators in RxJS?**

RxJS is a library for reactive programming using Observables. Some commonly used operators in RxJS include map, filter, mergeMap, switchMap, combineLatest, zip, concat, and debounceTime, among others.

Example:

```
import { Observable } from 'rxjs';
import { map, filter } from 'rxjs/operators';

const numbers = Observable.of(1, 2, 3, 4, 5);

numbers.pipe(
  map(num => num * 2),
  filter(num => num > 5)
).subscribe(result => console.log(result)); // Output: 6, 8, 10
```

**18. What is the purpose of operators such as switchMap, concatMap, forkJoin, and mergeMap in RxJS?**

- `switchMap`: Projects each source value to an Observable, then subscribes to the inner Observable, and emits values only from the most recently projected Observable.
- `concatMap`: Projects each source value to an Observable, then subscribes to each inner Observable in order, emitting values only from the first projected Observable until it completes, and then moves on to the next.
- `forkJoin`: Combines multiple Observables into a single Observable that emits an array of values, only once all the input Observables have completed.
- `mergeMap`: Projects each source value to an Observable, then subscribes to all of these inner Observables simultaneously, and emits values from each inner Observable as they are available.

Example:
```
import { of, forkJoin } from 'rxjs';

const source1 = of('Hello');
const source2 = of('World');

forkJoin([source1, source2]).subscribe(results => console.log(results)); // Output: ['Hello', 'World']
```

**19. What is Server-Side Rendering (SSR) in Angular?**

Server-Side Rendering (SSR) in Angular refers to the process of rendering Angular applications on the server-side rather than the client-side. SSR improves performance and search engine optimization (SEO) by delivering pre-rendered HTML to the browser, which can be displayed to users more quickly.

`Example: Please check the official Angular documentation or relevant tutorials for a detailed example of Server-Side Rendering in Angular.`

**20. What are the differences between Observables and Promises?**

Promises are eager, meaning they execute immediately upon creation, and can only handle a single value over time. They represent the eventual completion or failure of an asynchronous operation.
Observables, on the other hand, are lazy, meaning they only execute when subscribed to, and can handle multiple values over time. They provide support for handling asynchronous operations and events.
Example:

```
// Promise example
const promise = new Promise((resolve, reject) => {
  setTimeout(() => {
    resolve('Promise resolved');
  }, 1000);
});

promise.then(result => console.log(result)); // Output: Promise resolved

// Observable example
import { Observable, of } from 'rxjs';

const observable = new Observable(observer => {
  setTimeout(() => {
    observer.next('Observable value');
  }, 1000);
});

observable.subscribe(result => console.log(result)); // Output: Observable value
```

**21. What is Content Projection in Angular?**

Content Projection in Angular allows you to insert content into a component’s template from the outside. This enables the creation of reusable components that can accept different content while maintaining their structure and behavior.

Example:

```
<!-- parent.component.html -->
<app-child>
  <h1>Content projected from parent component</h1>
</app-child>
<!-- child.component.html -->
<div>
  <ng-content></ng-content>
</div>
```

**22. How does a Service Worker work in Angular?**

A Service Worker in Angular is a script that runs in the background and handles tasks like caching, push notifications, and offline functionality. It intercepts network requests made by the application and can cache responses to improve performance and enable offline access.

Example: Service Worker registration in app.module.ts:

```
// app.module.ts
import { NgModule } from '@angular/core';
import { ServiceWorkerModule } from '@angular/service-worker';
import { environment } from '../environments/environment';

@NgModule({
  imports: [
    ServiceWorkerModule.register('ngsw-worker.js', { enabled: environment.production })
  ],
  // Other module configurations
})
export class AppModule { }
```

**23. What is the significance of strictNullChecks in TypeScript?**

The strictNullChecks compiler option in TypeScript forces stricter null checking, preventing variables from being assigned a value of null or undefined unless explicitly specified in their type definition. This helps catch potential errors early in development and improves code reliability.

Example:

```
// With strictNullChecks enabled
let name: string;
name = 'John'; // OK
name = null;   // Error: Type 'null' is not assignable to type 'string'
```

**24. What are Memoization and Currying in functional programming?**

Memoization: Memoization is an optimization technique used to cache the results of expensive function calls and return the cached result when the same inputs occur again. This reduces redundant computations and improves performance.
Example:

```
function fibonacci(n: number): number {
  if (n <= 1) {
    return n;
  }
  
  // Check if result is already cached
  if (!fibonacci.cache) {
    fibonacci.cache = {};
  }
  if (fibonacci.cache[n]) {
    return fibonacci.cache[n];
  }

  // Compute Fibonacci number and cache result
  fibonacci.cache[n] = fibonacci(n - 1) + fibonacci(n - 2);
  return fibonacci.cache[n];
}

console.log(fibonacci(5)); // Output: 5
console.log(fibonacci(10)); // Output: 55
Currying: Currying is the process of converting a function that takes multiple arguments into a sequence of functions that each take a single argument. It allows for partial application of functions, enabling greater flexibility and reusability.
Example:

function add(x: number): (y: number) => number {
  return function(y: number): number {
    return x + y;
  };
}

const addFive = add(5);
console.log(addFive(3)); // Output: 8
console.log(addFive(7)); // Output: 12
```

**25. What are the differences between blocking and non-blocking code?**

Blocking code: In blocking code, the execution of subsequent code is halted until the current operation completes. This can lead to performance issues, especially in I/O-bound operations, where waiting for I/O operations to complete can cause delays.
Example (blocking file I/O in Node.js):

```
const fs = require('fs');

// Blocking code - reading a file synchronously
const data = fs.readFileSync('example.txt', 'utf8');
console.log(data); // Output: Contents of example.txt
console.log('End of program'); // This line will only execute after file read completes
Non-blocking code: In non-blocking code, the execution of subsequent code continues even if the current operation has not completed. This allows for more efficient use of resources and better handling of concurrent operations, especially in I/O-bound scenarios.
Example (non-blocking file I/O in Node.js):

const fs = require('fs');

// Non-blocking code - reading a file asynchronously
fs.readFile('example.txt', 'utf8', (err, data) => {
  if (err) {
    console.error(err);
    return;
  }
  console.log(data); // Output: Contents of example.txt
});

console.log('End of program'); // This line executes immediately without waiting for file read
```

**26. Can you explain the differences between Subject and BehaviorSubject in RxJS?**

Subject: A Subject in RxJS is a special type of Observable that allows values to be multicasted to multiple Observers. It is both an Observable and an Observer. When subscribed to, it will emit values to its subscribers.
BehaviorSubject: A BehaviorSubject in RxJS is a variant of Subject that requires an initial value and emits its current value to new subscribers. It retains the latest value emitted to its subscribers and emits that value immediately upon subscription.
Example:

```
import { Subject, BehaviorSubject } from 'rxjs';

// Subject example
const subject = new Subject<number>();
subject.subscribe(value => console.log('Subscriber A:', value));
subject.next(1); // Output: Subscriber A: 1
subject.subscribe(value => console.log('Subscriber B:', value));
subject.next(2); // Output: Subscriber A: 2, Subscriber B: 2

// BehaviorSubject example
const behaviorSubject = new BehaviorSubject<number>(0); // Initial value: 0
behaviorSubject.subscribe(value => console.log('Subscriber A:', value));
behaviorSubject.next(1); // Output: Subscriber A: 1
behaviorSubject.subscribe(value => console.log('Subscriber B:', value));
behaviorSubject.next(2); // Output: Subscriber A: 2, Subscriber B: 2
```

**27. What is a Standalone component?**

A Standalone component in Angular is a component that is not dependent on other Angular modules or services. It can be easily reused in different parts of the application without introducing additional dependencies.

Example:

```
import { Component } from '@angular/core';

@Component({
  selector: 'app-standalone',
  template: '<p>This is a standalone component</p>'
})
export class StandaloneComponent {
  // Component logic goes here
}
```

**28. How does Angular Routing work?**

Angular Routing allows you to build single-page applications by mapping URLs to views or components. When a user navigates to a specific URL, Angular’s router matches the URL to a route and loads the associated component into the designated router outlet in the application’s HTML.

Example:

```
const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'about', component: AboutComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' }
];
```

**29. What are Angular Lifecycle Hooks and how are they used?**

Angular Lifecycle Hooks are methods provided by Angular that allow you to tap into key moments in a component’s lifecycle, such as initialization, content projection, change detection, and destruction.

Example:

```
import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-lifecycle-example',
  template: '<p>Component Lifecycle Example</p>'
})
export class LifecycleExampleComponent implements OnInit, OnDestroy {
  constructor() { }

  ngOnInit() {
    console.log('Component initialized');
  }

  ngOnDestroy() {
    console.log('Component destroyed');
  }
}
```

**30. What is the role of NgModule in Angular applications?**

NgModule in Angular applications consolidates components, directives, pipes, and services into functional units and configures providers, routes, and dependencies for these components.

Example:

```
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
```

**31. What is the difference between Shadow DOM and Virtual DOM?**

Shadow DOM: Shadow DOM is a web standard that allows encapsulation of DOM and CSS within a component. It creates a scoped DOM subtree, ensuring that styles and functionality of a component do not affect or get affected by the outer document.

Example:

```
<custom-button>
  #shadow-root
    <style>
      button {
        background-color: blue;
        color: white;
      }
    </style>
    <button>Click me</button>
</custom-button>
```

`Virtual DOM`: Virtual DOM is a programming concept popularized by libraries like React. It’s a lightweight copy of the actual DOM kept in memory, used for efficient updates. Instead of directly manipulating the real DOM, changes are first made to the Virtual DOM, which is then compared with the actual DOM to determine the minimal set of changes needed for an update.

**32. What are Micro Frontends and how do they work?**

Micro Frontends is an architectural style where a web application is composed of loosely coupled, independently deployable frontend components. Each component, or Micro Frontend, is developed and deployed by a separate team, allowing for easier maintenance, scaling, and reusability.

Example:

```
<app-header></app-header>
<app-product-list></app-product-list>
<app-cart></app-cart>
<app-footer></app-footer>
```

**33. How can we create composite components in Angular without using @Input and @Output decorators?**

To create composite components in Angular without @Input and @Output decorators, we can leverage services for communication between components. Services act as a central hub for sharing data and functionality between components.

Example:

```
// data.service.ts
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  private dataSubject = new Subject<any>();
  data$ = this.dataSubject.asObservable();

  sendData(data: any) {
    this.dataSubject.next(data);
  }
}
// sender.component.ts
import { Component } from '@angular/core';
import { DataService } from './data.service';

@Component({
  selector: 'app-sender',
  template: '<button (click)="sendData()">Send Data</button>'
})
export class SenderComponent {
  constructor(private dataService: DataService) {}

  sendData() {
    this.dataService.sendData('Hello from sender!');
  }
}
// receiver.component.ts
import { Component, OnInit } from '@angular/core';
import { DataService } from './data.service';

@Component({
  selector: 'app-receiver',
  template: '<p>{{ receivedData }}</p>'
})
export class ReceiverComponent implements OnInit {
  receivedData: any;

  constructor(private dataService: DataService) {}

  ngOnInit() {
    this.dataService.data$.subscribe(data => this.receivedData = data);
  }
}
```

**34. Could you provide an overview of Webpack elements in Angular?**

Webpack is a module bundler that takes modules with dependencies and generates static assets representing those modules. In Angular, Webpack is used for bundling, code splitting, and optimizing the application’s assets for production deployment.

Example: Webpack configuration file (webpack.config.js):

```
const path = require('path');

module.exports = {
  entry: './src/index.js',
  output: {
    path: path.resolve(__dirname, 'dist'),
    filename: 'bundle.js'
  },
  module: {
    rules: [
      { test: /\.css$/, use: ['style-loader', 'css-loader'] },
      { test: /\.js$/, exclude: /node_modules/, loader: 'babel-loader' }
    ]
  }
};
```

**35. What are the differences between switchMap, concatMap, forkJoin, and mergeMap in RxJS?**

- `switchMap`: Maps each value to an Observable, then flattens all the inner Observables, emitting values only from the most recent Observable.
- `concatMap`: Maps each value to an Observable and then concatenates the resulting Observables, emitting values in order.
- `forkJoin`: Combines multiple Observables into a single Observable, emitting the last value from each Observable when all Observables complete.
- `mergeMap`: Maps each value to an Observable and then merges all the resulting Observables, emitting values concurrently.

Example:

```
import { of } from 'rxjs';
import { switchMap, concatMap, forkJoin, mergeMap } from 'rxjs/operators';

const source = of(1, 2, 3);

source.pipe(
  switchMap(value => of(`switchMap: ${value}`))
).subscribe(result => console.log(result));

source.pipe(
  concatMap(value => of(`concatMap: ${value}`))
).subscribe(result => console.log(result));

forkJoin(
  of('forkJoin: A'),
  of('forkJoin: B'),
  of('forkJoin: C')
).subscribe(results => console.log(results));

source.pipe(
  mergeMap(value => of(`mergeMap: ${value}`))
).subscribe(result => console.log(result));
```

**36. What is the role of Web Workers and Web Storage in web development?**

Web Workers: Web Workers allow you to run scripts in background threads, separate from the main execution thread of a web application. They enable tasks to be performed concurrently, improving performance and responsiveness.

Example:

```
// Create a new Web Worker
const worker = new Worker('worker.js');

// Send data to the worker
worker.postMessage({ message: 'Hello from main thread!' });

// Receive data from the worker
worker.onmessage = event => {
  console.log('Message from worker:', event.data);
};
```

`Web Storage`: Web Storage provides mechanisms for storing data in the browser, persisting data between page reloads or sessions. It includes localStorage and sessionStorage, both of which provide simple key-value storage.

Example:

```
// Storing data in localStorage
localStorage.setItem('username', 'John');

// Retrieving data from localStorage
const username = localStorage.getItem('username');
console.log('Username:', username); // Output: Username: John
```

**37. How does Web Storage work in web development?**

Web Storage works by providing a simple key-value storage mechanism that allows web applications to store data persistently in the user’s browser. It consists of two main APIs: localStorage and sessionStorage.

Example:

```
// Storing data in sessionStorage
sessionStorage.setItem('theme', 'dark');

// Retrieving data from sessionStorage
const theme = sessionStorage.getItem('theme');
console.log('Theme:', theme); // Output: Theme: dark
```

**38. What are Semantic Elements in HTML?**

Semantic elements in HTML are tags that convey meaning to both the browser and the developer, making the structure of a web page more descriptive and understandable. Examples of semantic elements include `<header>, <nav>, <section>, <article>, <footer>`, etc.

Example:

```
<header>
  <h1>Website Header</h1>
</header>
<nav>
  <ul>
    <li><a href="#">Home</a></li>
    <li><a href="#">About</a></li>
    <li><a href="#">Contact</a></li>
  </ul>
</nav>
<section>
  <article>
    <h2>Article Title</h2>
    <p>Article content goes here...</p>
  </article>
</section>
<footer>
  <p>My Website</p>
</footer>
```

**39. What is the significance of a pseudo-class in CSS?**

Pseudo-classes in CSS are used to define the special state of an element that cannot be represented by simple selectors. They allow you to style elements based on user interaction, such as hover, focus, or visited states.

Example:

```
/* Styling a link on hover */
a:hover {
  color: red;
}

/* Styling an input on focus */
input:focus {
  border-color: blue;
}
```

**40. Can you explain how to implement Border Radius in CSS?**

Border Radius in CSS allows you to round the corners of an element. You can specify a single value to apply the same radius to all corners or separate values to specify different radii for each corner.

Example:

```
/* Applying border radius to all corners */
.border-radius {
  border-radius: 10px;
}

/* Applying different border radius to each corner */
.custom-border-radius {
  border-top-left-radius: 20px;
  border-top-right-radius: 10px;
  border-bottom-left-radius: 5px;
  border-bottom-right-radius: 15px;
}
```

**41. What are the differences between Promise.all and Promise.settled in JavaScript?**

Promise.all: Takes an array of Promises and returns a single Promise that resolves when all the input Promises have resolved, or rejects with the reason of the first rejected Promise. It waits for all promises to settle, either resolve or reject.

Example:

```
const promise1 = Promise.resolve(1);
const promise2 = new Promise((resolve, reject) => setTimeout(reject, 100, 'Error'));

Promise.all([promise1, promise2])
  .then(values => console.log(values))
  .catch(error => console.log(error)); // Output: Error
```

`Promise.settled`: Takes an array of Promises and returns a single Promise that resolves with an array of objects representing the outcome of each promise, whether it resolved or rejected.

Example:

```
const promise1 = Promise.resolve(1);
const promise2 = new Promise((resolve, reject) => setTimeout(reject, 100, 'Error'));

Promise.allSettled([promise1, promise2])
  .then(results => console.log(results));
  /* Output: 
  [
    { status: 'fulfilled', value: 1 },
    { status: 'rejected', reason: 'Error' }
  ]
  */
```

**42. What are Generator Functions in JavaScript?**

Generator Functions in JavaScript are special types of functions that can pause execution and yield control back to the caller while maintaining their context. They use the function* syntax and the yield keyword to produce a series of values lazily.

Example:

```
function* generatorFunction() {
  yield 1;
  yield 2;
  yield 3;
}

const generator = generatorFunction();

console.log(generator.next().value); // Output: 1
console.log(generator.next().value); // Output: 2
console.log(generator.next().value); // Output: 3
console.log(generator.next().value); // Output: undefined
```

**43. What is the purpose of Change Detection in Angular?**

Change Detection in Angular is the mechanism used to detect and propagate changes made to the application’s data model to the user interface. It ensures that the view reflects the latest state of the data and is kept in sync with the underlying data model.

**44. What are some best practices for Angular development?**

- Some best practices for Angular development include:

Following the Single Responsibility Principle (SRP) for components.
Using Angular CLI for project setup and generation.
Utilizing Angular Modules to organize the application’s features.
Properly managing dependencies and avoiding tight coupling.
Using Angular’s built-in decorators and services for common tasks.
Writing unit tests and end-to-end tests for robust code coverage.

**45. How does dependency injection work in Angular?**

Dependency Injection (DI) in Angular is a design pattern used to create and manage objects and their dependencies. Angular’s DI framework provides dependencies to components, services, and other objects as requested, making it easier to create and test components independently.

Example:

```
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  getData() {
    return 'Data from DataService';
  }
}

@Component({
  selector: 'app-example',
  template: '{{ data }}'
})
export class ExampleComponent {
  constructor(private dataService: DataService) {}

  data = this.dataService.getData();
}
```
