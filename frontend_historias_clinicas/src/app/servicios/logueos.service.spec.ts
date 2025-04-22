import { TestBed } from '@angular/core/testing';

import { LogueosService } from './logueos.service';

describe('LogueosService', () => {
  let service: LogueosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LogueosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
