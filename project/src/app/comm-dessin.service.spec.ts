import { TestBed } from '@angular/core/testing';

import { CommDessinService } from './comm-dessin.service';

describe('CommDessinService', () => {
  let service: CommDessinService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CommDessinService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
