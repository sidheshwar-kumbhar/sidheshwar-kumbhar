import { TestBed } from '@angular/core/testing';

import { SmkLoggerService } from './smk-logger.service';

describe('SmkLoggerService', () => {
  let service: SmkLoggerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SmkLoggerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
