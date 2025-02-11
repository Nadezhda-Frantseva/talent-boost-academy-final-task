import { Component, OnInit } from '@angular/core';
import {Image} from "../../models/image.model";
import {BackEndService} from "../../services/back-end.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-gallery',
  templateUrl: './gallery.component.html',
  styleUrls: ['./gallery.component.scss']
})
export class GalleryComponent implements OnInit {

  public images: Array<Image> = [];
  public searchedValue: string | null = "";

  constructor(private httpService: BackEndService, private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.httpService.getAll().subscribe(array => {
      this.images = array
    })
  }

  public search() {
    this.router.navigate([], {
      queryParams: {
        tags: this.searchedValue
      },
    });
    console.log( this.searchedValue)
    this.httpService.getByTag(<string><any>this.searchedValue).subscribe(array => {
      this.images = array;
      console.log(array)
    })
  }
}
