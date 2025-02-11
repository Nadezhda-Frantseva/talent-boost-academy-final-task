import { Component, OnInit } from '@angular/core';
import {Image} from "../../models/image.model";
import {BackEndService} from "../../services/back-end.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-image',
  templateUrl: './image.component.html',
  styleUrls: ['./image.component.scss']
})
export class ImageComponent implements OnInit {

  public categorizedImage: Image| null = null;

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private httpClient: BackEndService
  ) {
    this.activatedRoute.params.subscribe((params)=>{
      const id = parseInt(params['id']);
      this.httpClient.getById(<number><any>id).subscribe(categorizedImage => {
        this.categorizedImage = categorizedImage;
      })
    });
  }
  ngOnInit(): void {}
}

