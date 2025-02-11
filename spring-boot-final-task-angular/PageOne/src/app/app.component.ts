import { Component } from '@angular/core';
import {BackEndService} from "./services/back-end.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  providers: [BackEndService]
})
export class AppComponent {
  title = 'ICS';
  constructor(public router: Router,
              private route:ActivatedRoute,
              private backend: BackEndService) {  }

}
