import { Component, OnDestroy, OnInit } from '@angular/core';
import { Canvas, Circle } from 'fabric';
import { v4 } from "uuid";
import { CommDessinService } from '../comm-dessin.service';
import { DessinModel } from '../dessin-model';

@Component({
  selector: 'app-zone-dessin',
  templateUrl: './zone-dessin.component.html',
  styleUrl: './zone-dessin.component.css'
})
export class ZoneDessinComponent implements OnInit, OnDestroy {
  cnvFb!: Canvas

  txtInput: string = "(none)";

  listNames: string[] = [];

  constructor(private serviceDessin: CommDessinService) {
    console.log("Ctr ZoneDessin");
  }

  private loadAllDessin(): void {
    this.serviceDessin.getAllDessins().subscribe(
      {
        next: (value: string[]) => {
          console.log(value);
          this.listNames = value;
        },
        error: (err: any) => {
          console.log(err);
        }
      }
    )
  }

  public onLoadDessin(name: string) {
    this.serviceDessin.getDessinByName(name).subscribe(
    {
      next: (value: DessinModel) => {
        console.log("load ", name);
        console.log(value.content);
        this.cnvFb.loadFromJSON(value.content);
      },
      error: (err: any) => {
        console.log(err);
      }
    });
  }

  ngOnDestroy(): void {
    throw new Error('Method not implemented.');
  }

  ngOnInit(): void {
    this.loadAllDessin()
    //setInterval(() => {
    //  this.txtInput = new Date().toISOString();
    //}, 2000);

    this.cnvFb = new Canvas("hidCanvas", {
      backgroundColor: '#ebebef',
      selection: false,
      preserveObjectStacking: true,
    });

    const circle = new Circle({
      radius: 50,
      fill: 'red',
      left: 100,
      right: 100
    });
  
    this.cnvFb.add(circle);

    console.log(this.cnvFb.toJSON());
  }

  onSave(): void {
    console.log("call on save", this.txtInput);
    const nameStr = v4();
    const leModel: DessinModel = new DessinModel();
    leModel.auteur = "toto";
    leModel.nom = nameStr;
    leModel.content = JSON.stringify(this.cnvFb.toJSON());
    this.serviceDessin.createNewDessin(leModel).subscribe(
      {
        next: (value: DessinModel) => {
          console.log("Creation OK");
        },
        error: (err: any) => {
          console.log(err);
        }
      }
    );
  }
}
