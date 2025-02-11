import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import {ClarityModule} from "@clr/angular";
import {RouterModule} from '@angular/router';
import {FirstPageComponent} from "./components/first-page/first-page.component";
import { ImageComponent } from './components/image/image.component';
import { GalleryComponent } from './components/gallery/gallery.component';
import {ReactiveFormsModule, FormsModule } from "@angular/forms";
import { HttpClientModule } from '@angular/common/http';
import {CommonModule} from "@angular/common";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatButtonModule} from "@angular/material/button";

@NgModule({
  declarations: [
    AppComponent, ImageComponent, GalleryComponent, FirstPageComponent
  ],
  imports: [
    RouterModule.forRoot([
      {path: 'first-page', component: FirstPageComponent},
      {path: '', redirectTo: "/first-page", pathMatch: "full"},
      {path: 'images/:id', component: ImageComponent},
      {path: 'gallery', component: GalleryComponent}
    ]),
    MatTooltipModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    ClarityModule,
    HttpClientModule,
    CommonModule,
    BrowserAnimationsModule,
    MatButtonModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
