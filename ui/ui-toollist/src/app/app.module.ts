import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ToolComponent } from './tool/tool.component';
import { ToolInputComponent } from './tool/tool-input/tool-input.component';
import { ToolPersonComponent } from './tool/tool-person/tool-person.component';
import { NavigationComponent } from './tool/navigation/navigation.component';

@NgModule({
  declarations: [
    AppComponent,
    ToolComponent,
    ToolInputComponent,
    ToolPersonComponent,
    NavigationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
