import { NgModule } from "@angular/core";
import { BrowserModule } from "@angular/platform-browser";
import {AppComponent} from "./app.component"
import { RouterOutlet } from '@angular/router';

@NgModule({
    declarations:[AppComponent],
    imports:[BrowserModule, RouterOutlet],
    exports:[],
    bootstrap: [AppComponent]

})
export class AppModule {

}