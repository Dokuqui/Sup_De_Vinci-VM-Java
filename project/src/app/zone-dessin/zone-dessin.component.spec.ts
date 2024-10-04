import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZoneDessinComponent } from './zone-dessin.component';

describe('ZoneDessinComponent', () => {
  let component: ZoneDessinComponent;
  let fixture: ComponentFixture<ZoneDessinComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ZoneDessinComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ZoneDessinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
