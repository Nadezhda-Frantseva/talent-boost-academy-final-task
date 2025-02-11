import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Image} from "../models/image.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class BackEndService {
  api = "http://localhost:8090/images";

  constructor(private httpClient: HttpClient) {}

  public categorize(url: string) : Observable<Image> {
    return this.httpClient.post<Image>(this.api, url) ;
  }

  public getById(id: number) : Observable<Image> {
    return this.httpClient.get<Image>(this.api +'/'+id);
  }

  public getAll() : Observable<Array<Image>> {
    return this.httpClient.get<Array<Image>>(this.api);
  }

  public getByTag(tag: string) : Observable<Array<Image>> {
    let finalUrl: string = this.api + "?tags=" + tag;
    console.log(finalUrl)
    return this.httpClient.get<Array<Image>>(finalUrl);
  }

}
