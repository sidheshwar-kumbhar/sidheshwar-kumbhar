import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SmkLoggerComponent } from './smk-logger.component';

describe('SmkLoggerComponent', () => {
  let component: SmkLoggerComponent;
  let fixture: ComponentFixture<SmkLoggerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SmkLoggerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SmkLoggerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
