import { TestBed } from '@angular/core/testing';

import { KambaService } from './kamba.service';

describe('KambaService', () => {
  let service: KambaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(KambaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
