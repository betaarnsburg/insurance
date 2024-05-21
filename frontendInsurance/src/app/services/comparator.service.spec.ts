import { TestBed } from '@angular/core/testing';

import { ComparatorService } from './comparator.service';

describe('ComparatorService', () => {
  let service: ComparatorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ComparatorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
