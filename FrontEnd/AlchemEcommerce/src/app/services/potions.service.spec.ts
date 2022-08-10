import { TestBed } from '@angular/core/testing';

import { PotionsService } from './potions.service';

describe('PotionsService', () => {
  let service: PotionsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PotionsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
