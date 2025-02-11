import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup} from '@angular/forms';
import { BackEndService } from "../../services/back-end.service";
import { Image } from "../../models/image.model";
import { Router } from "@angular/router";

@Component({
  selector: 'app-first-page',
  templateUrl: './first-page.component.html',
  styleUrls: ['./first-page.component.scss']
})

export class FirstPageComponent implements OnInit {
  formGroup = new FormGroup({
    url: new FormControl(''),
  });
  public _categorizedImage:Image | null = null;
  constructor(private _httpService: BackEndService, private router: Router) {}

  ngOnInit(): void {}

  public analyze(e: Event): void {
    this._httpService.categorize(this.formGroup.controls['url'].value).subscribe(img => {
      this._categorizedImage = img;
      this.router.navigate(["/images/id", {id: this._categorizedImage.id }]);
    })
  }
}
