import { TestBed } from '@angular/core/testing';

import { BackEndService } from './back-end.service';

describe('ServiceService', () => {
  let service: BackEndService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BackEndService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
