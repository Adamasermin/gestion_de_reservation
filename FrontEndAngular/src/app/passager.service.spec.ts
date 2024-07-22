import { TestBed } from '@angular/core/testing';

import { PassagerService } from './components/passagers/passager.service';

describe('PassagerService', () => {
  let service: PassagerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PassagerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
