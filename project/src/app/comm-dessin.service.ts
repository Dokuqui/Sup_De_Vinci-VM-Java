import { Injectable } from '@angular/core';
import { DessinModel } from './dessin-model';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class CommDessinService {

  constructor(public http: HttpClient) { }

  createNewDessin(newDessin: DessinModel) : Observable<DessinModel> {
    return this.http.post<DessinModel>("http://localhost:8080/api/v1/dessins/create", newDessin);
  }

  getAllDessins() : Observable<string[]> {
    return this.http.get<string[]>("http://localhost:8080/api/v1/dessins/get-list");
  }

  getDessinByName(name: string) : Observable<DessinModel> {
    return this.http.get<DessinModel>(`http://localhost:8080/api/v1/dessins/get-one/${name}`);
  }
}
