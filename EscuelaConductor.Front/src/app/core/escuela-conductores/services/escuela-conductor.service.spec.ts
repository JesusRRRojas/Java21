import { TestBed } from '@angular/core/testing';

import { EscuelaConductorService } from './escuela-conductor.service';

describe('EscuelaConductorService', () => {
  let service: EscuelaConductorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EscuelaConductorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
